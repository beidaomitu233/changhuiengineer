<template>
	<view>

<!-- 新政页面的表单信息 -->
<view class="add">
	<form @submit="addart">
		
		<view class="item">
			<input  v-model.lazy.trim="FormData.title"   type="text" name="title" placeholder="请输入标题,(必填项)"/>
		</view>
		
		<view class="item">
			<input   v-model.lazy.trim="FormData.author"  type="text" name="auth" placeholder="输入作者" />
		</view>
		
		<view class="item">
			<textarea    v-model.lazy.trim="FormData.content"  name="content" id="" cols="30" rows="10" placeholder="输入内容(必填项)"></textarea>
		</view>
		
		<view class="item">
			<button form-type="reset" >重置</button>
			<button form-type="submit" type="primary" :disabled="isnull" >提交</button>
		</view>
		
	</form>
	
</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				FormData:{
					title:'',
					author:'',
					content:''
				},
				isnull:true
				
			};
		},
		
			
		watch:{
			// 使用监听器检测是否输入内容
			FormData:{
				handler(newval,oldval){		
					if(newval.title && newval.content !=''){
						this.isnull=false
						console.log(newval.author);
					}
				},
				immediate:true,
				deep:true
			}
			
			
		}
		
		,
		methods:{
			// 提交后触发
			addart(e){
				let detail=e.detail.value
				console.log(detail);
				uniCloud.callFunction({
					name:'art_add_onerow',
					// 解构赋值在传参会方便一些
					data:{...detail}
				}).then(res=>{
					
					
					uni.showToast({
						title:'发布成功',
						success() {
							console.log(res.result);
							// 提交成功后返回页面
							// uni.redirectTo({
							// 	url:'/pages/index/index'
							// })
						}
					})
					

				})
			}
		}
	}
</script>

<style lang="less">
	
	.add{
		padding: 10rpx;
		
		.item{
			padding-bottom: 20rpx;
		}
		
	}
	
	.item input ,.item textarea{
		border: 1rpx solid #eee;
		height: 80rpx;
		padding: 0 15rpx;
	}
	
	.item textarea{
		box-sizing: border-box;
		width: 100%;
		height: 200rpx;
	}
	
	.item button{
		margin: 20rpx;
	}
	
	

</style>
