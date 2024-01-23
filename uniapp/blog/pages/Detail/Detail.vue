<template>
	<view class="detail">
		<view class="container">
			
			<!-- 加载骨架 -->
				<view v-if="loadingStatus" class="skeleton">
					<!-- 没请求回来时就显示骨架屏 -->
					<u-skeleton
					:loading="loadingStatus" 
					:animation="true" 
					bgColor="#FFF"
					:rows="4"
					title
					avatar
					></u-skeleton>
					
					</view>
					
					
				<!-- 页面内容 -->
				<view v-else>
					<!-- 用户信息 -->
					<view class="title">{{blogDetail.title}}</view>
					<view class="userinfo">
						<view class="avatar">
							<image :src="getUserAvatar(blogDetail)" mode="aspectFill"></image>
						</view>
						<view class="text">
							<view class="name">{{getUserName(blogDetail)}}</view>
							<view class="small">
						<uni-dateformat :date="blogDetail.publish_date" format="MM月dd hh:mm" ></uni-dateformat>	
								· 发布于{{blogDetail.province}}</view>
						</view>
					</view>
					
					<!-- 文章内容 -->
					<view class="content">
				<!-- 这里必须要把html改为 content才会显示-->
				<!-- 设置了显示动画 可复制内容  自定义样式 -->
						<u-parse :content="blogDetail.content" :show-with-animation="true" :selectable="true" :tag-style="style"></u-parse>
					</view>
					
				</view>
			
			<!-- 点赞数量 -->
			<view class="like" >
				<view class="btn" :class="islike?'active':''">
					<text @click="addLike"  class="iconfont icon-good-fill"></text>
					<!-- 判断点赞数，如果为0就显示 文字 "点赞" -->
					<text>{{blogDetail.like_count==0?'点赞':blogDetail.like_count}}</text>
				</view>								
				<view class="users">					
					<image src="../../static/images/user.jpg" mode="aspectFill" ></image>
				</view>				
				<view class="text"><text class="num">{{blogDetail.view_count}}</text>人看过</view>
			</view>
			
		</view>
	</view>
</template>

<script>
		import {
			getUserAvatar,getUserName
		} from '@/utils/tools.js'
	
	import {
		store,
		mutations
	} from '@/uni_modules/uni-id-pages/common/store.js'
	
	const db=uniCloud.database()
	const utilobj = uniCloud.importObject('utilobj',
	// 关闭加载提示
	{customUI:true})
	export default {
		data() {
			return {
				
				// 博客信息对象
				blogDetail:{},
				// 是否点赞
				islike:false,
				// 骨架屏状态
				loadingStatus:true,
				// 文章id
				artid:'',
				
				// 设置文章内容样式
				style: {
				// 字符串的形式
				p: 'line-height: 1.7em;font-size: 16px;  ;padding:10rpx;',
				image:'margin:20rpx; text-align: center;'								
				},
				
				// 点赞的限制时间
				likeTime:null
				

			};
		},
		// 
		onLoad(e){
			// 判断文章id存不存在，如果不存在就跳转回首页，防止卡在这个页面
			if(!e.id){
				console.log('id不存在');
				this.errShow()
				// 要判断id错误返回，则需要在发起一次请求后判断data是否为空
				// id错误是请求不回数据的
				
				// 一定要写return否则会继续向下执行
				return
	
			}else{
				
				// 存在就获取id
				console.log(e);
				this.artid=e.id
				this.getArtDetail()
			}
			
			// 每次点进文章时就会增加阅读量
			this.UpdataCount('blogArticles','view_count',1)
		},
		methods:{
			getUserAvatar,getUserName,
			// 点赞
			// 这里必须要使用async和await才能获取到数据，因为返回值是promise对象，使用.then就是promise对象，如果用await就会同步化成普通对象，所有就没有.then方法
		async addLike(){
			
			// 判断用户是否登入登入后才可以操作
			if(store.hasLogin) {
				let addLikeTime=Date.now()
				// 如果likeTime不存在或者是其他内容，相减然后在比大小，最终还是false。就可以点赞
				if(addLikeTime-this.likeTime<2000){
					uni.showToast({
						title:'操作太频繁，请稍后',
						icon:'none'
					})
					return
				}
				
				// 通过实践发现，点击后出发数据库查询，修改在通过then方法非常慢，用户就是觉得卡。
				// 通过直接修改本地数据源来快速呈现变化，后续再修改后台再修改数据
				// 根据点赞样式来判断当前是否点了赞，刚好是布尔值，true就会--，极大提高效率
				// 先对数量进行修改再对样式进行修改，否则可能会导致数量显示会闪。因为islike会被修改然后重新渲染
				this.islike?this.blogDetail.like_count--:this.blogDetail.like_count++
				// 点赞样式取反
				this.islike=!this.blogDetail.islike
				
				
				// 每点赞一次就会被赋值一次点赞时间
				this.likeTime=addLikeTime
				
				// 一个方法内部不要写太多操作太多逻辑，要拆分提高可读性等
				this.addLikeToDatabase()
					 
			}else{
				uni.showModal({
					title:'登入后才可以点赞哦',
					icon:'none',
					confirmText:'去登入'
				}).then(res=>{
					if( res.confirm) uni.navigateTo({
						url:'/uni_modules/uni-id-pages/pages/login/login-withpwd'
					}).then(res=>{
						console.log('跳转登入成功');
						console.log(res);
						// 登入前设置缓存,登入后根据缓存回来,
						uni.setStorageSync('logInArtId',this.artid)
					})
				})
			}
			
			
			},
			
			
			// 将数据添加到数据库
			async addLikeToDatabase(){
				
						// 获取的文章id要和当前文章相同，并且也要校验是否是当前用户，否则就把别人的赞给点了或者取消了
						// 使用count计算数据查询到的数量，如果查询到1就说明点赞了，0则没有点。点赞了会记录消息
					let likeStatus= await  db.collection('blog_like').where(`article_id=='${this.artid}'&& user_id==$cloudEnv_uid`).count()
								 console.log(likeStatus.result);
				
								 // 用户id
								// $cloudEnv_uid
								
								// 做判断，如果用户已经点过赞，再点一次就是取消,total=0时是false
								if(likeStatus.result.total){
									// 已经点过赞就删除这条数据
									db.collection('blog_like').where(`article_id=='${this.artid}'&& user_id==$cloudEnv_uid`).remove().then(res=>{
										console.log('取消喜欢')
										// 将点赞样式取消
										this.islike=false
										// 将点赞数据添加文章表
										this.UpdataCount('blogArticles','like_count',-1)
										
									}).catch(res=>{
										console.log('添加失败');
										this.errShow()
									})
					
								}else{
									console.log('添加喜欢');
									// 点赞就会添加数据到点赞表
									db.collection('blog_like').add({
										// 文章id
										article_id:this.artid,		 
									}).then(res=>{
										// 添加点赞样式
										this.islike=true		
										// 将点赞数据添加文章表
										this.UpdataCount('blogArticles','like_count',1)
									}).catch(res=>{
										console.log('喜欢失败');
										this.errShow()
									})
									
								}
								
				
			},
			
			
				
			// 封装增加点赞和评论等数量的方法
			UpdataCount(table,attr,num){
				/**
				 * method1方法描述
				 * @param {object} table 要修改的数据表  参数1描述
				 * @param {object} attr  点赞或收藏 评论的属性
				 * @param {object} id    文章ID
				 * @param {object} num   自增或自减的量
				 */
				utilobj.operation(table,attr,this.artid,num).then(res=>{
					console.log(attr+'增加成功');
					// 重新获取数据,让点赞数量刷新
					this.getArtDetail()
				})
				
			},
		
			// 增加阅读量
			readUpdate(){
				// 传递参数
				utilobj.operation('blogArticles','view_count',this.artid,3).then(res=>{
					console.log('增加成功');
				})
			},
			
			
			
			// 报错提示
			errShow(){
				uni.showToast({
					title:'文章参数错误',
					icon:'error',
				})
				// 提示完成后一秒返回首页
				setTimeout(()=>{
					uni.reLaunch({
						url:'/pages/index/index'
					})
				},1000)
			}
			
			
			,
			// 获取到文章信息表
			 getArtDetail(){
				// 三连表查询全部信息，包括当前用户是否点赞
			let blogTemp= db.collection('blogArticles').where(`_id=='${this.artid}'`).getTemp()
			let userInfoTemp= db.collection('uni-id-users').field('_id,username,avatar_file').getTemp()
			
			// 获取当前用户是否点过赞，blogArticles里面是没有当前用户是否点赞的消息的，所以需要连表查询当前用户是否点赞
			let likeStatusTemp=  db.collection('blog_like').where(`article_id=='${this.artid}'&& user_id==$cloudEnv_uid`).getTemp()	
				
				// 当用户没有登入时就不添加likeStatusTemp进行联查
				
			let isLoginTableConnetion=[blogTemp,userInfoTemp]
			
			// 是否登入可以通过本地缓存来查看，登入就将likeStatusTemp加到联查数组里
			if	(store.hasLogin) isLoginTableConnetion.push(likeStatusTemp)
				
				// 将全部信息一起查询然后放到变量里,不支持数组但可以结构
				db.collection(...isLoginTableConnetion).get({
					getOne:true
				}).then(res=>{
					console.log('文章的全部信息');
					console.log(res);
					// 预判可能会出现的错误
					if(!res.result.data){
						// id错误直接返回首页
						console.log('返回数据为空');
						this.errShow()
						return
					}
						// 不为空时将数据存储
						this.blogDetail=res.result.data
						// 马上将标题更改为当前博客标题
						uni.setNavigationBarTitle({
							title:this.blogDetail.title
						})
						
						// 判断登入用户是否点过赞，点过就高亮显示。点赞会有记录在点在表内，如果能查到就是点过 
						// 防止用户从各种角度跳转到这个页面来,所以要设置没有任何信息时的样式,否则会报错
						 if(store.hasLogin) this.islike=res.result.data._id?.blog_like?.length ?true :false ?? false
						
						// 数据请求回来会就隐藏
						this.loadingStatus=false
				}).catch(err=>{
					console.log(err);
					// 其他错误情况也跳转回来，提高严谨性
					this.errShow()
				})
				
				
			}
		}
	}
</script>

<style lang="scss">
	
.skeleton{
	margin:20rpx;
}

.detail{
	background: #f8f8f8;
	min-height: calc(100vh - var(--window-top));	
	
	.container{
		padding:30rpx;	
		background: #fff;

		.title{
			font-size: 46rpx;
			color:#333;
			line-height: 1.4em;
			font-weight: 600;
		}
		.userinfo{
			padding:20rpx 0 50rpx;
			display: flex;
			align-items: center;
			.avatar{
				width: 60rpx;
				height: 60rpx;
				padding-right: 15rpx;
				image{
					width: 100%;
					height: 100%;
					border-radius: 50%;
				}
			}
			.text{
				font-size: 28rpx;
				color:#555;
				.small{
					font-size: 20rpx;
					color:#999;
				}
			}
		}
		.content{
			
		}
		.like{
	
			display: flex;
			flex-direction: column;
			align-items: center;
			padding:80rpx 50rpx 50rpx;
			.btn{
				width: 260rpx;
				height: 120rpx;
				background: #e4e4e4;
				border-radius: 100rpx;
				color:#fff;
				display: flex;
				justify-content: center;
				align-items: center;
				flex-direction: column;
				font-size: 28rpx;
				.iconfont{
					font-size: 50rpx;
				}
				&.active{
					background: #0199FE;
				}
			}
			.text{
				font-size: 26rpx;
				color:#666;				
				.num{
					color:#0199FE
				}
				.spot{
					padding:0 10rpx;
				}
			}
			.users{
				display: flex;
				justify-content: center;
				padding:30rpx 0;
				image{
					width: 50rpx;
					height: 50rpx;
					border-radius: 50%;
					border:3px solid #fff;
					margin-left:-20rpx;
				}
			}
		}
		
	}
	.active{
		background: #0199FE;
	}
}
</style>
