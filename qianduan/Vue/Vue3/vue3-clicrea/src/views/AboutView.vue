<template>
  <div class="about">
    <h1>This is an about page</h1>
    <h2>{{ studentobj.type }}</h2>
    <h2>{{ studentobj.stname }}</h2>
    <h2>{{ studentobj.graude }}</h2>
    <h2>{{ studentobj.friend.girfiend }}</h2>
    <h2>{{ studentobj.friend.boyfriend[0].stuname }}</h2>
    <h2>{{ studentobj.friend.boyfriend[0].stuage }}</h2>

    <button @click="sayahello">点击查看对象</button>
  </div>
</template>

<script>
import { reactive } from 'vue'
export default {

  name: "about",
  setup () {
    const studentobj = reactive({
      type: "IT",
      stname: "lisi",
      graude: 2025,
      friend: {
        girfiend: "abc",
        boyfriend: [
          { stuname: 'wangwu', stuage: 20 },
          { stuname: 'maliu', stuage: 10 }
        ]
      }
    })
    function sayahello () {
      console.log('hello', studentobj);
    }
    return {
      studentobj,
      sayahello
    }

  }

}





</script>
