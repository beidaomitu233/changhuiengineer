<template>
  <div class="tab">

    <div class="tabsty">
      <span v-for="item in tablist.list" :key="item.id"
            :class="active == item.id ? 'active' : ''"
            @click="showbac(item.id)">{{ item.name }}</span>
    </div>

  </div>
</template>
  
  <script>
// @ is an alias to /src
import { reactive, ref } from 'vue'
export default {
  name: 'tab',
  setup () {
    const tablist = reactive({
      list:
        [
          {
            id: 1,
            name: '首页',
            path: '/home',
          },
          {
            id: 2,
            name: '博客',
            path: '/blog',

          },
          {
            id: 3,
            name: '学堂',
            path: '/school',

          },
          {
            id: 4,
            name: '考试',
            path: '/exam',
          }
        ]
    })
    let active = ref(0)


    function showbac (id) {
      console.log(id);
      /* 这里一定要 .value 否则是直接覆盖响应式 变成普通数字了。然后就不会刷新页面就导致没有效果 */
      active.value = id
      console.log(active);
    }
    return {
      tablist,
      active,
      showbac
    }
  }
}
  </script>

<style lang="less">
.tabsty {
  width: 700px;
  height: 70px;
  background-color: antiquewhite;
  span {
    font-size: 30px;
    width: 60px;
    height: 40px;
    color: black;
    margin-right: 20px;
  }
  .active {
    background-color: greenyellow;
    color: white;
  }
}
</style>  