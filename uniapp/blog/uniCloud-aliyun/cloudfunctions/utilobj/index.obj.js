// 云对象教程: https://uniapp.dcloud.net.cn/uniCloud/cloud-obj
// jsdoc语法提示教程：https://ask.dcloud.net.cn/docs/#//ask.dcloud.net.cn/article/129

// 导入云对象
const db=uniCloud.database()
const dbCmd=db.command

module.exports = {
	_before: function () { // 通用预处理器

	},
	/**
	 * method1方法描述
	 * @param {object} table 要修改的数据表  参数1描述
	 * @param {object} attr  属性
	 * @param {object} id    文章ID
	 * @param {object} num   自增或自减的量
	 */
	
	// 自增方法，通过前端传递数据来操作
 async operation(table,attr,id,num){
		let obj={}
		// inc是更新操作符，用于指示字段自增，将配置对象在外面写，因为里面不好访问attr属性
		obj[attr]=dbCmd.inc(num)
		return await db.collection(table).doc(id).update(obj)
		
		
	}

}
