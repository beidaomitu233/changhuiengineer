'use strict';
const db = uniCloud.database()
exports.main = async (event, context) => {
	
	console.log(event);
	console.log(context);
	
	// 获取结合
	const houselist= await db.collection('rentlist').get()
	const housenum= await db.collection('rentlist').count()

	return {houselist,housenum}
};
