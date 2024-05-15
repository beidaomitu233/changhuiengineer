<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'

import api from '@/api/api'

/* 获取房源情况 */

const HouseCardList = reactive([])
const getHousingStatus = async () => {
  HouseCardList.values = await api.getHousingList({})
}

onMounted(() => {
  getHousingStatus()
})
</script>

<template>

  <!-- 主页布局，以纵向形式分为三栏 -->
  <!-- 第一栏房源数据 -->
  <el-row>
    <el-col :span="24" class="CardShowStyle">
      <!--  <div   class="grid-content ep-bg-purple-dark " /> -->

      <!-- 数据传递过去然后在进行渲染 -->
      <housing-data-card-lite v-for="housingCard in HouseCardList.values"
                              :id="housingCard.id"
                              :title="housingCard.title"
                              :number="housingCard.number"
                              :card-color="housingCard.cardColor"
                              :key="housingCard.id"
                              class="flex-1"></housing-data-card-lite>
    </el-col>
  </el-row>
  <!-- 第二栏房源点击率（预设功能） -->
  <el-row>
    <el-col :span="8" class="CardShowStyle">
      <el-card style="max-width: 500px; max-height:300px;"
               class="flex-1">
        <template #header>规划中....</template>
        <div class="tu">
          <img src="@/assets/planning.png" alt="">
        </div>
      </el-card>
    </el-col>

    <el-col :span="8" class="CardShowStyle">
      <el-card style="max-width: 500px ; max-height:300px;"
               class="flex-1">
        <template #header>规划中....</template>
        <div class="tu">
          <img src="@/assets/planning.png" alt="">
        </div>
      </el-card>
    </el-col>
    <el-col :span="8" class="CardShowStyle">
      <el-card style="max-width: 500px; max-height:300px;"
               class="flex-1">
        <template #header>规划中....</template>
        <div class="tu">
          <img src="@/assets/planning.png" alt="">
        </div>
      </el-card>
    </el-col>
  </el-row>
  <!-- 第三栏房源位置 -->
  <el-row>
    <el-col :span="12" class="CardShowStyle">
      <el-card style=" max-width: 700px; max-height:300px;"
               class="flex-1">
        <template #header>规划中....</template>
        <div class="tu">
          <img src="@/assets/planning.png" alt="">
        </div>
      </el-card>
    </el-col>
    <el-col :span="12" class="CardShowStyle">
      <el-card style=" max-width: 700px; max-height:300px;"
               class="flex-1">
        <template #header>开发中....</template>
        <div class="tu">
          <img src="@/assets/developing.png" alt="">
        </div>
      </el-card>
    </el-col>

  </el-row>

</template>

<style scoped>
.el-row {
  margin-bottom: 20px;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

/* Element下拉组件有黑框，去除黑框 */
:deep(.el-card__body) {
  display: flex;
  justify-content: center;
  align-content: center;
}

.CardShowStyle {
  display: flex;
  justify-content: space-evenly;
  gap: 1rem;
}

.flex-1 {
  flex: 1;
}

.CardShowStyle img {
  width: 20px;
  height: 200px;
}

.tu {
  width: 150px;
  height: 150px;
}
.tu img {
  width: 100%;
  height: 100%;
}
</style>
