const db  = uniCloud.database();
const dbCmd = db.command;
const redis = uniCloud.redis();
const { result } = require("xzs-utils");
module.exports = {
	_before:async function () { // 通用预处理器
		let clientInfo = this.getClientInfo();
		let {clientIP} = clientInfo;		
	},
	async getCount(){
		return db.collection("custom-ip-time").where({
			count:dbCmd.gt(100)
		}).get()		
	},
	async getRedisList(){
		let list = await redis.hgetall("ipUserTable:hash");
		return list;
	},
	_timing:async function(){
		let keys = await redis.hkeys("ipUserTable:hash");
		console.log(keys);		
		console.log(keys.length);		
		let res = await redis.del("ipUserTable:hash");
		return res;
	}
	
}
