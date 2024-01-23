<template>
	<view>
		<view class="detail" v-if="isloding">
			
			<!-- 内容标题 -->			
			<view class="title">
				{{item.title}}
			</view>
			
			<!-- 作者信息 -->
			
			<view class="info">
				
				<text>{{item.author}}</text>
				<!-- 不显示刚刚/马上/xx分钟前 -->
				<uni-dateformat 
				:date="item.postime" 
				:threshold="[0,0]"
				format="MM-dd"
				
				>
							
				
				
				</uni-dateformat>
			</view>
			
			<!-- 详细内容 -->
			<view class="content">
				{{item.content}}
			</view>
			
			<view class="btnGroup">
				<button size="mini" @click="toedit(item)">修改</button>
				<button type="warn" size="mini" @click="ondel(id)">删除</button>
			</view>
			
			
			
		</view>
		
		<view class="onload" v-else>
			<uni-load-more status="loading" ></uni-load-more>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				item:{},
				isloding:false,
				// id来自主页传递的值
				id:{}
				
			};
		},
		
		onLoad(e) {
			this.id=e
			this.getdetail(e)
			
		},
		
		
		onShow() {
			this.getdetail(this.id)
		}
		,
		methods:{
			
			// 删除记录
			ondel(id){
				
				uni.showModal({
					content:"是否删除内容",
					success(res) {
						console.log(res);
						
						if(confirm){
						uniCloud.callFunction({
							name:'artDelOne',
							data:id
								
							}).then(res=>{
								uni.redirectTo({
									url:'/pages/index/index'
								})
								
							})
						}
				
						
					}
				})

			}
			,
			
			// 获取该id的详情页面
			getdetail(e){
				uniCloud.callFunction({
					name:'artGetOneitem',
					data:e
				}).then(res=>{
					
					this.isloding=true
					this.item=res.result.data[0]
					uni.setNavigationBarTitle({
						title:this.item.title
					})
				
					console.log(this.item);
					
				}).catch(()=>{
					
					uni.showToast({
						content:'找不到该文章。',
						
						success() {
							uni.redirectTo({
								url:'/pages/index/index'
							})
						}
						

					})
					
				})
			},
			
				
			toedit(item){
				// 在uniapp中传递需要先转化为JSON字符串
				let itemjson=JSON.stringify(item)
				uni.navigateTo({
					url:'/pages/edit/edit?item='+itemjson,
					
				})
			}
			
		}
		
	}
</script>

<style lang="less" scoped >


.detail{
	padding: 30rpx;
	
	.title{
		font-size: 50rpx ;
		color: #000;
		text-align: justify;
		line-height: 1.4em;
	}
	
		
	.info{
		font-size: 30rpx;
		color: #666;
		padding: 30rpx 0 60rpx;
		
		text{
			padding-right: 30rpx;
		}
		
		.content{
			font-size: 36rpx;
			line-height: 1.4em;
		}
		
		
		
	}
	
	.btnGroup{
		padding:50rpx 0;
		
		button{
			margin-right: 30rpx;
			
		}
	}
	
	
}






</style>
