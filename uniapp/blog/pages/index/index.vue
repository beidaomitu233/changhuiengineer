<template>
	<view class="home">

		<view class="nav">
			<u-tabs :list="navlist" :current="currentNavAction" @click="change(currentNavAction,$event)"></u-tabs>
		</view>
		

			<view class="loadingState" v-show="loading"  >
				<u-skeleton 
				:loading="loading" 
				:animation="true" 
				bgColor="#FFF"
				:rows="4"
				title
				avatar
				></u-skeleton>
				
			</view>


		<!-- 主体内容区 -->
		<view class="content">
			<view class="ArticleList" v-for="(item,index) in DateArticle" :key="index">
		<!-- 以传参的方式把整个文章数据对象传递过去 -->
				<ArticleItem :item="item" ></ArticleItem>
			</view>
		</view>


		<!-- 编辑图标 -->
		<view class="edit" @click="toedit">
			<span class="iconfont">&#xe8dc</span>
		</view>

	</view>
</template>

<script>
	const db=uniCloud.database()
	export default {
		data() {
			return {
				navlist: [{
					// type是用于动态排序文章用的，后续就可以根据type动态绑定倒叙的属性
					name: '热门',
					type:'view_count'
				}, {
					name: '最新',
					type:'publish_date'
				}],
				
				// 骨架显示状态
				loading:false,
				
				// 文章列表
				DateArticle:[],
				
				// 导航栏选中,第一个是0，第二个是1。默认选中第一个
				currentNavAction:0
			}
		},
		onLoad() {
			this.getArticle()
		},
			
		onLaunch(){
			this.getArticle()
		},
		methods: {
			change(index, e) {
				// 根据点击大栏目来加载该栏目的内容
				this.currentNavAction = e.index;
				console.log(e);
				// 先初始化文章列表
				this.DateArticle=[]
				// 从新获取一次
				this.getArticle()
			},
			toedit(){
				uni.navigateTo({
					url:'/pages/edit/edit'
				})
			},
			
			getArticle(){
				this.loading=true
				// 使用JQL语法进行连表用户表和文章表查询
				let artTemp=db.collection('blogArticles').field('user_id,content,description,province,title,picurls,comment_count,like_count,view_count,publish_date').getTemp()
				// 只要用户名和头像
				let userTemp=db.collection('uni-id-users').field('_id,username,avatar_file,nickname').getTemp()
				
				// 根据发布时间倒叙排列，变量形式的倒叙排列写法
				db.collection(artTemp,userTemp).orderBy(this.navlist[this.currentNavAction].type,'desc').get().then(res=>{
					// 
					console.log('获取到全部文章信息');
					console.log(res);
					this.DateArticle=res.result.data
					
					this.loading=false
				})
				console.log(this.DateArticle);
			}
			
		},
	}
</script>

<style lang="scss" scoped>
	.nav {
		margin-bottom: 30rpx;
	}
	
	// 骨架状态
	.loadingState{
		padding: 40rpx;
	}
	
	// 主体内容区css
	.content{
		// 设置每个博客文章的样式
		.ArticleList{
			padding: 30rpx 40rpx;
			
			
		}
	}
	
	// 编辑按钮样式
	.edit{
		width: 130rpx;
		height: 130rpx;
		background-color: #0199FE;
		border-radius: 50%;
		
		position: fixed;
		right: 50rpx;
		bottom: 150rpx;	
		
		z-index: 100;
		display: flex;
		justify-content: center;
		align-items: center;
		
		box-shadow: 0 0 20rpx rgba(1,153,254,0.8);
		
		// 图标大小
		.iconfont{
			font-size: 50rpx;
		}
		
		}
</style>