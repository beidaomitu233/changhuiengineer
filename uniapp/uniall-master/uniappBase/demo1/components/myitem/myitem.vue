<template>
	<view>
		<view class="item">myitem组件变动了</view>
	</view>
</template>

<script>
	export default {
		name:"myitem",
		data() {
			return {
				
			};
		}
	}
</script>

<style lang="scss">
.item{
	width: 300rpx;
	height: 300rpx;
	background: red;
	color:yellow;
	border-radius: 20rpx;
}
</style>