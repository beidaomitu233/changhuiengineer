<template>
	<view class="home">
		<scroll-view class="navscroll" scroll-x>
			<view class="row" :class="navIndex==index?'active':''" v-for="(item,index) in navArr" :key="item.id" @click="clickNav(item.id)">{{item.classname}}</view>			
		</scroll-view>
		
		<view class="content">
			<view class="item" v-for="item in listArr">				
				<newsbox :item="item" @click.native="clickDetail(item)"></newsbox>				
			</view>
			<view class="nodata" v-if="!listArr.length">
				<image src="../../static/images/nodata.png" mode=""></image>
				<view class="text">暂无数据</view>
			</view>
		</view>
		
		<view class="loadStyle" v-if="listArr.length">
			<view class="text" v-if="loading==1">数据加载中...</view>
			<view class="text" v-if="loading==2">没有更多了~~</view>
		</view>
		
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				listArr:[],
				navArr:[],
				navIndex:0,
				currentPage:1,
				loading:0    //0代表初始化不显示子，1代表加载中，2代表没有更多数据
			}
		},
		onLoad() {
			this.getNav();
			this.getData();
			
		},
		onReachBottom(){
			console.log("触底了");
			this.loading=1;
			this.currentPage++;
			this.getData();
			
		},
		methods: {
			getData(classid=50){				
				wx.request({
					url:"https://ku.qingnian8.com/dataApi/news/newslist.php",
					data:{
						cid:classid,
						page:this.currentPage
					},
					success:(res)=>{	
						if(res.data.length==0){
							this.loading=2
						}
						this.listArr=[...this.listArr,...res.data]
					}
				})
			},
			getNav(){				
				wx.request({
					url:"https://ku.qingnian8.com/dataApi/news/navlist.php",
					success:res=>{
						console.log(res)
						this.navArr=res.data
					}
				})
			},
			clickNav(id){	
				let index=this.navArr.findIndex(item=>{
					return item.id==id
				})
				this.navIndex=index;
				this.currentPage=1;
				this.listArr=[]
				this.loading=0
				this.getData(id);				
			},
			clickDetail(item){				
				uni.navigateTo({
					url:`/pages/detail/detail?cid=${item.classid}&id=${item.id}`
				})
			}
		}
	}
</script>

<style lang="scss" scoped>
.home{	
	.navscroll{		
		height: 100rpx;
		background: #F7F8FA;
		position: fixed;
		width: 100%;
		top:var(--window-top);
		left:0;
		z-index: 10;
		white-space: nowrap;
		/deep/ ::-webkit-scrollbar {
			width: 4px !important;
			height: 1px !important;
			overflow: auto !important;
			background: transparent !important;
			-webkit-appearance: auto !important;
			display: block;
		}
		
		.row{
			display: inline-block;
			line-height: 100rpx;
			padding:0 30rpx;
			font-size: 40rpx;
		}
		.row.active{
			color:#31C27C;
		}
	}
	.content{
		padding:30rpx;
		padding-top:130rpx;
		.item{
			padding:20rpx 0;
			border-bottom:1rpx #e2e2e2 dotted;
		}
		.nodata{
			padding-top:50rpx;
			display: flex;
			justify-content: center;
			flex-direction: column;
			align-items: center;
			image{
				width: 400rpx;
				height: 400rpx;
			}
			.text{
				color:#999;
				font-size: 20rpx;
			}
		}
	}
	.loadStyle{
		.text{
			font-size: 28rpx;
			color:#999;
			text-align: center;
			padding:20rpx 0;
		}
	}
	
}
</style>
