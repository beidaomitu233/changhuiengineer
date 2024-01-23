'use strict';
const db=uniCloud.database()
exports.main = async (event, context) => {
	
	
	console.log(event);
	//返回数据给客户端
	return await db.collection('pic').doc(event.id).get()


	 
};
