
/* 创建路由器，并暴露出去前*/

/* 引入路由器,需要先安装这个包 */
import { createRouter, createWebHistory } from 'vue-router'

/* 创建路由 */

const router = createRouter({
    /* 创建导航 */
    history: createWebHistory(),

    routes: [

        {
            path: '/',
            name: 'Login',
            /* 后续导入，需要在tsconf中配置路径 */
            component: () => import("@/view/Login.vue")

        }
    ]

})

export default router 