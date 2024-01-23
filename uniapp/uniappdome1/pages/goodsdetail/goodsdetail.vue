<template>
	<view>
		<ItemSwiper></ItemSwiper>
		
		
		<view class="">
			
			你查看的商品ID是：{{query.id}}
			商品名称是：{{query.goodname}}
			
		</view>
		
		<view class="mt-2">
			
		</view>
		
		<view style="margin: 0 auto;width: 300rpx; height: 100rpx;">
	
		<button @click="PaymentRequest()">点击购买</button>
		
		<view class="mt-2">	</view>
				
		
		<button @click="gobacklist()">点击返回</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				// 接收的参数
				query:null
				
			};
		},
		methods:{
			gobacklist(){
				uni.navigateBack({
					delta:1
				})
			},
			PaymentRequest(){
				uni.showModal({
					title:'确认购买',
					cancelText:'不买了',
					confirmText:'买买买',
					// 开启输出框输入数量
					editable:true,
					placeholderText:'购买数量',
					success:(res)=>{
						console.log(res);
						if(res.confirm){
							// 发起购买请求...
						console.log(`购买的商品是：${this.query.goodname}，ID是:${this.query.id},购买的数量是：${res.content}`)
						}else{
							console.log('用户取消购买')
						}
					}
				})
			}
		},
		
		onLoad(options){
			// 接受传递过来的参数并且解析到页面中
			console.log(options),
			this.query=options,
			uni.showTabBar()
			
		},
		// 设置标题
		onReady(){
			uni.setNavigationBarTitle({
				title:`${this.query.goodname}`
			}),
			uni.setNavigationBarColor({
				frontColor:'#ffffff',
				backgroundColor:'#dd524d'
			})
		}
	}
</script>

<style lang="less">
	
	.mt-2{
		margin-top: 30rpx;
	}

</style>
