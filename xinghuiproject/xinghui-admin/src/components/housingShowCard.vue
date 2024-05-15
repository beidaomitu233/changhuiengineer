<template>
  <div class="housingMain">

    <div class="housingPic">
      <el-image class="img"
                src="https://pic1.ajkimg.com/display/anjuke/e73cb9390e66294f1ae82195630d6ae9/600x450c.jpg?t=1&srotate=1"
                :fit="fill" />
    </div>

    <div class=" text">
      <el-text size="large" truncated>金地格林东郡 2室1厅1卫 81平 配套齐全
        南北通透 </el-text>
      <div class="houseInfoGroup">
        <el-text class="mx-1 mr-2" size="small">2室1厅1</el-text>
        <el-text class="mx-1 mr-2" size="small">50平米</el-text>
        <el-text class="mx-1 mr-2" size="small">中层共6层</el-text>
      </div>
      <div class="houseLocationGroup">
        <el-text class="mx-1 mr-2" size="small">金地格林东郡
        </el-text>
        <el-text class="mx-1 mr-2" size="small">洪山</el-text>
        <el-text class="mx-1 mr-2" size="small">光谷软件园</el-text>
        <el-text class="mx-1 mr-2" size="small">纺织路10号</el-text>
      </div>
      <div class="houseFeatureTags flex gap-2">
        <el-tag type="primary mr-2">落地窗</el-tag>
        <el-tag type="success mr-2">近地铁</el-tag>
        <el-tag type="info mr-2">朝南</el-tag>
      </div>
    </div>

  </div>
</template>
  
  <script setup>
  
  </script>
  
  <style scoped>
.housingMain {
  display: flex;
  justify-content: row;
  width: 40.625rem;
  height: 10rem;
  border-left: 5px solid #1890ff;
  background-color: #e8f0fd;
}

.housingPic {
  flex: 1;
}

.text {
  flex: 3;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  padding: 1rem;
}

.houseInfoGroup {
}

.mr-2 {
  margin-right: 0.7rem;
}

.img {
  padding-left: 0.1rem;
  width: 158px;
  height: 158px;
}
</style>
  