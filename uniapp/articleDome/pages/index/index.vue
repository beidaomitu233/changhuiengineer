<template>
	<view class="home">
		
		<view class="content">
			
			<view @click="godetail(item._id)"  class="item" v-for="item in artlist" :key="item._id">
				<view class="text" >
					<view class="title">
						{{item.title}}
					</view>
					<view class="info">
						<span>{{item.author}}</span>
						<span>
							<!-- 不显示刚刚/马上/xx分钟前 -->
					<uni-dateformat 
					:date="item.postime" 
					:threshold="[0,0]"
					format="MM-dd"
					
					>
			
					
					
					</uni-dateformat>
					</span>
						<uni-icons type="clear" size="30" color="#ffd83a"> </uni-icons>
						
					</view>
				</view>
				
				<view class="pic">
					<image src="../../static/images/nodata.png" mode="aspectFill"></image>
				</view>
				
			</view>
			
			
			
		</view>
		
		<!-- 新增文章 -->
		<view class="goAdd" @click="goEdit">
		<uni-icons type="plus-filled" size="40" color="#ffd83a"> </uni-icons>
		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello',
				artlist:[]
			}
		},
		
		
		// 防止切换回页面不刷新,自动触发下滑刷新
		onPullDownRefresh() {
			// 清空数据后再重新再吧信息传输过来
			this.artlist=[]
			// 调用方法
			this.getData()
			
			console.log('自动刷新');

		},
		
			
		onShow(){
			this.startPullDownRefresh()
		},
		
		onReachBottom() {
			this.getData()
		}
		,
		onLoad() {
			this.getData()
			
		},
		methods: {
			
			godetail(id){
				uni.navigateTo({
					url:`/pages/detail/detail?id=${id}`
				})
				
			},
				
			goEdit(){
				uni.navigateTo({
					url:'/pages/add/add'
				})
			},
			
			getData(){
				uniCloud.callFunction({
					name:'artGetAll',				
					data:{
						// 跳过的条数应该是已经请求回来的数量
						skip:this.artlist.length
					}
				}).then(res=>{
					console.log(res.result);
					// 要做数据拼接，否则会导致新数据会覆盖原先的内容
					this.artlist=[...res.result.data,...this.artlist]
					// 关闭下滑刷新
					uni.stopPullDownRefresh()
				})
			}

		}
	}
</script>

<style scoped="less">
	.content {
		padding: 30rpx;
		
		.item{
			display: flex;
			justify-content: space-between;
			padding: 20rpx 0;	
			border: 1rpx solid #eee;
			
			
			.text{
				flex: 1;
				
				.title{
					margin: 10rpx;
					font-size: 35rpx;
					color: #333;
					
					   display:-webkit-box;
					   overflow:hidden;
					   text-overflow:ellipsis;
					   -webkit-line-clamp:2;
					   -webkit-box-orient:vertical;
					
				}
					
				.info{
					display: flex;
					flex-direction: row;
					justify-content: space-around;
					padding: 10rpx;
					font-size: 28rpx;
					color: #888;
					
					span{
						
					}
					
				}
				
				
			}
			
		
		}
		
	}

	
	.pic{
		width: 280rpx;
		height: 100rpx;		
		margin-left: 5rpx;
	}		
		
	.pic image{
			width: 100%;
			height: 100%;
		}
		
	.goAdd{
		
		display: flex;
		justify-content: center;
		align-items: center;
		border-radius: 50%;
		
		position: fixed;
		right: 60rpx;
		bottom: 100rpx;
		
		
		width: 100rpx;
		height: 100rpx;
		background-color: #4bbd59;
		color: #fff;
		box-shadow: 0 0 29rpx rgba(38, 153, 57,.5);
		
		font-size: 50rpx;

		
	}




</style>
