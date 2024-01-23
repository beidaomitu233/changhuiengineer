<template>
	<view>
		<button @click="loadDataz">加载数据</button>
		<unicloud-db v-slot:default="{data, loading, error, options}"  :collection="colList"
		manual
		ref="udb"
		>
		  <view v-if="error">{{error.message}}</view>
		    <view v-else-if="loading">正在加载...</view>
		    <view v-else>
				<uni-list>
					<uni-list-item v-for="item in data" :title="item.title" :note="item.content" :rightText="item.userid[0].nickname||item.userid[0].username">
				   
						</uni-list-item>
				</uni-list>
		    </view>
		</unicloud-db>
		
		
		<view class="">
			
			展示自己的全部内容   当前登入用户名字为：{{currentUser.username}}
			当前登入用户id为{{currentUser._id}}
		</view>
	
		
		<!-- 展示自己的全部内容 -->

	</view>
</template>

<script>
	const db = uniCloud.database()
	export default {
		data() {
			return {
				colList: [
				   db.collection('frientmoment').getTemp(),
				    //不应获取全部的消息。例如密码不该取过来,使用field取部分字段
				   db.collection('uni-id-users').field('_id,nickname,avatar_file,username').getTemp()	
				        ],
					// 查看当前用户ID和名字
				 currentUser:{},
				 currentUserArticle:"userid==$cloudEnv_uid"
			
			};
		},
		async onLoad() {
			const Userinfo= await db.collection('uni-id-users').where('_id==$cloudEnv_uid').field('_id,username').get()
			console.log(Userinfo.result.data[0]);
			this.currentUser=Userinfo.result.data[0]
		},
		methods:{
			loadDataz(){
				this.$refs.udb.loadData() //udb为unicloud-db组件的ref属性值

			}
		}
	}
</script>

<style lang="less">

</style>
