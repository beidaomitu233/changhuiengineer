<template>
	<view>
		<button @click="getDate">加载</button>
		<button @click="addData">添加数据</button>
		<unicloud-db v-slot:default="{data, loading, error, options}" collection="cloudDemo,uni-id-users"
		orderby="posttime desc" 
		field="title,content,posttime,userid{username,avatar_file}"		
		loadtime="auto"
		ref="udb"
		>			
			<view v-if="error">{{error.message}}</view>		
			<view v-else-if="loading">
				<uni-load-more status="loading"></uni-load-more>
			</view>
			<view v-else>
				<uni-list>
					<uni-list-item v-for="item in data" 
					:title="item.title" 
					:note="item.content"
					:thumb="item.userid[0].avatar_file.url"
					:rightText="item.userid[0].username"
					clickable
					@click="onRemove(item._id)"
					></uni-list-item>
				</uni-list>
			</view>
		</unicloud-db>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				myWhere:"userid == $cloudEnv_uid",				
			}
		},
		methods: {
			
			addData(){
				let obj={
					title:"udb为unicloud-db组件的ref属性值",
					content:"云端执行数据库查询的前或后，触发某个action函数操作，进行预处理或后处理，详情。HBuilder 3.1.0+"
				}
				this.$refs.udb.add(obj,{
					 toastTitle: '新增成功', // toast提示语
					  success: (res) => { // 新增成功后的回调
						this.$refs.udb.loadData()
					  }
				})
				
			},
			onRemove(id){
				this.$refs.udb.remove(id)
			},
			getDate(){
				this.$refs.udb.loadData()
			}
		},
		onLoad(){
			
		},
		onReady(){
			
			
		}
	}
</script>

<style>

</style>
