<template>
	<view class="">
		
		<view class="fiter">
			
			<view class="serchh">
				<form @submit="onsubmit">
					<input type="text" placeholder="输入名" name="serchname">
					<button form-type="submit">确定</button>
				</form>
			</view>
			
			<view class="pricescope">
				
				<form @submit="onsubmitprice">
					<input type="number" placeholder="起" name="startprice">
					<input type="number" placeholder="顶" name="endprice">
					<button form-type="submit">确定</button>
				</form>
							
			</view>
			
		</view>
		

	<view class="box1" v-for="(item,index) in houselist" :key="index">
		
			<view class="imgsty">
				<image :src="item.img" alt=""> ></image>
			</view>
		
		<view class="houseInfo">
			
			<view class="title">
			 	{{item.title}}
			</view>
			
			<view class="room">
			</view>
			
			<view class=" locaprice ">
				
				<view class="location">
					未知
				</view>
				
				
				
				<view class="price">
					{{item.price}}
				</view>
				
			</view>
			
			<view class="tags">
				整租
			</view>
			
			
				
			</view>
			
		</view>
		</view>
</template>

<script>
	export default {
		data() {
			return {
				houselist:[],
				housetotal:null,
				wordserch:''
			};
		},
		methods:{
			getrentlist(){
				uniCloud.callFunction({
					name:'rent'
				}).then(res=>{
					console.log(res.result);
					this.houselist=res.result.houselist.data
					this.housetotal=res.result.housenum.total
					
					console.log(this.houselist);
				})
			},
			onsubmit(e){
				console.log(e.detail.value.serchname);
				uniCloud.callFunction({
					name:'fangming',
					data:{
						startprice:e.detail.value.startprice,
						endprice:e.detail.value.endprice,
						
					}
				}).then(res=>{
					console.log(res.result);
					this.houselist=res.result.selecthouse.data

				})
			},
				
			onsubmitprice(e){
				console.log(e.detail.value);
				uniCloud.callFunction({
					name:'jiagefanwei',
					data:{
						startprice:e.detail.value.startprice,
						endprice:e.detail.value.endprice
						
					}
				}).then(res=>{
					console.log(res.result);
				this.houselist=res.result.selecthouse.data
				})
			}
		},
		onLoad() {
			this.getrentlist()
		}
	}
</script>

<style lang="less">
	
	.fiter{
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		
		input{
			display: inline-block;
			background-color: aqua;
		}
	}
	
	
	.box1{
		display: flex;
		flex-direction: row;
		width: 95%;
		height: 160rpx;
		padding: 15rpx;
		font-size: 12rpx;
	}
	
	.imgsty{
		display: 1;
		    width: 40%;
		    height: 150rpx;
			background-color: antiquewhite;
			
			image{
				width: 100%;
				height: 100%;
			}
			
	}
	
	.houseInfo{
		display: 1;
		display: flex;
		width: 60%;
		flex-direction: column;
		justify-content: space-around;
		background-color: burlywood
		
	}
	
	.locaprice{
		display: flex;
		flex-direction: row;
		justify-content: space-around;
	}
	
	.price{
		font-size: 30rpx;
		font-weight: bold;
		color:rgb(255, 125, 35);
		text-align: right
	}
	
	.title{
			margin-top: -1px;
			font-size: 30rpx;
		    height: 20px;
		    line-height: 20px;
		    font-weight: 700;
			    white-space: initial;
			    overflow: hidden;
			    text-overflow: ellipsis;
				-webkit-line-clamp: 1;
	}
	.tags{
		width: 48rpx;
		height: 32rpx;
		padding: 4rpx 16rpx;
		text-align: center;
		background-image: initial;
		color: rgb(116, 216, 132);
		background-color: rgb(10, 51, 22)
		  
	}

</style>
