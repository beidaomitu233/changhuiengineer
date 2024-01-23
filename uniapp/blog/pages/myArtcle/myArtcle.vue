<template>
	<view class="myArtcle">
		
		
		<view class="authorCreationInfo">
			<view class="CreationInfoTitle">
				创作情况
			</view>
			<view class="info">
				<view class="item"><text>{{DateArticle.length}}</text>发文</view>
				<!--使用计算属性动态获取数据，在使用格式化函数，返回易理解的格式  -->
				<view class="item" ><text>{{formatViews(countNumber.like_count)}}</text>获赞</view>
				<view class="item"><text>{{formatViews(countNumber.comment_count)}}</text>评论</view>
				<view class="item"><text>{{formatViews(countNumber.view_count)}}</text>总阅览量</view>
				
			</view>
		</view>
		
		<view class="ArticleList" v-for="(item,index) in DateArticle" :key="index">
		<!-- 以传参的方式把整个文章数据对象传递过去 -->
				<ArticleItem :item="item" :hideContent="hideContent" ></ArticleItem>
		</view>
		
	</view>
</template>

<script>
	import {getUserArticle,formatViews} from '@/utils/tools.js'
	export default {
		data() {
			return {
				// 骨架显示状态
				loading:false,
				
				// 文章列表
				DateArticle:[],
				
				// 隐藏的内容
				hideContent:{
					// 隐藏作者信息
					userinfo:false,
					// 隐藏点赞信息等
					info:true
				},

				
			};
		},
		// 必须要使用async对promise对象进行结构，因为。调用this.viewNumber()之前，this.DateArticle可能还没有被正确地赋值。
			// 可以使用async/await来等待Promise对象的解决。
			async onLoad() {
			  try {
				// 获取用户文章，返回的是一个promise对象
				this.DateArticle = await getUserArticle();
				console.log('本地数据');
				console.log(this.DateArticle);

			  } catch (error) {
				console.error(error);
			  }
			},
		
		methods:{
			formatViews,
		},
		
		computed:{
			 //计算 阅览 /点赞/评论 数量
			// item 为点赞like_count/评论comment_count /阅览view_count   数量变量
			countNumber(){
				let view_count=0
				let	like_count=0
				let comment_count=0
				// currentValue：当前正在处理的元素。 index：当前元素的索引。
				this.DateArticle.forEach((currentValue, index)=>{
					view_count+=currentValue.view_count
					like_count+=currentValue.like_count
					comment_count+=currentValue.comment_count
				})
				return {view_count,like_count,comment_count}
			}
		}
		
	}
</script>

<style lang="scss">

	.myArtcle{
		padding: 30rpx;
	}
	.ArticleList{
		padding: 30rpx 0;
	}
	
	.CreationInfoTitle{
		font-size: 52rpx;
		font-weight: bold;
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
