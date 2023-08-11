<template>
  <nav>
    <router-link :to="{
  name:'home',
  params: {
    msg: 'Welcome to Your Vue.js App',
    title: '首页',
    btn: '打个招呼'
  }
}">Home</router-link>

    <router-link to="/about">About</router-link>
  </nav>
  <router-view />
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
