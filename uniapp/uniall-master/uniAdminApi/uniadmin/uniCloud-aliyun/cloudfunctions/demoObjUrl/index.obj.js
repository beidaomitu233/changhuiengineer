const {giveMsg,giveCode,useResult} = require("demo-utils");
const { result,redisIpCount } = require("xzs-utils");
const db = uniCloud.database();

module.exports = {
	_before:async function () { // 通用预处理器	
		//根据ip修改用户的使用次数
		await redisIpCount(this);
		
	
		this.startTime = Date.now() 
		let body = this.getHttpInfo().body
		if(!body){
			throw new useResult(400,"required")
		}
		this.params = JSON.parse( this.getHttpInfo().body );		
	},
	async get(){				
		let {num,page} = this.params;	
		if(!num || !page) throw new useResult(400,"required");
		let res = await db.collection("demoArt").limit(num).orderBy("_id","desc").get();				
		return new useResult(0,"success",res.data,0)
	},
	async add(){
		const cacheKey = `unicloud:jql-cache:dbJQL-test-get:string`
		await redis.del(cacheKey)
		let {title,author} = this.params;
		let res=await db.collection("demoArt").add({
			title,
			author,
			hits:Math.floor(Math.random()*100),
			posttime:Date.now()
		})
		let result = {
			errCode:0,
			errMsg:"新增成功",
			data:res
		}
		return result;
	},
	_after:function(error,result){
		if(error) {
			throw error // 如果方法抛出错误，也直接抛出不处理
		}
		result.timeCost = Date.now() - this.startTime
		return result
	}
}
