'use strict';
const db=uniCloud.database()
exports.main = async (event, context) => {
	
	let {title,author,content}=event
	
	// 返回一个id就表示成功
	 db.collection('article').add({
		postime:Date. now(),
		title,
		author,
		content
	})
	
	return {msg:"添加成功"}

};
