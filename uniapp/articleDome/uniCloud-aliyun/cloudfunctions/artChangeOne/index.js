'use strict';
const db=uniCloud.database()
exports.main = async (event, context) => {
	console.log('后端获取到');
	console.log(event);
	console.log(event.id);
	return db.collection('article').doc(event.id).update({
		title:event.title,
		author:event.author,
		content:event.content
	})

	 
};
