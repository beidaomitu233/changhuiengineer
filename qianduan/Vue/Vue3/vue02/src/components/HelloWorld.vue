<script setup lang="ts">

import {useCountStore} from "../../store/Count.ts";
/* 引入storeToRefs */
import { storeToRefs } from 'pinia'

let CountStore=useCountStore()

console.log(CountStore)

let {PhoneNumber,countTenTime}=storeToRefs(CountStore)

console.log(PhoneNumber)

</script>

<template>
  <h1>{{ PhoneNumber }}</h1>

  <div class="card">
    <button type="button" @click="PhoneNumber++">count is {{ PhoneNumber }}</button>
  </div>

  <div class="card">
    <button type="button">10倍大小 ：{{ countTenTime }}</button>
  </div>
 </template>

<style scoped>
.read-the-docs {
  color: #888;
}
</style>
