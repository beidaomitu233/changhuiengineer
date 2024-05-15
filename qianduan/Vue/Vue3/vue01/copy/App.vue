<template>

  <div class="app">

    <div class="dog">
    </div>

    <div class="nav">
      <h1>路由的基本使用</h1>

      <h2>导航区</h2>
      <router-link active-class="active" to="/">home</router-link>
      <p></p>
      <router-link active-class="active" :to="{name:
                   'index'}">home</router-link>
      <p></p>
      <router-link active-class="active"
                   to="/candy">candy</router-link>

      <h2>路由内容展示区</h2>
      <div><router-view></router-view></div>
    </div>
  </div>

</template>

<script lang="ts">
export default {
  name: 'App',
  setup() {}
}
</script>

<style scoped>
.app {
  background-color: bisque;
  box-shadow: 10, 10, 10, 10;
}
.dog {
  height: 210px;
  background-color: bisque;
  box-shadow: 10, 10, 10, 10;
}
.dog img {
  width: 100%;
}

.active {
  background-color: bisque;
  border-radius: 10px;
}
.nav {
  height: 300px;

  background-color: aquamarine;
}
</style>