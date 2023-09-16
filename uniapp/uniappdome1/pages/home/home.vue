<template>
	<view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {

			};

		},
		onReady() {
			uni.setNavigationBarColor({
				frontColor:'#000000',
				backgroundColor:'#f0ad4e',
				success(){
					console.log('切换');
				}
			
		
			}),
			uni.setNavigationBarTitle({
				title:'我的'
			})
			
			
		},
	}
</script>

<style lang="less">
	

</style>
