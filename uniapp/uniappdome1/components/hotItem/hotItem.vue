<template>
	<view class="goodlist-container">
		
	<scroll-view  scroll-x >
		<!-- 在小程序里，key只是做区分，但是不会做属性，如果需要给每个项目都添加id属性并将数据传输给下一个组件
		 就需要绑定属性  data-xxx  最终会在e.currentTarget.dataset得到全部信息
		 
		 -->
		<view class="scroll-Hot-Item" v-for="(item,index) in goodlist" :key="item.id" :data-id="item.id" :data-Goodname="item.goodname"  @click="lookdetail($event)"  >
			<image src="../../static/hotItem/心动.png" mode="aspectFit"></image>
			<view class="">
			{{item.goodname}}
			</view>
		</view>
	</scroll-view>	
	</view>
</template>

<script>
	export default {
		name:"hotItem",
		data() {
			return {
				id:null,
				goodname:'',
				tempqurey:{},
				goodlist:[
					{
					"id": 1,
					"goodname": "商品A",
					"gooddesc": "这是商品A的描述"
					},
					{
					"id": 2,
					"goodname": "商品B",
					"gooddesc": "这是商品B的描述"
					},
					{
					"id": 3,
					"goodname": "商品C",
					"gooddesc": "这是商品C的描述"
					},
					{
					"id": 4,
					"goodname": "商品D",
					"gooddesc": "这是商品D的描述"
					},
					{
					"id": 5,
					"goodname": "商品E",
					"gooddesc": "这是商品E的描述"
					},
					{
					"id": 6,
					"goodname": "商品F",
					"gooddesc": "这是商品F的描述"
					},
					{
					"id": 7,
					"goodname": "商品G",
					"gooddesc": "这是商品G的描述"
					},
					{
					"id": 8,
					"goodname": "商品H",
					"gooddesc": "这是商品H的描述"
					},
					{
					"id": 9,
					"goodname": "商品I",
					"gooddesc": "这是商品I的描述"
					},
					{
					"id": 10,
					"goodname": "商品J",
					"gooddesc": "这是商品J的描述"
					}
				]
				
			};
		},
		methods:{
			lookdetail(e){
				// 获取到的内容简化在继续写,这里应该是存在一个问题，就是值还没有存入到tempqurey中就去取值，但是在控制台中可以看到ob observer，但是取不出来，所以直接用e去取
				this.tempqurey=e.currentTarget.dataset,
				this.id=this.tempqurey.id,
				this.goodname=this.tempqurey.goodname,
				
				// 让用户确认是否前往
				uni.showModal({
					title:'温馨提示',
					content:'是否要跳转到商品详情页',
					cancelText:'不去不去',
					confirmText:'买买买',
					// 调用回调来检查是否正确显示 ,破案了，因为要使用箭头函数，要不然this指向是success对象。
					success:(res)=>{
						// 检测用户点了取消还是确认
						console.log(res);
						if(res.confirm){
							console.log(this.tempqurey);
							uni.navigateTo({
								// 将点击的ID传过去，参数是key-value，只需要将变量给括起来。
								url:`/pages/goodsdetail/goodsdetail?id=${this.id}&goodname=${this.goodname}`
							})
						}else {}

					}
				})
				
				

			}
		}
	}
</script>

<style lang="less">
	.goodlist-container{
		margin: 0 auto;
		width: 96%;
		height: 150rpx;
		border: 1px solid bisque;
		border-radius: 10rpx;
		white-space: nowrap;
	}
	.scroll-Hot-Item{
		width: 150rpx;
		display: inline-block;
		height: 150rpx;
		text-align: center;
	}
	
	.scroll-Hot-Item image{
		width: 100%;
		height: 75rpx;
	}
	
</style>