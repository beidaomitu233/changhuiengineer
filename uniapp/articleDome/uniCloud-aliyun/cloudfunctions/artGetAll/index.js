'use strict';
const db=uniCloud.database()
exports.main = async (event, context) => {
	
	// 跳过的数量由已经请求并存储到本地数组的长度来决定
	let {skip=0}=event
	
	// 排序，将最新发布的放在最前面，并且限制默认的请求条数,并且设置翻页
 return await  db.collection('article').orderBy("postime","desc").limit(8).skip(skip).get()

};
