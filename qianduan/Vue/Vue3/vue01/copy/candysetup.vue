<template>
  <div class="app">
    <p>计算属性</p>
    <!-- 计算器 -->

    <input type="text" v-model.number="firstNum">
    <input type="text" v-model.number="secondNum">

    <p>相加的结果：{{ addtion }}</p>

    <p>监视器</p>
    <p>数据:{{ Num1 }}</p>
    <button @click="changNum">加一</button>

    <p>自动监视器，检测服务器资源状态，超过一定值出发警报</p>

    <p>{{ computeStatus }}</p>

    <button @click="addComputeStatus">添加CPU使用率</button>

  </div>
</template>

<script setup lang="ts" name="Candysetup">
import { computed, reactive, ref, watch, watchEffect } from 'vue'

let firstNum = ref('')
let secondNum = ref('')

/* 简单模拟服务器状态 */
let computeStatus = reactive({
  CPU: 0,
  GPU: 0,
  RAM: 0,
  ROM: 0
})

let Num1 = ref(0)

function changNum() {
  Num1.value++
}

function addComputeStatus() {
  computeStatus.CPU += 35
}

let addtion = computed(() => {
  return firstNum.value + secondNum.value
})

const basewatch = watch(Num1, (newval, oldval) => {
  console.log(basewatch)

  console.log('Num1变化', newval, oldval)
  if (Num1.value > 5) {
    basewatch()
  }
})

/* 当检测数据较多的时候，一个个写不显示，watchEffect可以根据调用的变量或对象自动进行检测 */

watchEffect(newval => {
  if (computeStatus.CPU > 95) {
    console.log('xxx率用率超过95%,当前值为', newval)
  }
})
</script>



<style scoped>
.app {
  height: 300px;
  background-color: rgb(91, 182, 234);
  box-shadow: 10, 10, 10, 10;
}
</style>