<template>

  <div>

    <el-row class="tac">
      <el-col :span="12">
        <el-menu active-text-color="#2569D8"
                 background-color="#E8F0FD"
                 class="el-menu-vertical-demo" text-color="#7D8592"
                 @open="handleOpen" @close="handleClose">
          <!-- 遍历一级菜单 -->
          <template v-for="navitem in menuList.values.menu"
                    :key="navitem.id">
            <!-- 如果有子菜单，使用el-sub-menu -->
            <el-sub-menu v-if="navitem.children && navitem.children.length > 0"
                         :index="navitem.id"
                         @click="clickMenu(navitem.path)">
              <template #title>
                <el-icon>
                  <Menu />
                </el-icon>

                <span>{{ navitem.title }}</span>
              </template>
              <!-- 遍历子菜单项 -->
              <!-- 通过嵌套解决 el-menu-item无法触发组织冒泡事件-->
              <div v-for="subNavItem in navitem.children"
                   @click.stop="clickMenu(subNavItem.path)">
                <el-menu-item :key="subNavItem.id"
                              :index="subNavItem.id">{{ subNavItem.title }}</el-menu-item>
              </div>

            </el-sub-menu>
            <!-- 如果没有子菜单，直接使用el-menu-item -->
            <el-menu-item v-else :index="navitem.id"
                          @click="clickMenu(navitem.path)">
              <el-icon>
                <HomeFilled />
              </el-icon>
              <span>{{ navitem.title }}</span>
            </el-menu-item>
          </template>
        </el-menu>
      </el-col>
    </el-row>

  </div>

</template>

<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import { Location } from '@element-plus/icons-vue'
import { useRouter } from 'vue-router'
import api from '@/api/api'

const isCollapse = ref(false)
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}

/* 获取首页数据 */
const menuList = reactive([])
const getAsideMenuList = async () => {
  menuList.values = await api.getMenuList({})
  console.log(menuList.values)
}

onMounted(() => {
  getAsideMenuList()
})

const router = useRouter()
const clickMenu = (path: string) => {
  console.log(path)
  router.push(path)
}
</script>

<style scoped>
/* 菜单高度 */
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 95vh;
}

/* 菜单激活时样式 */
:deep(.is-active, ) {
  animation: none;
  background-color: rgba(37, 105, 216, 0.3);
  border-radius: 1rem;
}

/* 菜单激活时样式 */
:deep(.el-menu-item) {
  border-radius: 1rem;
}

/* 鼠标放在菜单时 */
:deep(.el-menu-item:hover, .el-sub-menu__title) {
  background-color: rgba(255, 255, 255, 0.4) !important;
}
</style>
