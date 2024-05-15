<script setup lang="ts">
// 这里可以写组件的逻辑
</script>

<template>
  <div class="app">
    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px">
          <aside-Menu></aside-Menu>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped>
.app {
  width: 90vw;
  height: 100vh;
}
</style>
