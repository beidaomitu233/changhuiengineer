<template>
	<view>
		<view class="">
			直接使用客户端操作数据库。简化掉unicloud
		</view>
		
		<!-- 使用组件 -->
		
		<uni-list>
			<uni-list-item v-for="item in artlist" :title="item.title" :note="item.content" :rightText="item.userid[0].nickname||item.userid[0].username">

			</uni-list-item>

	
		</uni-list>
		
		
		<input type="text" v-model.number="artcleNumber" placeholder="输入文章数量" >
		<button @click="getArtcle(artcleNumber)">获取</button>
			<button @click="getrentlist()">获取租金</button>
		<button @click="addArtcle(artcle)">新增</button>
			<button @click="updataArtcle()">修改</button>
			
			<button @click="getArtcleAndUserinfo()">连表查询</button>
	
	</view>
</template>

<script>
	// 操作流程是一样的
	const db=uniCloud.database()
	export default {
		data() {
			return {
				//默认为3
				artcleNumber:3,
				artcle:{
					title:"zzzzqwe",
					content:"zzqwe123zz"
				},
				artlist:[]
			}
		},
		methods: {
			
			
			// 连表查询——通过文章中的关联ID拿到并展示作者的信息
			getArtcleAndUserinfo(){
				// 
				let artTemp=db.collection('frientmoment').getTemp()
				//不应获取全部的消息。例如密码不该取过来,使用field取部分字段
				let userTemp=db.collection('uni-id-users').field('_id,nickname,avatar_file,username').getTemp()
			
			// 相当于将两张表合在一起，也可以单独去一部分和另一张表合在一起
			db.collection(artTemp,userTemp).orderBy("posttime desc").get().then(res=>{
				console.log(res);
				this.artlist=res.result.data
				console.log(this.artlist);
			})
			
			
			},
			
			
			
			// 修改文章，只有管理员才可以
			updataArtcle(){
			 return	db.collection('frientmoment').doc("6512e241466d417a37dd86a9").update({
					title:"重新修改后的标题"
				}).then(res=>{
					console.log(res);
				}).catch(err=>{
					console.log(err);
				})
			
			}
			
			
			
			
			,
			// 获取文章列表
		 	getArtcle(artcleNumber){
				return db.collection('frientmoment').limit(artcleNumber).get().then(res=>{
					console.log(res);
			
					// 成功后提示
					uni.showToast({
						title:'添加成功',
					})
									
				})
			},
			
			// 使用JQL语法来查询数据表
			getrentlist(){
				// 如果查询的内容是字符串就需要再加单引号，
				return db.collection('rentlist').where("price>'5000'").get().then(res=>{
					console.log(res);
		
					// 成功后提示
					uni.showToast({
						title:'查询成功',
					})
									
				 })
				//.catch(err=>{
				// 	// 将错误信息显示客户端
				// 	console.log(err.mess);
				// 	uni.showToast({
				// 		// 默认是输出err.mess
				// 		title:'错误',
				// 		icon:'none'
				// 	})
				// })
			},
			//添加文章
			addArtcle(artcle){
				return db.collection('frientmoment').add({
					// 如果传递的是对象就需要先结构否则校验会失败
					...artcle
				}).then(res=>{
					console.log('添加成功');
					// 成功后提示
					uni.showToast({
						title:'添加成功',
					})
				
					// 将错误拦截让程序运行下去
				}).catch(err=>{
					// 将错误信息显示客户端
					console.log(err);
					uni.showToast({
						// 默认是输出err.mess
						title:err,
						icon:'none'
					})
				})
			}
		}
	}
</script>

<style>

</style>
