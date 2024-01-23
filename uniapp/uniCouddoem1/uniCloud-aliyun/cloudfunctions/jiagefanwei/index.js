'use strict';

const db = uniCloud.database()
const dbCmd = db.command
exports.main = async (event, context) => {
	
	let {startprice,endprice}=event
	
	// 获取结合
	const selecthouse= await db.collection('rentlist').where({
		price:dbCmd.gte(startprice).and( dbCmd.lte(endprice))
	}).get()
	
	return {selecthouse}
};
