<template>
	<view class="file">
		<view class="uploadGroup">			
			<view class="box" v-for="(item,index) in temFiles" :key="index">
				<image :src="item.path" mode="aspectFill" @click="clickImg(index)"></image>
				<view class="close" @click="onClose(index)">×</view>
			</view>
			<view class="box add" @click="addFile" v-show="temFiles.length<maxSize">+</view>
		</view>
		<button @click="goUpload">确认上传</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				temFiles:[],
				maxSize:9,
				picArr:[]
			}
		},
		methods: {
			//点击上传到云存储
			goUpload(){
				let newsArr= this.temFiles.map(async item=>{
					return await this.uploadFun(item)
				})
				Promise.all(newsArr).then(res=>{
					let arr=res.map(item=>{
						return item.fileID
					})
					this.picArr=arr;
					console.log(this.picArr);
				})
				
			},
			
			uploadFun(item){				
				return uniCloud.uploadFile({
					filePath:item.path,
					cloudPath:item.name
				})
			},
			
			
			//点击预览图
			clickImg(index){
				let arr=this.temFiles.map(item=>{
					return item.path
				})
				uni.previewImage({
					current:index,
					urls:arr
				})
			},
			
			//点击删除
			onClose(e){				
				this.temFiles.splice(e,1)
			},
			
			//选择本地图片
			addFile(){
				uni.chooseImage({					
					success:res=>{	
						console.log(res);
						let oldTem=this.temFiles;
						let nsTem=[...oldTem,...res.tempFiles]
						nsTem=nsTem.slice(0,this.maxSize);
						this.temFiles=nsTem
					}
				})
			}
		}
	}
</script>

<style lang="scss" scoped>
.uploadGroup{
	padding:30rpx;
	display: flex;	
	flex-wrap: wrap;
	.box{
		width: 200rpx;
		height: 200rpx;
		background: #eee;
		margin-right: 15rpx;
		margin-bottom: 15rpx;
		position: relative;
		image{
			width: 100%;
			height: 100%;
		}
		.close{
			position: absolute;
			right: 0;
			top:0;
			width: 50rpx;
			height: 50rpx;
			background: rgba(0,0,0,0.7);
			color:#fff;
			border-radius: 0 0 0 80rpx;
			display: flex;
			justify-content: center;
			align-items: center;
		}
	}
	
	.add{
		font-size: 80rpx;
		display: flex;
		align-items: center;
		justify-content: center;
		color:#888;
		
		
	}
}
</style>
