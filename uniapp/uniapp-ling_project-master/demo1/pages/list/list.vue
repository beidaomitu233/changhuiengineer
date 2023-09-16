<template>
	<view>
		<pubTitle :title="title" subtitle="list page"></pubTitle>
		<h2>新闻列表 页面</h2>
		<navigator url="/pages/index/index">跳转到首页</navigator>
		<navigator url="/pages/about/about">关于我们</navigator>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title:"分类列表"
			};
		}
	}
</script>

<style lang="scss">

</style>
