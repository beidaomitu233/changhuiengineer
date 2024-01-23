'use strict';



const db=uniCloud.database()
exports.main = async (event, context) => {
	
	// 这里有个坑，如果要通过ID来查询，就只能这样写传递对象，否则都会报错
   return await db.collection('article').doc(event.id).get()
	
	
	
};
