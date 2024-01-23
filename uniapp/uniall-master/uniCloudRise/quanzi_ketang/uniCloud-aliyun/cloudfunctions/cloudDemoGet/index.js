'use strict';
const db=uniCloud.database();
const dbCmd = db.command;
exports.main = async (event, context) => {
	let {keyword} =event;
	let res=await db.collection("users").where({
		// age:dbCmd.gt(20).and(dbCmd.lt(40))
		// age:dbCmd.and(dbCmd.gt(10),dbCmd.lt(30))
		// age:dbCmd.or(dbCmd.lt(20),dbCmd.gt(40))	
		// name:/keyword/ig
		// name: new RegExp(keyword,"ig")
	}).get();
	return res;
};
