<template>
  <div class="app">

    <div class="show"> <router-view></router-view></div>

  </div>
</template>
    
    <script lang="ts" setup name="newmain" >
</script>

    
    
    
    <style scoped>
.app {
  margin: 40px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.show {
  width: 700px;
  height: 700px;
  border: 1px black solid;
}
</style>