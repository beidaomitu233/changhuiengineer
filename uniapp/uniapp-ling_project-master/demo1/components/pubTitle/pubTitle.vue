<template>
	<view class="pubTitle">
		<view class="time">{{time}}</view>
		<view class="big">{{title}}</view>
		<view class="small">{{subtitle}}</view>
		<view>{{list}}</view>
		<view>{{user}}</view>
		<view class="line"></view>
	</view>
</template>

<script>
	export default {
		name:"pubTitle",
		// props:["title",'subtitle'],
		props:{
			title:{
				type:String,
				default:"默认标题"
			},
			subtitle:{
				type:String,
				default:"默认副标题"
			},
			time:{
				type:Number,
				default:Date.now()
			},
			list:{
				type:Array,
				default(){
					return [1,2,3]
				}
			},
			user:{
				type:Object,
				default(){
					return {name:"匿名",gender:"保密"}
				}
			}
		},
		data() {
			return {
				
			};
		}
	}
</script>

<style lang="scss">
.pubTitle{ 
	padding:60rpx 30rpx;
	text-align: center;
	background: #B9EDF8;
	.big{ 
		font-size: 50rpx;
		font-weight: 600;
		color:#1F6ED4;
	}
	.small{ 
		font-size: 28rpx;
		color:#39BAE8;
	}
	.line{ 
		display: inline-block;
		width: 100rpx;
		height: 10rpx;
		background: #0000A1;
		border-radius: 10rpx;
	}
}
</style>