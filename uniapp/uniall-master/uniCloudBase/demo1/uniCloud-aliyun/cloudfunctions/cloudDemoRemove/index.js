'use strict';
const db=uniCloud.database();
const dbCmd=db.command;
exports.main = async (event, context) => {
	return await db.collection("users").where({
		_id:dbCmd.neq(-1)
	}).remove() 
};
