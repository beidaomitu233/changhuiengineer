<template>
	<view class="content">
		<image class="logo" src="/static/logo.png" @click="goUserinfo"></image>
		<button @click="addClick">新增</button>
		<view class="text-area">
			<text class="title">{{title}}</text>
		</view>
		<view>
			<navigator url="/uni_modules/uni-id-pages/pages/login/login-withpwd">登录</navigator>
		</view>
		
		<view>
			<button @click="goUpdate">修改</button>
			
		</view>
	</view>
</template>

<script>
	const db=uniCloud.database();
	export default {
		data() {
			return {
				title: 'Hello'
			}
		},
		onLoad() {
			this.getData();
		},
		methods: {
			
			goUpdate(){
				db.collection("cloudDemo").doc("636135dcd4fe2f000151253b").update({
					title:"长征五号B遥四运载火箭末级残骸已再入大气层",
					content:""
				}).then(res=>{
					console.log(res);
				}).catch(err=>{
					uni.showToast({
						title:err.message,
						icon:"none"
					})
				})
			},
			
			goUserinfo(){
				uni.navigateTo({
					url:"/uni_modules/uni-id-pages/pages/userinfo/userinfo"
				})
			},
			addClick(){
				db.collection("cloudDemo").add({
					title:"iPhone 14 Plus 销量大跌",
					content:"还有几天，双 11 的正日就要来了，大家有心仪要出手的数码产品吗？"
				}).then(res=>{					
					uni.showToast({
						title:"添加成功"
					})
				}).catch(err=>{					
					uni.showToast({
						title:err.message,
						icon:"none"
					})
				})
			},
			
			getData(){
				db.collection("cloudDemo").get().then(res=>{
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
