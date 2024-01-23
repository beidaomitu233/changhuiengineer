<template>
	<view class="home">
		<view class="out">			
		
			<view class="row" v-for="item in listArr" :key="item._id">
				姓名：{{item.name}} - 年龄：{{item.age}}
			</view>
			
			<button @click="onUpdate">修改</button>
			<button type="warn" @click="onRemove">删除</button>
		</view>
		
		
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello',
				listArr:[],
				userArr:[]
			}
		},
		onLoad() {			
			this.getData()
		},
		methods: {			 		 
			getData(){
				uniCloud.callFunction({
					name:"cloudDemoGet",
					data:{
						keyword:"热巴"
					}
				}).then(res=>{
					console.log(res)
					this.listArr=res.result.data
				})
			},
				 
			//修改
			onUpdate(){
				uniCloud.callFunction({
					name:"CloudDemoUpdate"
				}).then(res=>{
					console.log(res)
				})
			},
			
			//删除
			onRemove(){
				uniCloud.callFunction({
					name:"cloudDemoRemove"
				}).then(res=>{
					console.log(res)
				})
			}
			
		}
	}
</script>

<style lang="scss">
	.out{
		padding:30rpx;
		.row{
			border-bottom:1px solid #ccc;
			padding:20rpx 0;
		}
	}
</style>
