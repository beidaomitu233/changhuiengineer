<template>
	<view>
		<button @click="goLogin">登录</button>
		<button @click="logout">退出登录</button>
		<button @click="gouserinfo">个人中心</button>
		<view>
			
			<uni-list>				
				<uni-list-item v-for="item in listArr"  :title="item.title" :note="item.content" 
				:thumb="item.userid[0].avatar_file.url"
				thumb-size="lg" 
				:rightText="item.userid[0].username"
				></uni-list-item>
			</uni-list>
		</view>
		
	</view>
</template>

<script>	
    import {mutations} from "@/uni_modules/uni-id-pages/common/store.js"
	const db=uniCloud.database();	
	export default {
		data() {
			return {
				listArr:[]
			}
		},
		onLoad(){
			this.getData();
		},
		methods: {	
			getData(){
				let artTemp=db.collection("cloudDemo").field("title,content,userid,posttime").getTemp();
				let userTemp=db.collection("uni-id-users").field("_id,username,avatar_file,nickname").getTemp();
				
				db.collection(artTemp,userTemp).orderBy("posttime desc").get().then(res=>{
					console.log(res);
					this.listArr=res.result.data
				})
				
								
				
				/*
				db.collection("cloudDemo").get().then(res=>{
					console.log(res);
					this.listArr=res.result.data
				})
				*/
				
				
			},
			
			gouserinfo(){
				uni.navigateTo({
					url:"/uni_modules/uni-id-pages/pages/userinfo/userinfo"
				})
			},
			
			logout(){
				mutations.logout();
			},
			goLogin(){
				uni.navigateTo({
					url:"/uni_modules/uni-id-pages/pages/login/login-withpwd"
				})
			}
		}
	}
</script>

<style>

</style>
