<template>
	<view class="blog">
		<!-- 用户信息栏 -->
		<view class="head" v-if="hideContent.userinfo">
			
			<!-- 左侧信息栏 ，可传递参数确定是否显示-->
			<view class="userinfo" >
				<view class="avatar">
					<!-- 如果用户头像存在就使用用户头像否则就使用默认头像 -->
				<cloud-image  :src="getUserAvatar(item)"></cloud-image>
										</view>
			<view class="name">{{getUserName(item)}}</view>
			<view class="time">
				<uni-dateformat :date="Date.now()" format="MM月dd hh:mm" ></uni-dateformat>
			</view>
			
		</view>
			
			<!-- 右侧更多按钮 -->
			<view class="more">
				<text class="iconfont icon-ellipsis"></text>
			</view>
		</view>
		
		
		<!-- 主体内容区 -->
		<view class="body">
			<!-- 点击文章标题或简介文字是跳转到详情页 -->
			<view class="title" @click="toDetail" >{{item.title}}</view>
			<view class="text" @click="toDetail">
				<view class="t">{{item.description}}</view>
			</view>
			
			<!-- 图片模块 -->
			<view class="piclist">
				<!-- 给图片添加圆角，并且判断只有一个图片时添加only样式 -->
				<view @click="previewImage(index,item.picurls)" class="pic" :class="item.picurls.length==1 ? 'only': ''" v-for="(img,index) in item.picurls" :key="index">
					<image :src="img" mode="aspectFill" ></image>
				</view>					
			</view>
		</view>
		
		
		<view class="info" v-if="hideContent.info">
			<view class="box" @click="addView"><text class="iconfont icon-a-27-liulan"></text> <text>{{item.view_count}}</text></view>
			<!-- 判断是否有点赞和评论数量，如果没有就显示 文字 引导点赞和评论 -->
			<view class="box" @click="addComment"><text class="iconfont icon-a-5-xinxi"></text> <text>{{item.comment_count?item.comment_count:'评论' }}</text></view>
			<view class="box" @click="addLike"><text class="iconfont icon-a-106-xihuan"></text> <text>{{item.like_count?item.like_count:'点赞'}}</text></view>
		</view>
		
		
		
		
	</view>
</template>

<script>
		import {
			getUserAvatar,getUserName
		} from '@/utils/tools.js'
	
	export default {
		name:"ArticleItem",
		props:{
			item:{
				type:Object,
				default(){
					return{
						
					}
				}
			},
			hideContent:{
				type:Object,
				default(){
					return{
						userinfo:true,
						info:true
					}
				}
			}
		},
		data() {
			return {
			defaults:require('@/static/images/user-fill.png')
			};
		},
		methods:{
			// 仅用于注册
			getUserAvatar,getUserName,
			// 点击图像时可以预览
			previewImage(index){
				uni.previewImage({
					current:index,
					urls:this.item.picurls,
					loop:true
				})
			},
			// 跳转详情页
			toDetail(){
				// 获取当前的新闻的ID，根据id跳转
				uni.navigateTo({
					url:`/pages/Detail/Detail?id=${this.item._id}`
				})
			}
			// 点赞 评论 观看
		}
	}
</script>

<style lang="scss" scoped>

.blog{
	border-bottom: 1px solid black;
	padding-bottom: 30rpx;
	// 组件头栏目
	.head{
		display:flex;
		font-size: 32rpx;
		align-items: center;
		// 布局左侧信息栏和右侧更多按钮
		justify-content: space-between;
		// 用户信息栏样式
		.userinfo{
			display: flex;
			align-items: center;
			//用户头像
			.avatar{ 
				width: 40rpx;
				height: 40rpx;
				border-radius: 50%;
				border-radius: 50%;
				overflow: hidden;
				image{ 
					width: 100%;
					height: 100%;
					display: block;
				}
			}
			// 用户名信息
			.name{				
				color:#222;				
				padding-left:10rpx;
			}
			// 发布事件
			.time{
				color:#888;
				font-size: 22rpx;
				padding-left:20rpx;
			}
		}
		// 更多按钮
		.more{
			padding:5rpx;			
			.iconfont{ 
				font-size: 50rpx;
				color:#888;
			}
		}
	}
	
	
	// 主体内容部分
	.body{
		padding:15rpx 0 30rpx;
		.title{
			font-size: 44rpx;
			color:#000;
			font-weight: 600;	
			text-align: justify;
			// 只显示一行标题
			text-overflow: -o-ellipsis-lastline;
			overflow: hidden;				
			text-overflow: ellipsis;		
			display: -webkit-box;			
			-webkit-line-clamp: 1;			
			line-clamp: 1;					
			-webkit-box-orient: vertical;	
		}
		.text{
			padding-top:10rpx;
			padding-bottom:10rpx;
			font-size: 30rpx;
			text-align: justify;
			color:#888;

			.t{
				text-overflow: -o-ellipsis-lastline;
				overflow: hidden;				
				text-overflow: ellipsis;		
				display: -webkit-box;			
				-webkit-line-clamp: 2;			
				line-clamp: 2;					
				-webkit-box-orient: vertical;	
			}
		}
		// 图片列表
		.piclist{
			display: flex;
			padding-top:20rpx;
			.pic{
				width: 225rpx;
				height: 225rpx;
				margin-right: 6rpx;
				overflow: hidden;
				image{
					width: 100%;
					height: 100%;
				}
				// 显示三张图片时，第一章左上和左下圆角
				 &:first-child{
					border-radius: 20rpx 0 0 20rpx;					
				}
				// 最后一张图片右上和右下圆角
				 &:last-child{
					border-radius: 0 20rpx 20rpx 0;					
				}
				// 只有一张图片就全部圆角
				 &.only{
					border-radius: 20rpx;
				}
				
			}

			
		}
	}
	
	// 点赞栏目
	.info{
		display: flex;
		align-items: center;
		justify-content:space-around;
		font-size: 26rpx;	
		color:#333;
		.box{
			display: flex;
			align-items: center;			
			padding:15rpx 0 5rpx;
			flex:1;
			display: flex;
			justify-content: center;
			.iconfont{
				font-size: 40rpx;
				padding-right: 10rpx;
			}
		}
		
	}
	
}

</style>