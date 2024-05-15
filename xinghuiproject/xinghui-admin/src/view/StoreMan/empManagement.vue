<template>
  <el-button type="primary" class="left">+添加员工</el-button>
  <el-table :data="tableData" style="max-width: 1200px">
    <el-table-column prop="name" label="名字" width="120" />
    <el-table-column prop="state" label="权限" width="120" />
    <el-table-column prop="city" label="销售小区" width="120" />
    <el-table-column prop="address" label="数据规划中..." width="600" />
    <el-table-column prop="zip" label="数据规划中..." width="120" />
    <el-table-column fixed="right" label="操作" width="120">
      <template #default>
        <el-button link type="primary" size="small"
                   @click="handleClick">
          删除
        </el-button>
        <el-button link type="primary" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script lang="ts" setup>
const handleClick = () => {
  console.log('click')
}

const tableData = [
  {
    name: '李四',
    state: '员工',
    city: '洪山区',
    address: '......',
    zip: 'CA 90036',
    tag: 'Home'
  },
  {
    name: '王五',
    state: '员工',
    city: '武昌区',
    address: '......',
    zip: 'CA 90036',
    tag: 'Office'
  },
  {
    name: '马六',
    state: '员工',
    city: '汉阳区',
    address: '......',
    zip: 'CA 90036',
    tag: 'Home'
  },
  {
    name: '超飞',
    state: '店长',
    city: '全区管理',
    address: '......',
    zip: 'CA 90036',
    tag: 'Office'
  }
]
</script>

<style scoped>
.left {
  display: flex;
  justify-content: left;
}
</style>