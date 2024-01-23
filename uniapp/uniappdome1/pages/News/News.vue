<template>
	<view>
		<image class="news-container" :src="newsImg.data" mode="scaleToFill"></image>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				newsImg:{}
			};
		},
		methods:{
			getNewImg(){
				uni.request({
					url:'https://dayu.qqsuu.cn/weiyujianbao/apis.php?type=json',
					success: (res) => {
						if(res.data.code&&res.statusCode==200){
							this.newsImg=res.data
							console.log(this.newsImg);
							
						}
					}
				})
			}
		},
		onLoad() {
			this.getNewImg()
		}
	}
</script>

<style lang="less">
	.news-container{
		height: 1500rpx;
		width: 100%;
	}

</style>
