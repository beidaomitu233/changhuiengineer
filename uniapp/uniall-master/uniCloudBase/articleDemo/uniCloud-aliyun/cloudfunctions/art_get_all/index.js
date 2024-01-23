const db=uniCloud.database();
const dbCmd = db.command
exports.main = async (event, context) => {	
	let {skip=0} = event;
	return await db.collection("article").where({
		delState:dbCmd.neq(true)
	}).limit(8).skip(skip).orderBy("posttime","desc").get();
};
