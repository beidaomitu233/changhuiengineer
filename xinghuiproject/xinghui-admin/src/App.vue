<script setup lang="ts">
import Main from '@/view/Main.vue'
</script>

<template>
  <div class="app">

    <el-container>
      <el-header class="backgroundColor">
        <Header></Header>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <aside-Menu></aside-Menu>
        </el-aside>
        <el-main class="main">
          <!-- 面包屑 -->
          <bread-crumb></bread-crumb>
          <!-- 内容区 -->
          <Main></Main>
        </el-main>
      </el-container>
    </el-container>
  </div>

</template>

<style scoped>
.app {
  width: 90vw;
  height: 100vh;
  box-shadow: 1px 2px 3px 0px rgba(37, 105, 216, 0.4);
}

.backgroundColor {
  background-color: #2569d8;
}
.main {
  height: 90vh;
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.hidd {
  overflow: hidden;
}
</style>