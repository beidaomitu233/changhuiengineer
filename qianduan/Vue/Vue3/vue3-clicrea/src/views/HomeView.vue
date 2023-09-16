<template>
  <div class="home">
    <tab></tab>
    <img alt="Vue logo" src="../assets/logo.png">
    <button @click="sayhello">打个招呼</button>
  </div>
</template>

<script>
// @ is an alias to /src
import { ref } from 'vue'
import tab from '../components/tab.vue'
export default {
  components: { tab },
  name: 'HomeView',
  setup () {

    components: {
      tab
    }

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
