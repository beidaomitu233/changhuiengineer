<template>
		<swiper :indicator-dots="true" indicator-active-color="yellow"  class="swiper-content" autoplay="3" circular >
			<swiper-item>
				<view class="swiper-item">  
				
				<image src="../../static/shoppinglist/banner2.jpg" mode="scaleToFill" ></image>
				
				</view>
			</swiper-item>
			<swiper-item>
				<view class="swiper-item">
							<image src="../../static/shoppinglist/banner3.png"></image>
				</view>
			</swiper-item>
		</swiper>
</template>

<script>
	export default {
		name:"ItemSwiper",
		data() {
			return {
				
			};
		}
	}
</script>

<style lang="less">
	.swiper-content{
		width: 96%;
		height: 300rpx;
		margin: 0 auto;
		
	}
	
	.swiper-item,.swiper-item image{
		width: 100%;
		height: 100%;
	}
	
	

</style>