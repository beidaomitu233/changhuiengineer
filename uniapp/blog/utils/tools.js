//获取富文本内的图片url地址
// 截取前三个图片作为文章的简介展示
export function getImgSrc(richtext,num=3) {
	let imgList = [];
	richtext.replace(/<img [^>]*src=['"]([^'"]+)[^>]*>/g, (match, capture) => {
		  imgList.push(capture);
	});
	imgList=imgList.slice(0,num)
	return imgList;
}

//向外导出省份
export function getProvince(){
	return new Promise((resolve,reject)=>{
		// 将本地信息读取
		let historyProvince=uni.getStorageSync("historyProvince");
		// 如果有缓存就判断，没缓存就直接请求
		if(historyProvince){			
			// 判断信息中的时间和现在的差，如果超过一小时就会重新请求
			if((Date.now() - historyProvince.time) > 1000*60*60){				
				getIp().then(res=>{
					resolve(res)
				}).catch(err=>{
					reject(err)
				})	
			}else{				
				console.log('读取缓存');
				resolve(historyProvince.province);
			}
		}else{			
			getIp().then(res=>{
				resolve(res)
			}).catch(err=>{
				reject(err)
			})		
		}	
	})
}

//获取所在省市
function getIp(){
	return new Promise((resolve,reject)=>{
		uni.request({
			// 高频请求接口可能会被禁止访问，所以将ip地址和对应的时间存储到到本地
			url:"https://restapi.amap.com/v3/ip?key=281a69c34d09a510c55d0ae2a73972e8",
			success:res=>{			
				// 判断获取到的地址是否为空，国外的地址获取不到就为空数组。
				let str=""				
				// 如果province是字符换就是获取到了，就返回城市，没有获取到就显示火星
				typeof(res.data.province) == "string" ? str=res.data.province :str="火星"
				// 返回结果
				resolve(str)
				// 创建信息对象
				let obj={
					province:str,
					time:Date.now()
				}
				// 将信息存储到本地中
				uni.setStorageSync("historyProvince",obj);				
			},
			// 请求失败就报错
			fail:err=>{
				reject(err)
			}
		})
	})	
}

// 封装获取头像,接收数据对象从里面取数据
export function getUserAvatar(item){
	// 这类会获取到来自个人中心和首页的梁总数据格式，所以需要判断对应的数据格式
	
	// 个人中心的数据
	// 登入就会有信息
	if(item.avatar_file?.url ?? false) return  item.avatar_file.url 
	
	// 判断user_id[0]?和avatar_file?存不存，不存在就替换成字符串
	// 文章信息
	return  item.user_id[0]?.avatar_file?.url ?? '@/static/images/user-default.jpg'
}

const db=uniCloud.database()

// 封装获取用户名
export function getUserName(item){
		console.log(item);
		// 这类会获取到来自个人中心和首页的梁总数据格式，所以需要判断对应的数据格式
		// 这是个人中心
		if(item.nickname?? false) return item.nickname||item.nickname
		// 文章信息
		return item.user_id[0].nickname|| item.user_id[0].username||item.user_id[0].mobile||'未命名用户'

}

// 获取用户点赞/评论/文章列表
export function getUserArticle() {
			// 获取用户的文章
  return new Promise((resolve, reject) => {
	db.collection('blogArticles').where(`user_id==$cloudEnv_uid`).orderBy('publish_date', 'desc').get().then(res => {
      resolve(res.result.data);
    }).catch(error => {
      reject(error);
    });
  });
}

// 格式化浏览量 点赞数 评论数等
export function formatViews(views) {
  if (views < 1000) {
    return views.toString();
  } else if (views < 10000) {
    return (views / 1000).toFixed(1) + '千';
  } else if (views < 100000000) {
    return (views / 10000).toFixed(1) + '万';
  } else {
    return (views / 100000000).toFixed(1) + '亿';
  }
}




