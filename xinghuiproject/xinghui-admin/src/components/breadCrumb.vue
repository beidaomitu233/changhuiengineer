<template>
  <div>
    <!-- 面包屑 -->
    <el-breadcrumb separator="/" :separator-icon="ArrowRight">
      <el-breadcrumb-item v-for="(item, index) in breadcrumbItems"
                          :key="index"
                          :to="item.to">{{ item.label }}</el-breadcrumb-item>
      <el-breadcrumb-item v-for="(item, index) in breadcrumbItems"
                          :key="index"
                          :to="item.to">{{ item.label }}</el-breadcrumb-item>
    </el-breadcrumb>

  </div>
</template>

<script setup>
import { computed } from 'vue'
import { useBreadcrumbStore } from '@/store/breadCrumbSw';
import { ArrowRight } from '@element-plus/icons-vue'
import { useRouter } from 'vue-router';

const breadcrumbStore = useBreadcrumbStore();
const router = useRouter();

// 监听路由变化，自动添加面包屑
router.afterEach((to) => {
  breadcrumbStore.clearBreadcrumbs(); // 先重置，确保每次导航后重新构建
  const crumbsToAdd = to.meta.breadcrumbs || []; // 假设路由元信息中包含了面包屑信息
  crumbsToAdd.forEach(crumb => breadcrumbStore.addCrumb(crumb.name, crumb.path));
});



// 访问 store 中的面包屑数据
const breadcrumbItems = computed(() => breadcrumbStore.items);



</script>