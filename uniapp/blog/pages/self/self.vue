<template>
	<view class="user">
		<view class="top">
			<!-- 跳转到个人信息页面 -->
			<view class="group" @click="setuserInfo">
				<view class="userinfo">
					<view class="pic">
						<!-- 判断是否有登入信息 -->
					<!-- 使用工具函数可以提高可读性并且优化代码质量 -->
						<cloud-image width="150rpx" height="150rpx" v-if="hasLogin"  :src="getUserAvatar(userInfo)"></cloud-image>
						<image v-else src="../../static/images/user-default.jpg" mode=""></image>
					</view>
					<view class="text" v-if="hasLogin">
						<view class="nickname">{{getUserName(userInfo)}}</view>
						<view class="year">
					
							<uni-dateformat :date="userInfo.register_date - 360000" :threshold="[3600,99*365*24*60*60*1000]"></uni-dateformat>
							注册</view>
					</view>
					<view class="text" v-else>
						<view class="nickname">点击登录</view>
					</view>
					
				</view>
				
				<view class="more">
					<text class="iconfont icon-a-10-you"></text>
				</view>
			</view>
			
			<!--  -->
			<view class="bg">			
				<!--  -->
				<image v-if="hasLogin&&userInfo.avatar_file&&userInfo.avatar_file.url" :src="userInfo.avatar_file.url"></image>
							
				<image v-else src="../../static/images/user-default.jpg" mode="aspectFill" ></image>
			</view>
		</view>
		
		
		
		<view class="main">
			<view class="info">
				<view class="item" @click="showzz"><text>33</text>获赞</view>
				<view class="item"><text>11</text>评论</view>
				<view class="item"><text>5</text>发文</view>
			</view>
			
			<view class="list">
				<view class="group">					
					<view class="item" @click="toMyAtrcle">
						<view class="left"><text class="iconfont icon-a-24-bianji"></text><text class="text">我的文章</text></view>
						<view class="right"><text class="iconfont icon-a-10-you"></text></view>
					</view>
					<view class="item" @click="toMineLike">
						<view class="left"><text class="iconfont icon-a-106-xihuan"></text><text class="text">我的点赞</text></view>
						<view class="right"><text class="iconfont icon-a-10-you"></text></view>
					</view>
					<view class="item" @click="toHasComment">
						<view class="left"><text class="iconfont icon-a-21-xiugai"></text><text class="text">评论过的</text></view>
						<view class="right"><text class="iconfont icon-a-10-you"></text></view>
					</view>
				</view>
				
				<view class="group">
					<view class="item">
						<view class="left"><text class="iconfont icon-a-32-wenjian"></text><text class="text">关于</text></view>
						<view class="right"><text class="iconfont icon-a-10-you"></text></view>
					</view>		
					<view class="item" @click="toFeedBack">
						<view class="left"><text class="iconfont icon-a-5-xinxi"></text><text class="text">意见反馈</text></view>
						<view class="right"><text class="iconfont icon-a-10-you"></text></view>
					</view>	
				</view>
				
				<view class="group">
					<view class="item">
						<view class="left" @click="logOut"><text class="iconfont icon-a-73-tuichu"></text><text class="text">退出登录</text></view>
						<view class="right"><text class="iconfont icon-a-10-you"></text></view>
					</view>					
				</view>
			</view>
		</view>
		
		
	</view>
</template>

<script>
		import {
			getUserName,getUserAvatar
		} from '@/utils/tools.js'
	
	import {
		store,
		mutations
	} from '@/uni_modules/uni-id-pages/common/store.js'
	export default {
		data() {
			return {

			};
		},
		computed:{ 
			// userInfo和hasLogin都是uni-id体系的用户资料对象，
			userInfo() {
				return store.userInfo
			},
			hasLogin(){
				return store.hasLogin
			},
		},

		methods:{
			getUserName,getUserAvatar,
			//退出登入
			logOut(){
				// 首先要查看是否登入，如果登入了，才能退出
				if(this.hasLogin){
					uni.showModal({
						title:'确认退出登入',
						success:res=>{
							console.log(res);
							// 等于true则表示点击确认
							if(res.confirm){
								// 已经写好的退出登入逻辑
								mutations.logout()
							}
						}
					})
				}else{
					uni.showToast({
						title:'您还未登入',
						icon:'none',
					})
					return
				}

			},
			// 登入状态下去到个人主页
			setuserInfo(){
				uni.navigateTo({
					url:'/uni_modules/uni-id-pages/pages/userinfo/userinfo'
				})
			},
			
			// 按钮栏
			
			// 查看我的博客
			toMyAtrcle(){
				uni.navigateTo({
					url:'/pages/myArtcle/myArtcle',
				})
			},
			// 查看我的喜欢
			toMineLike(){
				uni.navigateTo({
					url:'/pages/mineLike/mineLike'
				})
			},
			
			// 评论过的文章
			toHasComment(){
				uni.navigateTo({
					url:'/pages/hasComment/hasComment'
				})
			},
			// 反馈页面
			toFeedBack(){
				uni.navigateTo({
					url:'/uni_modules/uni-feedback/pages/opendb-feedback/opendb-feedback'
				})
			}
			
			
			
			
			
		}
	}
</script>

<style lang="scss">
.user{
	
	.top{
		height: 300rpx;
		background: #bbb;
		padding:0 30rpx;
		// 兼容小程序，防止按钮错位，其实高度减去小程序栏的高度
		padding-top:var(--status-bar-height);
		position: relative;
		display: flex;
		align-items: center;
		.group{
			position: relative;
			z-index: 10;
			display: flex;
			align-items: center;
			justify-content: space-between;
			width: 100%;
			color:#fff;
			.userinfo{
				display: flex;
				width: 100%;				
				align-items: center;				
				.pic{
					width: 120rpx;
					height: 120rpx;
					border-radius: 50%;
					overflow: hidden;
					border:2px solid #fff;
					image{
						width: 100%;
						height: 100%;
					}
				}
				.text{
					padding-left:20rpx;
					.nickname{
						font-size: 44rpx;
						font-weight: 600;
					}
					.year{
						font-size: 26rpx;
						opacity: 0.6;
						padding-top:5rpx;
					}
				}
			}
			.more{
				.iconfont{
					font-size: 40rpx;
				}
			}
			
		}
		.bg{
			position: absolute;
			top: 0;
			left:0;
			width: 100%;
			height: 100%;
			overflow: hidden;
			image{
				width: 100%;
				height: 100%;
				// 模糊
				filter: blur(20px);
				// 放大背景图片，而不是全部显示图片，要不然会出现黑边。
				transform: scale(2);
				opacity: 0.5;
			}
		}
	}
	.main{
		width: 100%;
		min-height: 200rpx;
		background: #fff;
		// 做圆角的最佳方式，圆角然后上移动，显出成层次感
		border-radius: 30rpx;
		transform:translateY(-30rpx);
		padding:30rpx 0;
		.info{
			padding:10rpx 30rpx;
			display: flex;
			font-size: 30rpx;
			.item{
				padding-right: 20rpx;
				color:#888;
				text{
					font-weight: 600;
					color:#333;
				}
			}
		}
		.list{
			.group{
				padding:15rpx 30rpx;
				border-bottom:15rpx solid #f4f4f4;
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
			}
			.group:last-child{
				border:none;
			}
		}
	}
	
}
</style>
