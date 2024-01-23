<template>
	<view class="homeContent">
<!-- 		<view class="row" v-for="item in arr" :key="item.id">
			<image :src="item.picurl" mode="" alt="图片消失了"></image>
			<view class="title">
			名称：	{{item.title}}
			</view>
			<view class="price">
			 价格：	{{item.price}}
			</view>
		</view> -->
		
		<!-- 简单的提交数据 -->
		
		<view class="">
			
			<form   @submit="onSubmit">
				<input type="text" name="username" placeholder="请输入用户名">
				<input type="text" name="pass" placeholder="密码">			
		
				<button form-type="submit">提交</button>
			</form>
			
		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				// 请求回来的数据
				arr:[]
			}
		},
		onLoad() {
			// uniCloud.callFunction({
			// 	name:'dbdata',
			// 	// 控制获取的质量
			// }).then(res=>{
			// 	console.log(res.result);
			// 	this.arr=res.result
			// })
			

		},
		methods: {
			
			// 提交表单的方法
			onSubmit(e){
				console.log(e.detail.value);
				uniCloud.callFunction({
					name:'dbdata',
					data:e.detail.value
					
				}).then(res=>{
					console.log(res.result);
				})
			}

		}
	}
</script>

<style scoped="less">
.homeContent{
		margin: 0 auto;
	width: 90%;

	
}
</style>
