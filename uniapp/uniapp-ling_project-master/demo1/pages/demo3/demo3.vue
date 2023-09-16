<template>
	<view>
		<myitem></myitem>
		<view @click="onClick">标题：{{title}}</view>
		<input type="text" v-model="title">
		
		-------小案例-------
		
		<view class="out">
			<view class="row">
				<input class="border" type="text" placeholder="请输入姓名..." v-model="message.username">
			</view>
			
			<view class="row">
				<input class="border" type="text" placeholder="请输入联系电话..." v-model="message.tel">
			</view>
			
			<view class="row">
				<textarea class="border" placeholder="请输入留言内容..." v-model="message.content"></textarea>
			</view>
			
			<view class="row">
				<button type="primary" @click="onSubmit">提交留言</button>
			</view>
		</view>
		
		{{message}}
		
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title:"优课学院",
				message:{
					username:"",
					tel:"",
					content:""
				}
			};
		},
		methods:{
			onClick(){
				this.title=Math.random()
			},
			onSubmit(){
				console.log(this.message)
			}
		}
	}
</script>

<style lang="scss">
.out{
	padding:30rpx;
	.row{
		margin-bottom:10rpx;
	}
	.border{ 
		border:1px solid #eee;
		width: 100%;
		min-height: 80rpx;
		padding:0 20rpx;
		box-sizing: border-box;
		
	}
}

</style>
