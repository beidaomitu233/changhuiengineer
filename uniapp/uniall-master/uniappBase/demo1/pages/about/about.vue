<template>
	<view>		
		<pubTitle title="我们" subtitle="about page"></pubTitle>
		<navigator url="/pages/index/index">首页</navigator>
		<navigator url="/pages/list/list">列表页面</navigator>
		-----------------------
		<myevent title="组件间的传值" @myenv="onmyenv" @click.native="onClick"></myevent>
		-----------------------
		<button @click="clickBtn">开启{{mystate}}</button>
		<!-- <mypop :state="mystate" @stateEnv="onStateEnv"></mypop> -->
		<mypop :state.sync="mystate"></mypop>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				mystate:false
			};
		},
		methods:{
			onmyenv(e){
				console.log(e)
			},
			onClick(){
				console.log(123123)
			},
			clickBtn(){
				this.mystate=true
			},
			interval(){
				console.log("自定义函数")
			}
		},
		
		created(){
			console.log("这是about的created")			
		},
		mounted(){
			console.log("about 的 mounted")
		}
		
		
	}
</script>

<style lang="scss">

</style>
