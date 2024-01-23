const db=uniCloud.database()
exports.main = async (event, context) => {
	let {title,filesUrl}=event
	return await db.collection("picdata").add({		
		title,
		filesUrl		
	})
};
