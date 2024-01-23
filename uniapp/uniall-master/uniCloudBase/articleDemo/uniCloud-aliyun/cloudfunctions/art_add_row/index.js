const db=uniCloud.database()
const dbCmd = db.command
exports.main = async (event, context) => {
	let {detail,picurls} = event;	
	
	return await db.collection("article").add({
		addip:context.CLIENTIP,
		posttime:Date.now(),		
		picurls,
		...detail
	})
};
