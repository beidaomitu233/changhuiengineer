<template>
  <div class="main">
    <div class="filterButton">
      <el-form ref="form" :model="sizeForm" label-width="auto"
               :label-position="labelPosition" :size="size">

        <div class="inputAre">
          <el-form-item label="房源标题名称">
            <el-input v-model="sizeForm.name" />
          </el-form-item>

          <el-form-item label="选择小区" class="min-w">
            <el-select v-model="sizeForm.region" placeholder="请选择小区">
              <el-option label="小区1" value="shanghai" />
              <el-option label="小区2" value="beijing" />
            </el-select>
          </el-form-item>

          <el-form-item label="价格区间" class="max-w">
            <el-col :span="10">
              <el-input v-model="sizeForm.name" />
            </el-col>
            <el-col :span="3" class="text-center">
              <span class="text-gray-500">-</span>
            </el-col>
            <el-col :span="10">
              <el-input v-model="sizeForm.name" />
            </el-col>
          </el-form-item>

          <el-form-item label="功能规划中" class="min-w">
            <el-select v-model="sizeForm.region" placeholder="请选择小区">
              <el-option label="小区1" value="shanghai" />
              <el-option label="小区2" value="beijing" />
            </el-select>
          </el-form-item>

          <el-form-item label="功能规划中" class="min-w">
            <el-select v-model="sizeForm.region" placeholder="请选择小区">
              <el-option label="小区1" value="shanghai" />
              <el-option label="小区2" value="beijing" />
            </el-select>
          </el-form-item>

          <el-form-item label="功能规划中" class="min-w">
            <el-select v-model="sizeForm.region" placeholder="请选择小区">
              <el-option label="小区1" value="shanghai" />
              <el-option label="小区2" value="beijing" />
            </el-select>
          </el-form-item>

          <el-form-item label="条件选择">
            <el-checkbox-group v-model="sizeForm.type" class="choice">
              <el-checkbox-button value="Online activities"
                                  name="type">
                洗衣机
              </el-checkbox-button>
              <el-checkbox-button value="Promotion activities"
                                  name="type">
                空调
              </el-checkbox-button>
              <el-checkbox-button value="Promotion activities"
                                  name="type">
                天然气
              </el-checkbox-button>
              <el-checkbox-button value="Promotion activities"
                                  name="type">
                电热水器
              </el-checkbox-button>
              <el-checkbox-button value="Promotion activities"
                                  name="type">
                沙发
              </el-checkbox-button>
              <el-checkbox-button value="Promotion activities"
                                  name="type">
                床
              </el-checkbox-button>
              <el-checkbox-button value="Promotion activities"
                                  name="type">
                桌子
              </el-checkbox-button>

            </el-checkbox-group>
          </el-form-item>
        </div>

        <div> <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
            <el-button>清空</el-button>
          </el-form-item></div>

        <el-divider content-position="center">房源卡片</el-divider>
        <el-button type="primary" @click="onSubmit">+新增房源</el-button>
        <el-button @click="onSubmit">导入</el-button>
        <el-button @click="onSubmit">导出</el-button>
      </el-form>
    </div>

    <div class="showHousingCard">
      <housing-show-card v-for="item in 10"></housing-show-card>

      <el-pagination background
                     layout="total,prev, pager, next,jumper"
                     :total="20" />

    </div>
  </div>
</template>

<script lang="ts" setup>
import housingShowCard from '@/components/housingShowCard.vue'

import { reactive, ref } from 'vue'
import type { ComponentSize, FormProps } from 'element-plus'

const size = ref<ComponentSize>('small')
const labelPosition = ref<FormProps['labelPosition']>('left')

const sizeForm = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: ''
})

function onSubmit() {
  console.log('submit!')
}
</script>

<style scoped>
.main {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.inputAre {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  gap: 0.5rem;
}

.inputAre .el-form-item {
  width: 250px;
}

label {
  font-weight: bold;
}

.choice {
  display: flex;
  justify-content: row;
  flex-wrap: nowrap;
}
.el-checkbox-button {
  /* margin-right: 0.5rem; */
}

/* Element按钮组件有黑框，去除黑框 */
:deep(.el-button:focus) {
  outline: none;
}

.showHousingCard {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-content: center;
  flex-wrap: wrap;
  gap: 16px;
}
</style>
