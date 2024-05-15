<template>
  <!-- 首页第一栏数据卡片组件 -->
  <div class="cardLite" :style="{ backgroundColor: cardColor }">
    <div class="text">
      <h2>{{ number }}</h2>
      <p>{{ title }}</p>
    </div>
    <div class="progresscircle">
      <el-progress stroke-width="15" indeterminate type="circle"
                   :width="100" :height="70" :percentage="75"
                   color="#EF6A55" />
    </div>
  </div>
</template>

<script lang="ts" setup>
import { defineProps } from 'vue'

// 直接定义props，不需要类型校验
const { title, number, cardColor } = defineProps(['id', 'title', 'number', 'cardColor'])
</script>

<style scoped >
.cardLite {
  display: flex;
  justify-content: space-evenly;
  gap: 1rem;
  box-sizing: border-box;
  padding: 20px;
  height: 150px;
  opacity: 1;
  border-radius: 20px;
  box-shadow: 1px 2px 3px 0px rgba(37, 105, 216, 0.4);
}

.text,
.progresscircle {
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.text p,
.text h2 {
  padding: 0;
  margin: 0;
  text-align: left;
  color: #fff;
}

/* Element下拉组件有黑框，去除黑框 */
:deep(.el-progress__text) {
  color: #fff;
}
</style>