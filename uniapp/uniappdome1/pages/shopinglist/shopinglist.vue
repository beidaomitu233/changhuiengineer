<template>
	<view>
		<!-- 顶出空白区域 -->
		<view class="mt-2"></view>
			<!-- 商品列表轮播图 -->
		<view @click="showTips()">
			<ItemSwiper class="header-swiper"  ></ItemSwiper>
		</view>
		
		
		<!-- 热门商品列表区域 -->
				<view class="mt-2"></view>
		<view  class="content">
			<hotItem></hotItem>
				
		</view>
	
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
			gohome(){
				uni.navigateTo({
					url:'/pages/home/home'
				})
			},
			
			showTips(){
				console.log('点击了图片');
				uni.showToast({
					icon:'fail',
					image:'/static/hotItem/礼物.png',
					title:"眼光真好，可惜没货了",
					mask:true,
					success() {
						console.log('成功提示客户没货,给您换商品');
					}
				}),
				setTimeout(()=>{
					uni.removeTabBarBadge({
						index:2
					})
					this.gohome()
					// 点击图片后就移除信息
				  uni.removeTabBarBadge({
				  	index:2
				  })
				},1000)
			},
			
		
		},
		onReady() {
			//  修改导航栏颜色
			uni.setNavigationBarColor({
				frontColor:'#ffffff',
				backgroundColor:'#4cd964',
				success(){
					console.log('切换');
				}
		// 修改导航栏标题
			}),
			uni.setNavigationBarTitle({
				title:'布兰兔专场'
			}),
			// 加载完毕后就关闭提示,加个定时器看效果
			setTimeout(()=>{
						uni.hideLoading()
			},500)

			
		},
		
		onLoad() {
			console.log('加载');
			uni.showLoading({
				title:'数据加载中。。。',
				mask:true
			}),
			// 显示有消息
	console.log('设置成功');
			uni.setTabBarBadge({
				index:2,
				text:'3',
					
				success:()=>{
								console.log('设置成功');
				}
			})
		},
		

		
		onShow(){
			// uni.showToast({
			// 	icon:'loading',
			// 	title:'初次打开需稍微等待'
			// })
		}
			

	}
</script>

<style scoped="less">
	.content{
		margin: 0 auto;
		padding-top: 40rpx;
		width: 96%;
		height: 200rpx;
		background-color: aliceblue;
		border-radius: 10rpx;
	}
	.header-swiper{
		/* box-shadow: 0rpx 0rpx 12rpx 2rpx; */
	}
	.mt-2{
		margin-top: 40rpx;
	}

</style>
