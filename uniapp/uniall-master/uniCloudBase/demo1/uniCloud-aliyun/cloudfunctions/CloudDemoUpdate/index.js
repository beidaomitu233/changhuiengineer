'use strict';
const db=uniCloud.database();
const dbCmd=db.command;
exports.main = async (event, context) => {
	let res= await db.collection("users").doc("63370ca1d4c7ab00017a46a7").update({
		// tabs:{
		// 	jobs:"歌手"
		// }
		// "tabs.jobs":"演员"
		// like:dbCmd.unshift(["篮球","打游戏","演戏"])		
		like:dbCmd.push({
			each:["aaa","bbb"],
			position:1			
		})
		// like:dbCmd.push(["打游戏"])
		// like:dbCmd.pop()
		// like:dbCmd.shift()
		// love:dbCmd.inc(-2),
		// tabs:dbCmd.set({
		// 	height:"2.03m"
		// })
	})
	return res;
};
