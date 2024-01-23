// 云对象教程: https://uniapp.dcloud.net.cn/uniCloud/cloud-obj
// jsdoc语法提示教程：https://ask.dcloud.net.cn/docs/#//ask.dcloud.net.cn/article/129
const db=uniCloud.database()
module.exports = {
	_before: function () { // 通用预处理器

	},
	/**
	 * method1方法描述
	 * @param {string} param1 参数1描述
	 * @returns {object} 返回值描述
	 */
		
	async get(num){
		return	await db.collection('article').limit(num).get()
	},
	
	add: async ()=>{
		return await db.collection('article').add({
			title:'ces',
			content:'ces'
		})
	}
}
