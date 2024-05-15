<template>
  <div class="app">

    <div> 新闻标题
      <ul v-for="item in NewList" :key="item.id">
        <li> <router-link :to="{
            name:'newdel',
            query:{
                id:item.id,
                newsName:item.newsName,
                time:item.time,
                content:item.content

        }}">{{ item.newsName }}</router-link></li>
      </ul>
    </div>
  </div>

  <div class="content">新闻内容
    <div class="show"> <router-view></router-view></div>

  </div>
</template>
      
<script lang="ts" setup name="new1" >
import { reactive } from 'vue'

const NewList = reactive([
  {
    id: 1,
    newsName: '科技巨头发布新手机',
    time: '2023-10-05',
    content: '全新折叠屏技术惊艳亮相hhhhhhhhhhhhh'
  },
  {
    id: 2,
    newsName: '火星探测器发现水源迹象',
    time: '2023-10-04',
    content: '可能存水区域引全球关注'
  },
  {
    id: 3,
    newsName: '股市震荡，新能源板块领涨',
    time: '2023-10-03',
    content: '政策利好推动指数上扬'
  },
  {
    id: 4,
    newsName: '国际足联公布世界杯赛程',
    time: '2023-10-02',
    content: '足球盛宴即将在全球展开'
  }
])
</script>
  
    
      <style scoped>
.content {
  margin: 40px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.show {
  width: 700px;
  border: 1px black solid;
}
</style>