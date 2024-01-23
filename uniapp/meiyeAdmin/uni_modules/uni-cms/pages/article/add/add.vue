<template>
  <view class="uni-container">
    <view class="header">
      <view class="back">
        <view @click="navigateBack" style="margin-left: 15px;display: flex;align-items: center">
          <uni-icons type="back" size="24"></uni-icons>
          <text>返回</text>
        </view>
      </view>
    </view>
    <uni-forms ref="form" :label-width="90" :model="formData" validateTrigger="submit" err-show-type="toast">
      <view class="edit-box">
        <view class="title">
          <textarea class="uni-input" v-model="formData.title" auto-height @input="() => autoSaveContent && autoSaveContent()" placeholder="话术标题"/>
        </view>
		
        <editor-component @textchange="onTextChange" @ready="onEditorReady"></editor-component>
     
		<view class="settings">
			
          <uni-forms-item name="excerpt" label="分析">
            <textarea
                class="excerpt"
                placeholder="分析"
                auto-height
                v-model="formData.analyze"
                @input="() => autoSaveContent && autoSaveContent()"
            ></textarea>
			
			 </uni-forms-item>
			
			<uni-forms-item name="excerpt" label="关键词">
			  <textarea
			      class="excerpt"
			      placeholder="关键词"
			      auto-height
			      v-model="formData.keyword"
			      @input="() => autoSaveContent && autoSaveContent()"
			  ></textarea>
			
			
          </uni-forms-item>
		  
        
		  
          <uni-forms-item name="user_id" label="作者" required>
            <uni-data-picker v-model="formData.user_id" style="width: 200px;" collection="uni-id-users"
                             where="role=='uni-cms-author'||role=='admin'"
                             field="nickname as text, _id as value"></uni-data-picker>
          </uni-forms-item>
		  
          <uni-forms-item class="zindex" name="category_id" label="话术类型">
			  <!-- 存储分类ID -->
            <uni-data-picker v-model="formData.classifyType" style="width: 200px;"
                             :localdata="cmsCategories" @change="showCategory" > </uni-data-picker>
							 
		  </uni-forms-item>
		  
		  

		  	  <!-- 只获取具体导航中的类别 -->
<!-- 		  <uni-forms-item name="category_id" label="分类">
		
		<uni-data-picker v-model="formData.classifyType" style="width: 200px;"
			:localdata="cmsCategories" :map="{text:'_id.name',value:'_id._id'}"></uni-data-picker> 
	  </uni-forms-item> -->
          <!--					<uni-forms-item name="is_sticky" label="是否置顶">-->
          <!--						<switch @change="binddata('is_sticky', $event.detail.value)" style="transform:scale(0.75)" :checked="formData.is_sticky"></switch>-->
          <!--					</uni-forms-item>-->
          <!--					<uni-forms-item name="is_essence" label="阅读加精">-->
          <!--						<switch @change="binddata('is_essence', $event.detail.value)" style="transform:scale(0.75)" :checked="formData.is_essence"></switch>-->
          <!--					</uni-forms-item>-->
          <!--					<uni-forms-item name="comment_status" label="开放评论">-->
          <!--						<uni-data-checkbox v-model="formData.comment_status"-->
          <!--															 :localdata="formOptions.comment_status_localdata"></uni-data-checkbox>-->
          <!--					</uni-forms-item>-->
        </view>
        <view class="uni-button-group m" style="padding-bottom: 50px">
          <button class="uni-button" style="width: 100px;margin-right: 10px;" @click="submit(0)">存为草稿</button>
          <button type="primary" class="uni-button" style="width: 100px;" @click="submit(1)">发布</button>
        </view>
      </view>
    </uni-forms>
    <view class="footer">
      <view class="wrap">
        <view class="left">
          <text class="auto-save" v-if="autoSave">
            {{ autoSave.status === 1 ? '自动保存中...' : '已自动保存' }}
          </text>
          <text class="word-count" v-if="wordCount !== null">共 {{ wordCount }} 字</text>
        </view>
        <view class="right">
          <view class="uni-button-group">
            <button class="uni-button" style="width: 100px;margin-right: 10px;" @click="submit(0)">存为草稿</button>
            <button type="primary" class="uni-button" style="width: 100px;" @click="submit(1)">发布</button>
          </view>
        </view>
      </view>
    </view>

  </view>
</template>

<script>
// 引入编辑器组件
import EditorComponent from "@/uni_modules/uni-cms/components/editor/editor.vue";
// 引入表单验证规则
import {validator} from '@/uni_modules/uni-cms/common/validator/uni-cms-articles.js';
// 自动保存mixin
import autoSaveMixin from '@/uni_modules/uni-cms/common/auto-save-mixin.js';

// 引入数据库和相关命令
const db = uniCloud.database();
const dbCmd = db.command;
// 定义数据库集合名称
const dbCollectionName = 'uni-cms-articles'
// 引入工具云对象,修改文章数量
const utilobj=uniCloud.importObject('utilobj')

// 获取表单验证规则
function getValidator(fields) {
  let result = {}
  for (let key in validator) {
    if (fields.includes(key)) {
      result[key] = validator[key]
    }
  }
  return result
}

export default {
  components: {
    EditorComponent
  },
  mixins: [autoSaveMixin],
  data() {
    // 初始化formData
    let formData = {
      "user_id": uniCloud.getCurrentUserInfo().uid,
      "category_id": "",
      "title": "",
      "content": {},
	  "classifyType":0,
	  "analyze": "",
      "keyword": "",
      "article_status": 0,
      "is_sticky": null,
      "is_essence": null,
      "comment_status": null,
    }
    return {
      formData, // 表单数据
      formOptions: {
        "comment_status_localdata": [
          {
            "value": 0,
            "text": "关闭"
          },
          {
            "value": 1,
            "text": "开放"
          }
        ]
      },
      rules: {
        ...getValidator(Object.keys(formData)) // 表单验证规则
      },
      formats: {}, // 编辑器格式
      wordCount: null, // 字数统计
	  
	  //导航和类别
	  cmsCategories:[],
    }
  },
  onReady() {
    this.$refs.form.setRules(this.rules) // 设置表单验证规则
	this.getCategories()
  },
  mounted() {
    const sysinfo = uni.getSystemInfoSync()
    this.drawerWidth = sysinfo.windowWidth * .8
  },
  methods: {
	  
	  // 分批将导航和分类ID存储到数据中
	  showCategory(e){
			console.log(e);
			// 将目录ID存储
			this.formData.category_id=e.detail.value[0].value
			console.log(this.formData);
			console.log('111');

				},

	  
	  
	  
	  // 获取分类列表  连表查询根据分类获取不同的类别
	 async getCategories(){
		  	let categories=	 db.collection('uni-cms-categories').getTemp()
		  	let classifyType=db.collection('classifyType').getTemp()
			const redataz= await db.collection(categories,classifyType).get()
			
			this.cmsCategories=this.actionzzz(redataz.result.data)
			
	  },

	  
	  // 将数据转化成组件支持的格式
	actionzzz(data, deepNum=0) { 
    if(!data || data.length <= 0){ 
        return null;
    }

    return data.map(x => { 
        const model = {
            source: x,
            text: x.name,
            value: deepNum === 0 ? x._id._value : x._id, // 根据深度判断_id的位置
        };

        const children = this.actionzzz(x._id.classifyType, deepNum+1); // 子级数据

        if(children){ 
            model.children = children;
        }

        return model; 
    })
},

	  
	  
    // 监听富文本编辑器内容变化
    onTextChange(e) {
      // 更新字数统计
      this.wordCount = e.detail
      // 自动获取编辑器正文内的图片作为封面图
      this.autoGetEditorImage()
      // 自动保存
      this.autoSaveContent && this.autoSaveContent()
    },
    autoGetEditorImage() {
      // 如果不自动获取封面图或者封面图展示方式为不展示，则不执行
      if (!this.autoGetCover || this.thumbMode === 0) return
      // 获取编辑器中的图片
      if (this.timer) {
        clearTimeout(this.timer)
      }
      this.timer = setTimeout(() => {
        this.editorCtx.getContents({
          success: (res) => {
            const {delta} = res
            const imageList = []
            delta.ops.forEach(item => {
              if (item.insert && item.insert.image) {
                if (!item.attributes || !item.attributes.class || item.attributes.class.indexOf('uploading') === -1) {
                  imageList.push(item.insert.image)
                }
              }
            })

            if (imageList.length <= 0) return
            const newThumbnail = [...this.formData.thumbnail]

            for (let i = 0; i < newThumbnail.length; i++) {
              const thumbnail = newThumbnail[i]
              if (thumbnail !== imageList[i]) {
                newThumbnail[i] = imageList[i] || ''
              }
            }
            this.formData.thumbnail = newThumbnail
          },
          fail: (e) => {
            console.error(e)
          }
        })
      }, 1000)

    },
    // 富文本编辑器初始化完成后触发
    onEditorReady(editorCtx) {
      if (!editorCtx) return

      // 保存editorCtx
      this.editorCtx = editorCtx

    },
    /**
     * 验证表单并提交
     */
    submit(status) {
      if (!this.formData.title) {
        // 如果标题为空，提示用户
        uni.hideLoading()
        return uni.showToast({
          icon: 'none',
          title: '文章标题必填',
        })
      }


      this.$refs.form.validate().then((res) => {
        this.editorCtx.getContents({
          success: (e) => {
            // 提交表单
            this.submitForm({
              ...res,
              article_status: status,
              title: this.formData.title.trim(),
              content: e.delta,
			  classifyType:this.formData.classifyType.trim(),
			  keyword:this.formData.keyword.trim(),
			  analyze:this.formData.analyze.trim(),
              publish_date: Date.now()
            })
          }
        })
      }).catch((e) => {
        console.error(e)
      })
    },

    /**
     * 提交表单
     */
    submitForm(value) {
      uni.showLoading({
        mask: true
      })
      // 使用 clientDB 提交数据
      return db.collection(dbCollectionName).add(value).then((res) => {
        uni.showToast({
          icon: 'none',
          title: value.article_status === 0 ? '保存成功' : '发布成功'
        })
        try {
          // 触发父页面事件，刷新数据
          this.getOpenerEventChannel().emit('refreshData')
        } catch (e) {
        }

        // 清除自动保存内容
        this.clearAutoSaveStorage && this.clearAutoSaveStorage()

        setTimeout(() => {
          if (value.article_status === 0) {
            // 跳转到编辑页面
            uni.redirectTo({
              url: '/uni_modules/uni-cms/pages/article/edit/edit?id=' + res.result.id
            })
          } else {
            // 返回上一页
            // uni.navigateBack()
			
			// 添加完成后给分类文章中的数量+1
			/**
			 * method1方法描述
			 * @param {object} table 要修改的数据表  参数1描述
			 * @param {object} attr  属性
			 * @param {object} id    文章ID
			 * @param {object} num   自增或自减的量
			 */
				utilobj.operation('classifyType','article_count',this.formData.classifyType.trim(),1).then(res=>{
					console.log(res);
					
					// 添加完后清除内容
					uni.redirectTo({
						url:'/uni_modules/uni-cms/pages/article/add/add'
					})
					
				})

	
			
          }
        }, 500)
      }).catch((err) => {
        uni.showModal({
          content: err.message || '请求服务失败',
          showCancel: false
        })
      }).finally(() => {
        uni.hideLoading()
      })
    },

    // 返回上一页或跳转到文章列表页
    navigateBack() {
      const pages = getCurrentPages()

      if (pages.length > 1) {
        // 返回上一页
        uni.navigateBack(-1)
      } else {
        // 跳转到文章列表页
        uni.redirectTo({
          url: '/uni_modules/uni-cms/pages/article/list/list'
        })
      }
    },

    openInsertImageDrawer(index) {
      this.$refs.insertImageDrawer.open()
      this.coverIndex = index
    },
    onInsertCover(selectMediaItems) {
      const coverIndex = this.coverIndex !== null ? this.coverIndex : 0
      const image = selectMediaItems[0]
      const newThumbnail = [...this.formData.thumbnail]

      newThumbnail[coverIndex] = image.src

      this.$refs.insertImageDrawer.close()
      this.formData.thumbnail = newThumbnail
    },

    removeThumbnail(index) {
      const newThumbnail = [...this.formData.thumbnail]
      newThumbnail[index] = ''

      this.formData.thumbnail = newThumbnail
      this.autoGetCover = false
    },
  }
}
</script>

<style lang="scss">
@import '@/uni_modules/uni-cms/common/style/article-detail.scss';

.zindex{
 z-index: 1000;
}
</style>
