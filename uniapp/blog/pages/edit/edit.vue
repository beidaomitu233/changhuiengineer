<template>
	<view class="edit">
		
		<!-- 文章标题 -->
		<view class="title">
			<input type="text" placeholder="请输入标题" placeholder-class="placeholderClass" v-model="Articlecontent.title">
		</view>
		
		<!-- 文章内容 -->
		<view class="content">
			
			<!-- uni富文本组件 -->
			<editor placeholder="开始灵动你的思绪把" 
			class="editcontent"
			show-img-size 
			show-img-resize 
			show-img-toolbar
			@ready="onready"
			@focus="onfocus"
			
			>

			</editor>
			
		</view>
		
		<!-- 编辑按钮 -->
		
		<!-- 只有点击编辑区才会显示按钮栏 -->
		<view class="btnGroup" >
			<!-- 提交按钮 -->
		
			<u-button type="primary" @click="SubmitArticle" >提交文章</u-button>
			
			<!-- 文本编辑工具栏 -->
			<view class="tools" v-if="toolshowStatus">
				<!-- 标题-->
				<view class="item">
					<span class="iconfont" @click="upTitle" :class="upTitleStatus ? 'active':'' ">&#xec8a</span>
				</view>
				
				<!-- 加粗 -->
				<view class="item" @click="overBold">
					<!-- 判断当前是否在加粗状态，在就添加高亮效果 -->
					<span class="iconfont" :class="overBoldStatus ? 'active':'' ">&#xec88</span>
				</view> 
				
				<!-- 斜体 -->
				<view class="item">
					<span class="iconfont" @click="textItalic" :class="textItalicStatus ? 'active':''">&#xec8c</span>
				</view>
				
				<!-- 分割线 -->
				<view class="item">
					<span class="iconfont" @click="insertDivider">&#xec7f</span>
				</view>
				
				<!-- 图像 -->
				<view class="item">
					<span class="iconfont" @click="upLoadImg">&#xec80</span>
				</view>
				
				<!-- 打勾 -->
				<view class="item">
					<span class="iconfont" @click="finish">&#xed1d</span>
				</view>
				
			</view>
		</view>
		
		
	</view>
</template>

<script>
	import {getImgSrc,getProvince} from '@/utils/tools.js'
	const db=uniCloud.database()

	export default {
		data() {
			return {
				// 文本编辑工具栏选中状态
				upTitleStatus:false,
				toolshowStatus:false,
				overBoldStatus:false,
				textItalicStatus:false,
				
				// 文章内容
				Articlecontent:{
					title:"",
					content:"",
					description:"",
					picurls:"",
					province:""
				}
				
			};
		},
		onLoad(){
			getProvince().then(res=>{
				console.log(res);
				this.Articlecontent.province=res
			})
			
		},
		methods:{
			
			onready(){
				uni.createSelectorQuery().in(this).select('.editcontent').fields({
					size:true,
					// 文章的上下文
					context:true,
					// 可以获取到编辑区的DOM结构和其他信息。
				},res=>{
			
					console.log(res);
					this.editorCtx=res.context
				
				}).exec();
			},
			
			
			// 获取焦点时显示工具栏
			onfocus(){
				this.toolshowStatus=true
			},
			
			// 工具栏实现
			
			// 设置标题
			upTitle(){
				this.upTitleStatus=!this.upTitleStatus
				this.editorCtx.format('header','h2')
				
			},
			
			// 加粗
			overBold(){
				// 点击时会修改高亮效果，并且会切换是否加粗
				this.overBoldStatus=!this.overBoldStatus
				this.editorCtx.format('bold')
			},
			
			textItalic(){
				// 点击时会修改高亮效果，并且会切换是否加粗
				this.textItalicStatus=!this.textItalicStatus
				this.editorCtx.format('italic')
			},
			
			// 添加分割线
			insertDivider(){
				// 点击时会修改高亮效果，并且会切换是否加粗
				this.editorCtx.insertDivider()
			},
			
			
			upLoadImg(){
				uni.chooseImage({
					sizeType:['compressed'],
					success: async res=>{
						
						uni.showLoading({
							title:"上传中....",
							mask:true
						})
						
						console.log(res);
						// 以循环的形式上传每张图片,
						 for(let item of res.tempFiles){
							console.log('上传');
							console.log(item);
			
						// 上传到uniCloud云空间，路径是路径，并设置文件名
						// 并且将异步同步化，保证全部正确上传
						let res=await uniCloud.uploadFile({
								filePath:item.path,
								cloudPath:item.name,
								
							})
								console.log('上传2');
								// 返回值fileID是图片的地址
								console.log(res);
								this.editorCtx.insertImage({
									src:res.fileID
								})
						// 上传完成后就关闭加载
						uni.hideLoading()
						}
					}
					
				})
				
				
			},
			
			// 点击完成 ，会收起键盘并且失去焦点
			finish(){
				this.editorCtx.blur({
					success(){
						uni.showToast({
							icon:'success',
							title:"保存成功"
						})
					}
				})
			},
			
			// 提交文章时判断
			SubmitArticle(){
				this.editorCtx.getContents({
					success:(res)=>{
						console.log('文章长度');
						console.log(this.Articlecontent.title.length);
					// 当标题和文章内容都不为空时才可以提交, 
						if(res.text!="\n" && this.Articlecontent.title.length>0){
							console.log(res);
							// 将html格式的文章存储
							this.Articlecontent.content=res.html;
							// 截取纯文本的前60个字
							this.Articlecontent.description=res.text.slice(0,60)
							// 将图片中的前三做个作为预览图放在首页
							this.Articlecontent.picurls=getImgSrc(res.html);
							this.AddArticleToDateBase()
							uni.showLoading({
								title:'文章发布中',
								icon:'loading'
							})
						}else{
						uni.showToast({
							title:'请输入文章内容和标题',
							icon:'error'
						})
						}

					}
				})
				console.log(this.Articlecontent);
				console.log('提交文章');
			},
			
			
			AddArticleToDateBase(){
				db.collection('blogArticles').add({
					// 将文章对象结构后存到数据库
					...this.Articlecontent
				}).then(res=>{
					console.log(res);
					uni.hideLoading()
					uni.showToast({
						title:'发布成功',
						icon:'success'
						
					})
					
					// 发布成功一秒后跳转到首页
					setTimeout(()=>{
						uni.switchTab({
							url:'/pages/index/index'
						})
					},1000)
					

				})
			}

		}
	}
</script>

<style lang="scss">
	
	// 设置文本提示内容样式。
	// 使用穿透拉实现,后续添加组件样式可以使用穿透
/deep/ .ql-blank::before{
		font-style: normal;
		color:#e0e0e0;
	}
	
	.edit{
		padding: 30rpx;
		.title{
			input{
				height: 120rpx;
				font-size: 46rpx;
				border-bottom: 1px solid #e4e4e4;
				margin-bottom: 30rpx;
				color: #666;
			}
			
		}
		// 标题隐形字体颜色
		.placeholderClass{
			color: #e0e0e0
		}
		
		// 文本编辑区
		.content{
			.editcontent{
				height: calc(100vh - 500rpx);
				margin-bottom: 30rpx;
			}

		}
		
		// 工具栏区域
		.tools{
			width: 100%;
			height: 80rpx;
			background-color: #fff;
			border-top: 1px solid #f4f4f4;
			
			position: fixed;
			left: 0;
			bottom: 0;
			
			display: flex;
			justify-content: space-around;
			align-items: center;
			
				.iconfont{
					font-size: 36rpx;
					color:#333
				}
				.active{
					color: #0199FE;
				}
			
			
		}
		
	}

</style>
