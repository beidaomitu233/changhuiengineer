const db=uniCloud.database()
const dbCmd = db.command
exports.main = async (event, context) => {
	let {detail,picurls} = event;
	return await db.collection("article").doc(detail._id).update({	
		updateip:dbCmd.push(context.CLIENTIP),
		title:detail.title,
		author:detail.author,
		content:detail.content,
		picurls
	})
};
