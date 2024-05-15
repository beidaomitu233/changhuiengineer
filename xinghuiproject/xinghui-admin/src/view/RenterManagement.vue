<template>
  <div>
    <el-row>
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
  </div>
</template>

<script setup>

</script>

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
