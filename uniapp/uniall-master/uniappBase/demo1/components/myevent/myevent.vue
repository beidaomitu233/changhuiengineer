<template>
	<view>
		{{title}}
		<view>
			<input type="text" placeholder="请输入..." @input="oninput">
		</view>
	</view>
</template>

<script>
	export default {
		name:"myevent",
		data() {
			return {
				
			};
		},
		props:{
			title:{
				type:String,
				default:"默认标题"
			}
		},
		methods:{
			oninput(e){
				console.log(e.detail.value)
				this.$emit("myenv",{value:e.detail.value,time:Date.now()})
				
			}
		}
	}
</script>

<style lang="scss">

</style>