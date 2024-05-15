<template>
  <div class="app">

    <ul>
      <!--       <li>{{ route.query.newsName }}</li>
      <li>{{ route.query.time }}</li>
      <li>{{ route.query.content }}</li> -->

      <li>{{ newsName }}</li>
      <li>{{ time }}</li>
      <li>{{ content }}</li>
    </ul>

  </div>
</template>
      
<script lang="ts" setup name="container" >
/* 
复杂的写法

import { useRoute } from 'vue-router'

const route = useRoute()

console.log(route) */

/* 简单的*/

defineProps(['id', 'newsName', 'time', 'content'])



</script>
  
      
<style scoped></style>