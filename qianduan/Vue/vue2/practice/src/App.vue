<template>

  <!-- 任务：用axios请求一个学生数据列表并解构赋值，将学生信息全部输出到页面上。可以对信息修改，添加，删除，显示和隐藏等操作，信息被操作后就会发出提示 -->

  <!-- 分析：1.axios请求 post 取数据，存储在date中
    2.使用v-for循环对象来进行渲染
    3.对信息的修改使用V-model双向绑定，
    4.对信息的添加使用post请求。
    5 对信息的删除使用
    6.对信息的隐藏和显示使用v-if 或者v-show 
    7.修改后发出消息使用watcher
    -->
  <div id="app">
    <div class="box1">
      <ul>
        <li v-for="(item ,index) in Studentlis" :key="item.id"
            :data-index="item.id">
          名字{{item.name}}
          ,学号{{item.son}},年龄
          <input type="text" name="" id="" v-model.number="item.age">
        </li>
      </ul>
    </div>

  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'App',
  data () {
    return {
      Studentlis: [],
      flag: true
    };
  },
  methods: {

  },
  created () {
    axios.get('http://localhost:3000/Studentlist', {
    }).then((res) => {
      console.log(res)
      this.Studentlis = res.data
      console.log(this.Studentlis);
      /* this.Studentlis = res.data */
    }).catch(function (err) {
      console.log(err);
    })

  }
  ,
  watch: {
    deep: true,
    'Studentlis' (newval, odlval) {
      alert(`您已将年龄改为${newval}，原本的年龄为${odlval}`)
    }
  }
}
</script>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
