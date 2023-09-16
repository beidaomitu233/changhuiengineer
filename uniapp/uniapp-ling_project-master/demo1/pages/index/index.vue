<template>
	<view class="out">
		
		<navigator url="/pages/demo4/demo4?wd=uniapp">跳转到demo4</navigator>
		
		<view style="width: 200rpx; height:200rpx; background:pink" @click="goDemo4"></view>
		
		
		
		<pubTitle :list="[4,5,6]" :user="{user:'张三',gender:'女'}" :time="time" :title="test" subtitle="index page"></pubTitle>
		//父向子传值 子组件通过props接受父组件传过来的值
		
		<navigator url="/pages/list/list">新闻列表</navigator>
		<navigator url="/pages/list/list" open-type='reLaunch'>新闻列表</navigator>
		<navigator url="/pages/about/about" open-type="redirect">关于我们</navigator>
		
		<navigator url="/pages/list/list">
			<image src="../../static/images/pic1.jpg" mode=""></image>
		</navigator>
		
		<button type="primary">确认提交</button>
		<button size="mini" type="warn">确认提交</button>
		<button size="mini" type="warn" plain loading>确认提交</button>
		<input type="text">
		
		<video src="../../static/images/media.mp4" initial-time="20" :controls="false"></video>
		
		
		<image src="/static/images/pic4.jpg" mode="" class="myimg"></image>
		<image src="https://vkceyugu.cdn.bspapp.com/VKCEYUGU-f184e7c3-1912-41b2-b81f-435d1b37c7b4/1ae87107-2943-4ba6-be2b-390ca27c6260.png" mode=""></image>
		<image src="/static/images/pic7.jpg" mode="widthFix" class="mypic"></image>
		
		<view class="box"> div </view> 
		<view class="block"></view>
		<icon type="success" size="26"/>
		<icon type="waiting" size="26"/>
		<view>uniapp</view>
		<view>web前端开发</view>
		<text user-select selectable>nodejs span </text> 
		<text space="ensp" decode>vue   &gt;    js</text>
		
		<scroll-view class="scroll" scroll-x scroll-y>
			<view class="group">
				<view class="item">
					111
				</view>
				
				<view class="item">
					111
				</view>
				
				<view class="item">
					111
				</view>
				
				<view class="item">
					111
				</view>
				
				<view class="item">
					111
				</view>
			</view>
		</scroll-view>
		
		
		<swiper class="swiper" circular autoplay interval="3000" duration="200" indicator-dots indicator-color="rgba(255,255,255,0.5)" indicator-active-color="rgba(255,255,255,1)">
			<swiper-item class="item">
				<image src="/static/images/pic1.jpg" mode="aspectFill"></image>
			</swiper-item>
			<swiper-item class="item">
				<image src="/static/images/pic2.jpg" mode="aspectFill"></image>
			</swiper-item>
			<swiper-item class="item">
				<image src="/static/images/pic3.jpg" mode="aspectFill"></image>
			</swiper-item>
		</swiper>
		
		<view style="height: 500rpx;"></view>
		
		
		
		
	</view>	
</template>

<script>
	export default {
		data(){
			return {
				test:"优课学院",
				time:Date.now()
			}
		},
		methods:{
			goDemo4(){				
				uni.navigateTo({
					url:"/pages/demo4/demo4?wd=uni-app&author=咸虾米"
				})
			}
		}
	}
</script>

<style lang="scss">
.myimg{ 
	width: 360rpx;
	
}

.mypic{ 
	
}
	
	
.out{ 
	.box{ 
		width: 200px;
		height: 200px;
		background: pink;
	}
	.block{ 
		width: 750rpx;
		height: 200rpx;
		background: green;
	}
}

.scroll{ 
	border:1px solid red;
	box-sizing: border-box;
	height: 220rpx;
	height: 100rpx;
	.group{ 
		white-space: nowrap;
		.item{ 
			width: 220rpx;
			height: 220rpx;
			background: royalblue;
			display: inline-block;
			margin-right: 10rpx;
		}
	}
}

.swiper{ 
	height: 400rpx;
	margin-top: 100rpx;
	.item{ 
		padding:20rpx;
		box-sizing: border-box;
		image{
			width: 100%;
			height: 350rpx;
		}
	}
}

</style>
