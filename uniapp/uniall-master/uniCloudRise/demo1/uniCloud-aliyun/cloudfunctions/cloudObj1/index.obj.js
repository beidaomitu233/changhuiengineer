const db=uniCloud.database();
module.exports = {
	_before: function () { // 通用预处理器

	},
	async get(num){
		return await db.collection("article").limit(num).get();
	},
	add:async ()=>{
		await db.collection("article").add({
			title:"测试标题",
			content:"测试内容"
		})
	}
}
