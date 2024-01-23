<template>
	
	<view class="">
		<!-- 轮播图 -->
		<ItemSwiper></ItemSwiper>
		<!-- 热门项目 -->
		<hotItem></hotItem>
	
	<view class="content">
		<image class="logo" src="/static/logo.png" @click="toshopinglist"></image>
		<view class="text-area">
			<text class="title">{{title}}</text>
		</view>
		
	<view class="saying">
		<text user-select >名言：年轻人赶紧学把</text>
	</view>
	
	<video class="vidz" autoplay muted controls show-mute-btn   src="https://www.douyin.com/discover?modal_id=7260211255250652476"></video>
	
	<view class="" style="height: 600rpx;">
		
	</view>
	vb  
	</view>
	
		</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello'
			}
		},
		onLoad() {

		},
		methods: {
			toshopinglist(){
				uni.switchTab({
					url:'/pages/shopinglist/shopinglist',
					success() {
						console.log('成功跳转');
					}
				})
			}

		}
	}
</script>

<style lang="less" >
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		.logo {
			height: 200rpx;
			width: 200rpx;
			margin-top: 200rpx;
			margin-left: auto;
			margin-right: auto;
			margin-bottom: 50rpx;
		}
	}

.saying{
	width: 400rpx;
	height: 200rpx;
	border: 1px solid aqua;
	border-radius: 15rpx;
	line-height: 200rpx;
	font-size: 40rpx;
	
}

.vidz{
	width: 600rpx;
	height: 600rpx;
}


	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
