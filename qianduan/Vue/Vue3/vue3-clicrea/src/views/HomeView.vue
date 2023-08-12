<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <button @click="sayhello">打个招呼</button>
  </div>
</template>

<script>
// @ is an alias to /src
import { ref } from 'vue'

export default {
  name: 'HomeView',
  setup () {
    const msg = 'Welcome to Yourzz Vue.js App'
    let username = ref('lisi')
    
    const userinfo = ref({
      userclass: "gaosanwu"
    })

    function sayhello () {
      console.log('hello', msg)
      console.log(username);
      console.log(username.value);
      console.log('````````````````');
      console.log(userinfo);
    }
    return {
      msg,
      sayhello
    }
  }
}
</script>
