<template>
	<view class="home">
		<input type="text" v-model="title" placeholder="请输入标题"></input>
		<uni-file-picker 
			v-model="imageValue" 			
			mode="grid" 				
			@select="select" 
			@progress="progress" 
			@success="success" 
			@fail="fail" 
			ref="files"
		/>	
		<button @click="onSubmit" type="primary">确认发布</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title:"",
				filesUrl:[],
				imageValue:[],
				imgStyle:{
					"height": 60,	// 边框高度
					"width": 60,	// 边框宽度
					"border":{ // 如果为 Boolean 值，可以控制边框显示与否
						"color":"#eee",		// 边框颜色
						"width":"1px",		// 边框宽度
						"style":"solid", 	// 边框样式
						"radius":"50%" 		// 边框圆角，支持百分比
					}
				},
				listStyle:{
					"borderStyle":{
						"color":"#000",		// 边框颜色
						"width":"1px",		// 边框宽度
						"style":"solid", 	// 边框样式
						"radius":"0px" 		// 边框圆角，不支持百分比
					},
					"border":true, // 是否显示边框
					"dividline":true // 是否显示分隔线
				}
			}
		},
		onLoad() {

		},
		methods: {
			//点击发布
			onSubmit(){
				uniCloud.callFunction({
					name:"demo2_art_add_row",
					data:{
						title:this.title,
						filesUrl:this.filesUrl
					}
				}).then(res=>{
					console.log(res);
				})
			},
			upload(){
				this.$refs.files.upload()
			},
			// 获取上传状态
			select(e){
				console.log('选择文件：',e)
			},
			// 获取上传进度
			progress(e){
				console.log('上传进度：',e)
			},
			
			// 上传成功
			success(e){
				console.log('上传成功',e)
				this.filesUrl=e.tempFilePaths
			},
			
			// 上传失败
			fail(e){
				console.log('上传失败：',e)
			}
		}
	}
</script>

<style>
	
</style>
