<template>
	<view class="content">
		<image class="logo" src="/static/logo.png"></image>
		<view class="text-area">
			<text class="title">{{title}}</text>
		</view>
		
		<button @click="tologin" >点击登入</button>
		<button @click="logout" >退出登入</button>
		<button @click="toArtcle">文章操作</button>
		
	</view>
</template>

<script>
	
	import {mutations} from '../../uni_modules/uni-id-pages/common/store.js'
	//需要引入云对象
	const iCoudObj=uniCloud.importObject('iCoudObj')
	export default {
		data() {
			return {
				title: 'Hello'
			}
		},
		onLoad() {
			this.getArtcle()
			this.addArtcle()

		},
		methods: {
			// 退出登入的逻辑已经写好了，所以直接调用即可
			logout(){
				mutations.logout()
			},
			
			toArtcle(){
				uni.navigateTo({
					url:'/pages/easysql/easysql'
				})
			},
			tologin(){
				uni.navigateTo({
					url:'/uni_modules/uni-id-pages/pages/login/login-withpwd'
				})
			}
			
			,
			
			addArtcle(){
				iCoudObj.add({
				title:"iPhone15系1列预约量突破300万台后66，一个奇怪的现象出现了",
				content:"8月底，华为mate60pro正式开售，不到3天的时间里华为mate60pro的线上、线下销量就突破80万台，创造了华为mate系列的销量记录。 面对如此火爆..."
				}).then(res=>{
					console.log(res);
				})
			},
				
				// 传递参数需要在get内写
			getArtcle(){
				iCoudObj.get(3).then(res=>{
					console.log(res);
				})
			}

		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
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
