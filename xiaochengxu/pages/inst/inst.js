// pages/inst/inst.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    count:1,
    count2:0,
    poem:"黄河之水天上来123",
    query:{},
    flag:true,
    bannerList:[]
  },

  getbannerList(){
    let url = 'https://gpt.aigcyz.com/static/xiaochengxu/banner.json';
  url = url + '?t=' + new Date().getTime();
  wx.request({
  url: url,
  method: 'GET',
  success: (res)=> {
    console.log(res.data);
    this.setData({
      bannerList:res.data.images
    })
    
  }
})

  },

  changgedata(){
    // 通过调用内部方法来修改setData
    this.setData({
      count:this.data.count+1
    })
  },
  changgedata2(e){
    // 通过调用内部方法来修改setData\
    console.log(e);
      this.setData({
        count2: e.target.dataset.usernum+this.data.count2
      })
  },
  setpoem(e){
    // 通过调用内部方法来修改setData\
    console.log(e);
      this.setData({
        // 值发生变化后文本框中的最新值
        poem: e.detail.value
      })
  },

  gotoshowpic(){
    wx.switchTab({
      url: '/pages/showpic/showpic',
    })
  },
  gotoindex(){
    wx.navigateTo({
      url: '/pages/index/index',
    })
  },
  gotolog(){
    wx.navigateBack()
  },

  //一次完整的拉取刷新
  getlist(){
    this.data.flag=false,
    wx.showLoading({
      title: '数据加载中...',
    })
      wx.request({
        url: 'https://www.fastmock.site/mock/d5676db29e9d85aaf6101253cf423499/newslist/newlist/tech',
        method:'GET',
        success:({data,statusCode})=>{
          if(statusCode==200)
          this.setData({
            query:data
          })
          console.log(this.data.query);
        },
        complete:()=>{
          wx.hideLoading()
              // 将下拉关闭
          wx.stopPullDownRefresh()
          setTimeout(() => {
            this.setData({
              flag: true
            });
          }, 1000);
        
        }
      })
  },



  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    console.log(options);
    this.getbannerList()
    this.setData({
      query:options
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {
    wx.setNavigationBarTitle({
      title: '动态标题',
    })

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {
    console.log('被调用了');
    if(this.data.flag){
    //下拉请求数据
    this.getlist()
    }else{
      return
    }




  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {
    console.log();
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})