<template>
	<view>

<!-- 新政页面的表单信息 -->
<view class="edit">
	<form @submit="editart">
		
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
					content:'',
					id:''
				},
				isnull:true
				
			};
		},
		
		
		onLoad(option) {
			console.log('接收成功');
			let {item}=option
			// 将JSON字符串转化为JS对象才能显示到页面上
			let objitem=  JSON.parse(item)
			console.log(objitem);
			this.FormData.title=objitem.title
			this.FormData.author=objitem.author
			this.FormData.content=objitem.content
			this.FormData.id=objitem._id
			uni.setNavigationBarTitle({
				title:'修改文章'
			})
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
			editart(){
				// 将整个提交的内容都传输过去
				uniCloud.callFunction({
					name:'artChangeOne',
					// 解构赋值在传参会方便一些
					data:{...this.FormData}
				}).then(res=>{
					uni.showToast({
						title:'发布成功',
						success() {
							console.log(res.result);
							//提交成功后返回页面
							uni.navigateBack({
								delta:1
							})
						}
					})
					

				})
			}
		}
	}
</script>

<style lang="less">
	
	.edit{
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
