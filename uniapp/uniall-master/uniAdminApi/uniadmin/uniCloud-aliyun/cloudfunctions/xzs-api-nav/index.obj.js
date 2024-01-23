const db = uniCloud.database();
const { result,redisIpCount} = require("xzs-utils");
const redis = uniCloud.redis()


module.exports = {
	_before:async function () { // 通用预处理器
	    await redisIpCount(this);			
		this.startTime = Date.now();		
	},
	get:async function(){
		let xzsNav =  await redis.get("mySelf:xzs-nav")
		if(xzsNav){
			return result(0,"success",JSON.parse(xzsNav));			
		}		
		let res= await db.collection("xzs_product_nav").field({
			createTime:false,
			orderid:false,
			state:false
		}).where({
			state:true
		}).orderBy("orderid","asc").get();
		let arr = res.data.map(item=>{
			return {
				_id:item._id,
				classname:item.classname,
				icon:item.icon.url
			}
		})		
		redis.set("mySelf:xzs-nav",JSON.stringify(arr));		
		return result(0,"success",arr)
	},
	_after:function(error,result){
		if(error) {
			throw error // 如果方法抛出错误，也直接抛出不处理
		}
		result.timeCost = Date.now() - this.startTime
		return result
	}
	
}
