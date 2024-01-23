<template>
	
	
	<!-- 实现了头像上传的小案例 -->
	<view class="content">
		<image class="logo" :src="getformimg.fileUrl"></image>
		<view class="text-area">
			<text class="title">{{title}}</text>
		</view>
		<uni-file-picker 
			v-model="imageValue" 
			fileMediatype="image" 
			mode="grid" 
			limit="1"
			title="上传头像"
			fileExtname='png,jpg,svg'
			ref="files"
			:autoUpload="false"
			:image-styles="iconimg"
			@select="select" 
			@progress="progress" 
			@success="success" 
			@fail="fail" 
		/>
	
		<button @click="upload" type="primary">上传文件</button>
	
	</view>
	
</template>

<script>
	export default {
		data() {
			return {
				// 从数据库中获取到的头像地址
				getformimg:{},
				fileUrl:[],
				iconid:'',
				title: 'Hello',
				imgtitle:'usericon',
				imageValue:[],
				iconimg:{
					"height": 60,	// 边框高度
					"width": 60,	// 边框宽度
					"border":{ // 如果为 Boolean 值，可以控制边框显示与否
						"color":"#eee",		// 边框颜色
						"width":"1px",		// 边框宽度
						"style":"solid", 	// 边框样式
						"radius":"50%" 		// 边框圆角，支持百分比
					}
				}
			}
		},
		onLoad() {

		},
		methods: {
			
			// 上传完云存储后再将图片地址上传云数据库
			uploadmysql(){
				uniCloud.callFunction({
					name:'addImg',
					data:{
						fileUrl:this.fileUrl[0],
						imgtitle:this.imgtitle
						}
				}).then(res=>{
					console.log(res);
					this.iconid=res.result
					this.getusericon()
				})
			},
			// 手动上传到云存储
			upload(){
				this.$refs.files.upload()
			},
			
				// 获取上传状态
						select(e){
							console.log('选择文件：')
						},
						// 获取上传进度
						progress(e){
							console.log('上传进度：',e)
						},
						
						// 上传成功
						success(e){
							console.log('上传成功',e)
							this.fileUrl=e.tempFilePaths
							console.log(this.fileUrl);	
							this.uploadmysql()
						},
						
						// 上传失败
						fail(e){
							console.log('上传失败：',e)
						},
						
						//获取用户头像
						getusericon(){
							uniCloud.callFunction({
								name:'getUsericon',
								data:this.iconid
								
							}).then(res=>{
								console.log('获取到的用户头像地址');
								console.log(res);
								this.getformimg=res.result.data[0]
								
								console.log(this.getformimg.fileUrl);
							
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
