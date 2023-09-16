<template>
  <v-app>
    <!-- 导航栏部分 -->

    <v-main>

      <v-app-bar dense elevation="4" rounded>
        <!-- 导航菜单 -->
        <v-container>
          <v-tabs centered slider-size="3">
            <v-tab v-for="item in tabMenus" :key="item.id"
                   :to="item.path">
              {{ item.name }}
            </v-tab>

          </v-tabs>
          <!-- 登入按钮 -->
          <v-btn color="accent" elevation="2" outlined absolute top
                 right style="top:7px">
            登入</v-btn>
        </v-container>

      </v-app-bar>

      <v-parallax dark src="./assets/vbanner.jpg" height="700">
        <v-row align="center" justify="center">
          <v-col class="text-center" cols="12">
            <h1 class="text-h2 font-weight-black mb-4 ">
              知否
            </h1>
            <h4 class="subheading">
              为您打造全方位的影音，博客，教学，考证网站
            </h4>
          </v-col>
        </v-row>
      </v-parallax>

      <v-container fluid>

        <div class="text-center">
          <h1 class="text-h2 font-weight-black mb-4 mt-10 ">
            知识共享
          </h1>
          <h4 class="subheading">
            知识开放，知识开源。
          </h4>
        </div>
        <!-- 导航小卡片 -->
        <v-card elevation="2" outlined class="mt-10">
          <!-- 卡片标题 -->
          <v-card-title>知识博客</v-card-title>
          <v-card-subtitle>AI领域知识开源</v-card-subtitle>
          <!-- 卡片内容，包含chilp -->
          <v-card-text>
            <!-- 标签内容 -->
            <v-chip class="ma-2" color="success" outlined>
              <v-icon left>
                mdi-server-plus
              </v-icon>
              Server Status
            </v-chip>
          </v-card-text>
        </v-card>

      </v-container>
    </v-main>
    <!-- 内容主题部分: -->

  </v-app>
</template>

<script>

export default {
  name: 'App',
  data () {
    return {
      tabMenus: [

      ],
      bannerImage: './assets/vbanner.jpg'
    }
  },
  methods: {
    //请求菜单数据源方法
    gettabMenus () {
      this.tabMenus = [{
        id: 1,
        name: '首页',
        path: '/home',
        icon: 'mdi-home',
      },
      {
        id: 2,
        name: '博客',
        path: '/blog',
        icon: 'mdi-blogger',
      },
      {
        id: 3,
        name: '学堂',
        path: '/school',
        icon: 'mdi-school',
      },
      {
        id: 4,
        name: '考试',
        path: '/exam',
        icon: 'mdi-school',
      },]

    },
    getbannerImage () {
      this.bannerImage = './assets/vbanner.jpg'
    }
  },
  components: {

  },
  //请求数据源
  created () {
    //获取菜单数据源
    this.gettabMenus()
    //获取banner图片
    this.getbannerImage()
  },
};
</script>
