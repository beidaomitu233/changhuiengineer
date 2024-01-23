<template>
	<view>
		
		<!-- 实现多图上传 -->
		<!-- 实现了头像上传的小案例 -->
		
		<view class="content">
				<view class="imgbox" v-for="(item,index) in Imglist" :key="index">
					<image :src="item.path" mode="aspectFill" @click="previewImage(index)"></image>
					<view class="delbtn" @click="delbtn(index)">
						×
					</view>
				</view>

				<!-- 当图片大于9张时就不显示上传按钮 -->
				<view class="upLoadBtn" @click="upLoadBtn" v-show="Imglist.length<maxchoose"> 
				点击上传
			</view>
									
		</view>
		
		<view class="sentTocloud" >
			<button class="sentbtn" type="primary" @click="upLoadMoreItem">提交</button>
		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				maxchoose:9,
				Imglist:[],
				id:0,
			}
		},
		methods: {
			// 上传按钮
			upLoadBtn(){		
				uni.chooseImage({
					count:this.maxchoose,
					success: (res) => {
						console.log(res);
						// 拼接原有的图像
						let oldimg=this.Imglist
						let newupload=[...res.tempFiles,...oldimg]
						// 拼接后限制显示总数
						this.Imglist=newupload.slice(0,this.maxchoose)
					}
				})
			},
			
			// 删除图像
			delbtn(index){
				
				console.log(index);
				// 删除的方式就是从数组中该index的对象
				this.Imglist.splice(index,1)
			},
			// 查看大图，上传的图
			previewImage(index){
					
				uni.previewImage({
					// current是必填项，否则只会显示第一个
					current:index,
					// urls就是图片数组,传递的是数组就可以将已上传的图片滑动来查看全部
					urls:this.Imglist
				})
			},
			
			// 上传到云存储中
			upload(item) {
				console.log('提交');
				// 上传到服务器
				// 由于uploadFile一次只能上传一张，所以要用循环来上传
				return new Promise((resolve, reject) => {
					uniCloud.uploadFile({
						filePath: item.path,
						cloudPath: item.name
					}).then(res => {
						console.log(res);
						// 提交成功后上传到数据库中
						resolve(res);
					}).catch(err => {
						reject(err);
					});
				});
			},

			upLoadMoreItem() {
				let uploadPromises = this.Imglist.map(item => {
					return this.upload(item);
				});

				Promise.all(uploadPromises).then(res => {
					console.log(res);

					// 在这里进行后续操作，只有在上传全部完成后才会执行
				}).catch(err => {
					console.log(err);
				});
			}

			
		}
	}
</script>

<style lang="less" scoped>
	
	.content{
		width: 100%;
		display: flex;
		flex-wrap: wrap;
		justify-content: center;
		
	}
	.imgbox ,.upLoadBtn{
		position: relative;
		margin: 30rpx;
		width: 170rpx;
		height: 170rpx;
		background-color: rgba(0,0,0,.1);
		border-radius: 30rpx;
		display: flex;
		justify-content: center;
		align-items: center;

		
	}
	
	.content image{
		width: 150rpx;
		height: 150rpx;
		border-radius: 20rpx;
		
	}
	
	.upLoadBtn {
		// 实现文字居中	
		display: flex;
		justify-content: center;
		align-items: center;
		color: #999;
		
	}
	
	// 删除按钮
	.delbtn{
		position: absolute;
		top: 0;
		right: 0;
		width: 30rpx;
		height: 30rpx;
		color: white;
		background-color: rgba(0,0,0,.4); 
		// 做一个圆角
		border-radius:50%;
		
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	// 提交按钮
	.sentTocloud{
		margin-top: 50rpx;
		display: flex;
		align-items: center;
		justify-content: center;
	}
	
	.sentbtn{
		width: 50%;
	}

</style>
