<template>
	<view>
		<view>---弹出框样式---</view>		
		<view class="box" :style="{height:state?'300rpx':'0'}"></view>
		<button size="mini" @click="onClose">关闭</button>
		
	</view>
</template>

<script>
	export default {
		name:"mypop",
		data() {
			return {
				
			};
		},
		props:{
			state:{
				type:Boolean,
				default:false
			}
		},
		methods:{
			onClose(){
				this.$emit("update:state",false)
			}
		}
	}
</script>

<style lang="scss">
.box{
	width: 300rpx;
	height: 300rpx;
	background: pink;
}
</style>