'use strict';
const db=uniCloud.database()
const collection=
exports.main = async (event, context) => {
	// 获取集合全部内容
	 // let res=await  db.collection('users').get()
	 
	 // 计算符合条件
	 //  let count=await  db.collection('users').count()
	 
	 // 新增多个
		 
// 	 let res= await db.collection('users').add(
// [{
//   name: 'Alex'
// },{
//   name: 'Ben'
// },{
//   name: 'John'
// }]
		 
// 	 )

	 //新增用户
	 // let res=await db.collection('users').add({
		//  name:event.username,
		//  pass:event.pass
	 // })
	 
	 
	 // 查找特定内容用户
	 
	 let res1=await  db.collection('users').doc('6505e07fbd0220bf8c60caad').get()
	 
	 let res2=await  db.collection('users').limit(10).skip(3).get()
	 
	 let res3=await  db.collection('users').limit(10).orderBy("_id","desc").get()
	 
	 
	 return res3
};
