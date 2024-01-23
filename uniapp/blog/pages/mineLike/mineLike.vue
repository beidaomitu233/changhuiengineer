<template>
	<view class="mineLike">
		
		<view class="ArticleList" v-for="(item,index) in DateArticle" :key="index">
		<!-- 以传参的方式把整个文章数据对象传递过去 -->
				<ArticleItem :item="item" :hideContent="hideContent" ></ArticleItem>
		</view>
		
	</view>
</template>

<script>
	const db=uniCloud.database()
	export default {
		data() {
			return {
				// 骨架显示状态
				loading:false,
				
				// 文章列表
				DateArticle:[],
				
				// 隐藏的内容 false为不显示，true为显示
				hideContent:{
					// 隐藏作者信息
					userinfo:true,
					// 隐藏点赞信息等
					info:false
				},
				
				
				
			};
		},
			 onLoad() {
				 this.getUserLike()
			},
		
		methods:{
			// 获取用户的点赞列表
			async getUserLike(){
				let userLikeList=[]
				// 联查 用户喜欢信息记录表，文章表（获取文章标题等），用户表（获取作者信息）
				const userLike= await db.collection('blog_like').where('user_id==$cloudEnv_uid').get()
				console.log(userLike);
				// 将所有的喜欢的文章ID存到数组
				userLike.result.data.forEach((currentValue, index)=>{
						console.log('获取到喜欢的文章ID');
						console.log(currentValue.article_id);
						userLikeList.push(currentValue.article_id)
					})
			
				console.log('用户喜欢列表');
				console.log(userLikeList);
				
				// 将用户的喜欢列表进行连表查询文章和对应作者
					userLikeList.forEach((currentValue, index)=>{	
						// userLikeList[index]对应的是每篇文章，
							console.log(userLikeList[index]);
							const artclelist=db.collection('blogArticles').where(`_id=='${userLikeList[index]}'`).getTemp()
							const userInfo=db.collection('uni-id-users').field('_id,username,nickname,avatar_file').getTemp()
							
							// 连表查询内容
							db.collection(artclelist,userInfo).get().then(res=>{
								console.log('用户喜欢的文章');
								console.log(res);
								// 将数据存储到本地，只能使用push因为在forEach内部。
								//res.result.data默认是数组。需要结构成对象
								this.DateArticle.push(...res.result.data)					
							}).catch(error=>{
								uni.showToast({
									title:'获取喜欢列表出错',
									icon:'error'
								})
								console.log(error);
							})
					})
					console.log('用户喜欢的文章全部列表');
					console.log(this.DateArticle);
				
			}
			
			


		},
		

		
	}
</script>

<style lang="scss">

	.mineLike{
		padding: 30rpx;
	}
	.ArticleList{
		padding: 30rpx 0;
	}
	
	
	.item{
			display: flex;
			justify-content: space-between;
			align-items: center;
			padding:25rpx 0;
			font-size: 36rpx;
			color:#555;
			border-bottom:1rpx solid #f8f8f8;
			.left{
				display: flex;
				align-items: center;
				.iconfont{
					font-size: 38rpx;
					margin-right: 10rpx;
				}
			}
			.right{
				.iconfont{
					font-size: 26rpx;
				}
			}
		}
		.item:last-child{
			border: none;
		}
	
</style>
