<template>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column fixed prop="date" label="事件" width="150" />
    <el-table-column prop="name" label="操作人" width="120" />
    <el-table-column prop="state" label="操作内容" width="120" />
    <el-table-column prop="city" label="房间ID" width="120" />
    <el-table-column prop="address" label="数据规划中...." width="600" />
    <el-table-column prop="zip" label="数据规划中...." width="120" />
    <el-table-column fixed="right" label="修改" width="120">
      <template #default>
        <el-button link type="primary" size="small"
                   @click="handleClick">
          撤回操作
        </el-button>
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
    date: '2016-05-03',
    name: '李四',
    state: '新增房间',
    city: 'Los Angeles',
    address: '......',
    zip: 'CA 90036',
    tag: 'Home'
  },
  {
    date: '2016-05-02',
    name: '王五',
    state: '新增房间',
    city: 'Los Angeles',
    address: '......',
    zip: 'CA 90036',
    tag: 'Office'
  },
  {
    date: '2016-05-04',
    name: '王五',
    state: '出租房间',
    city: 'Los Angeles',
    address: '......',
    zip: 'CA 90036',
    tag: 'Home'
  },
  {
    date: '2016-05-01',
    name: '超飞',
    state: '修改房间信息',
    city: 'Los Angeles',
    address: '......',
    zip: 'CA 90036',
    tag: 'Office'
  }
]
</script>
