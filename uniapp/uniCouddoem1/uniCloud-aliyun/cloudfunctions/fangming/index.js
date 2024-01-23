'use strict';

const db = uniCloud.database()
const dbCmd = db.command
exports.main = async (event, context) => {
	
	let {name}=event
	
	// 获取结合
	const selecthouse= await db.collection('rentlist').where({
		title:new RegExp(name, 'ig')
	}).get()
	
	return {selecthouse}
};
