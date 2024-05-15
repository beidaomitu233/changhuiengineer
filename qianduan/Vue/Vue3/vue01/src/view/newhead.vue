<template>
  <div class="app">

    <div class="head">
      <h1>北岛新闻网</h1>
    </div>

    <div class="nav">

      <router-link class="nav-unactive" active-class="nav-active"
                   :to="{name:'index'}">

        <div>首页</div>

      </router-link>

      <router-link class="nav-unactive" active-class="nav-active" :to="{
                    name:'newlist'
                   }">
        <div> 科技类新闻 </div>
      </router-link>

      <router-link class="nav-unactive" active-class="nav-active"
                   :to="{name:'about'}">
        <div>关于</div>
      </router-link>

    </div>

  </div>
</template>
  
  <script lang="ts" setup name="newhead" >
</script>
  
  
  <style scoped>
.head {
  display: flex;
  justify-content: center;
  align-items: center;
}
.head h1 {
  width: 70%;
  color: #333;
  text-align: center;
  border-radius: 20px;
  background: linear-gradient(to right, #add8e6, #e6e6fa);
}

.nav {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 15%;
}
.nav-unactive {
  padding: 10px 30px;
  text-align: center;
  border-radius: 10px;
  color: #333;
  background-color: #add8e6;
}

.nav-active {
  background-color: #74efaf;
  color: coral;
}
</style>