<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <button @click="sayhello">打个招呼</button>
    <h1>{{ msg }}</h1>
  </div>
</template>

<script>
// @ is an alias to /src
import {ref} from 'vue'
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  setup() {
  const msg = 'Welcome to Yourzz Vue.js App'
  let username=ref('lisi')
  function sayhello(){
    console.log('hello', msg)
    console.log(username);
    console.log(username.value);
  }
    return {
      msg,
      sayhello
    }
  }
}
</script>
