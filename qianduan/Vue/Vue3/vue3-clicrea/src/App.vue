<template>
  <div>
    <tab></tab>
    <nav>
      <router-link to="/comput">计算属性</router-link>
      <br>
      <router-link to="/watch">watch</router-link>
      <router-link to="/watcher">进入数据检测组件</router-link>
    </nav>
    <router-view />
  </div>
</template>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>

<script>
import { ref } from 'vue'
import tab from './components/tab.vue'
export default {
  components: { tab },
  name: 'HomeView',
  setup () {

    return {

    }

  }
}

</script>
