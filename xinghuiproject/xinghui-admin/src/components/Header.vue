<template>

  <!-- 头部导航 -->
  <!-- 左侧文字系统名称 -->
  <el-page-header :icon="null" title="星辉房源管理系统" class="color"
                  id="line">
    <!-- 搜索框 -->
    <template #content="" class="flex items-center">
      <span> <el-input v-model="input2" style="width: 240px"
                  placeholder="搜索" :prefix-icon="Search" />
      </span>
    </template>
    <!-- 右侧登入状态与退出按钮 -->
    <template #extra>
      <div class="flex items-center ">
        <span class="mr-3">管理员</span>
        <el-dropdown class="color ">
          <span class="el-dropdown-link ">
            更多
            <el-icon class="el-icon--right ">
              <arrow-down />
            </el-icon>
          </span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item
                                @click="logOut">退出登入</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
    </template>
  </el-page-header>
</template>

<script setup>
import { ArrowDown, Calendar, Search } from '@element-plus/icons-vue'


function logOut () {
  console.log("点击退出");
}

</script>


<style scoped>
.middle {
  vertical-align: middle;
}

.el-dropdown {
  vertical-align: baseline !important;
}

.color {
  color: #ffffff;
}

#line {
  margin: 15px auto;
}

/* 图标样式 */
.example-showcase .el-dropdown-link {
  cursor: pointer;
  color: white;
  display: flex;
  align-items: center;
}

/* Element下拉组件有黑框，去除黑框 */
:deep(.el-tooltip__trigger:focus-visible) {
  outline: unset;
}

.mr-3 {
  margin-right: 2em;
}
</style>