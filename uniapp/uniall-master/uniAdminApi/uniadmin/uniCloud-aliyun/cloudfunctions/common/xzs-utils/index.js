const redis = uniCloud.redis()
//返回的提示文字的格式化
function giveMsg(str){
	let msgObj={
		"success":"查询成功~",
		"noSuccess":"查询失败",
		"add":'新增成功',
		"noAdd":"新增失败",
		"required":"缺少参数",
		"time":"请求过于频繁",
		"noCount":"请求次数超出限制，请明天再调用，或使用【备用mock】接口，或加咸虾米QQ：513894357增加次数"
	}
	return msgObj[str]
}

function giveCode(num){
	let codeObj={
		0:0,      //成功的代码
		400:400   //调用失败的代码
	}
	return codeObj[num]
}


function result(errCode,errMsg,data,total){
	return {
		errCode:giveCode(errCode),
		errMsg: giveMsg(errMsg),
		data,
		total
	}
}

async function redisIpCount(that){
	let clientInfo = that.getClientInfo();
	let {clientIP} = clientInfo;
	let ipUserTable = 'ipUserTable:hash';
	let ipCount =await redis.hget(ipUserTable,clientIP);
	
	if(ipCount){
		ipCount--;
		await redis.hset(ipUserTable,clientIP,ipCount);
		//这里故意将拦截放到下面，目的是为了记录用户没有访问次数了，是否还在刷接口
		if(ipCount<0) throw result(400,"noCount"); 		
	}else{
		let count = 299;
		await redis.hset(ipUserTable,clientIP,count);
	}
}


module.exports = {
	giveMsg,
	giveCode,
	result,
	redisIpCount
}

