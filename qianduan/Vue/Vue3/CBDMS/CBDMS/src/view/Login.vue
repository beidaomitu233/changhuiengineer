<script setup lang="ts">
import { reactive, ref } from 'vue'

//登入选项
let loginType: string[] = reactive(['账号密码登入', '手机号登入'])
//当前选中，默认为第一个
let activeIndex: number = ref(0)

//登入信息
let Userinfo = reactive({
  PhoneNumber: '',
  VerificationCode: '',
  passw: ''
})

let ChangeOption = (index: number) => {
  activeIndex.value = index
  console.log(index)
}
</script>

<template>

  <div class="login-view">

    <div class="login-region">

      <p>茶百道店铺商家后台</p>
      <div class=login-input>
        <!--  这里可以选择两种登入方式   -->
        <div class="login-type">
          <!--    根据所选的登入方式显示不同的输入框,根据点击的来添加样式    -->
          <p v-for="(item,index) in loginType" :key="index"
             :class="{active: index === activeIndex} "
             @click="ChangeOption(index)">{{item}}</p>
        </div>

        <!--   账号登入  -->
        <div class="login-input-region" v-if="activeIndex==0">
          <div class="account">
            <div class="t1">账号</div>
            <el-input placeholder="请输入账号"
                      v-model="Userinfo.PhoneNumber"
                      clearable></el-input>
          </div>
          <div class="passw">
            <div class="t1">密码</div>
            <el-input placeholder="请输入账号" v-model="Userinfo.passw"
                      clearable></el-input>
          </div>

          <el-button type="warning">登入</el-button>
        </div>
        <!--      手机号登入-->
        <div class="login-input-region" v-else>
          <div class="account">
            <div class="t1">账号</div>
            <el-input placeholder="请输入账号"
                      v-model="Userinfo.PhoneNumber"
                      clearable></el-input>
          </div>
          <div class="passw">
            <div class="t1">验证码</div>
            <el-input placeholder="请输入验证码"
                      v-model="Userinfo.VerificationCode" clearable>
            </el-input>
            <el-button link class="code-style">发送验证码</el-button>
          </div>
          <el-button type="warning">登入</el-button>
        </div>

      </div>

    </div>

  </div>

</template>

<style scoped lang="less">
.login-type {
  display: flex;
  flex-direction: row;
  gap: 20px;
}

.login-type p {
  padding: 10px;
}

.t1 {
  width: 70px;
}

.account,
.passw {
  display: flex;
  justify-content: flex-start;
}

.active {
  color: #007bff;
  border-bottom: 1px solid #007bff;
}
</style>