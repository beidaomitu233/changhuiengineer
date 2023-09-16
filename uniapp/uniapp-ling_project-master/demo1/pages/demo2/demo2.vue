<template>
	<view>
		<view v-on:click="onClick">{{title}}</view>
		<button @click="clickNum">数值：{{num}}</button>		
		
		<view class="box" :style="{background:bgcolor}" @click="clickBg">
			{{random}}
		</view>
		
		<view class="block" :class="{myactive:state}" @click="clickBlock"></view>
		
		<view class="block" :class="state ? 'myactive' : '' "></view>
		
		<view class="nav">
			<view class="item" :class="navIndex==index ? 'active' : ''" v-for="(item,index) in navArr" :key="item.id" 
			@click="clickNav(index)">{{item.title}}</view>
		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title:"优课学院",
				num:1,
				bgcolor:"#c00",
				random:0,
				state:false,
				navArr:[
					{id:1,title:"首页"},
					{id:2,title:"介绍"},
					{id:3,title:"教程"},
					{id:4,title:"组件"}
				],
				navIndex:0
			};
		},
		methods:{
			onClick:function(){
				this.title="uniapp教程"
			},
			clickNum(){
				this.num++
			},
			clickBg(){
				let color="#"+String(Math.random()).substr(3,6);				
				this.bgcolor=color;
			},
			clickBlock(){
				this.state=!this.state
			},
			clickNav(e){				
				this.navIndex=e
			}
			
			
		}
	}
</script>

<style lang="scss">
.box{
	width: 200rpx;
	height: 200rpx;
	background: pink;
}
.block{ 
	width: 300rpx;
	height: 300rpx;
	background: blue;
}
.myactive{ 
	width: 400rpx;
	background: hotpink;
	border-radius: 20rpx;
}


.nav{
	display: flex;
	justify-content:space-around;
	align-items: center;
	.item{
		flex:1;
		line-height: 90rpx;
		background:#ccc;
		text-align: center;
		&.active{ 
			background: #1AA034;
			color:#fff;
		}
	}	
}

</style>
