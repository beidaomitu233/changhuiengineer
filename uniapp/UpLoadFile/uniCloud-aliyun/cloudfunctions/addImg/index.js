'use strict';
const db=uniCloud.database()
exports.main = async (event, context) => {
	

	let {fileUrl,imgtitle}=event
	console.log('后端拿到图片地址');
	console.log(event);
	return await db.collection('pic').add({
			fileUrl,
			imgtitle
	})
	 
};
