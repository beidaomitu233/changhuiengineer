
/* 创建路由器，并暴露出去前*/

/* 引入路由器,需要先安装这个包 */
import { createRouter, createWebHistory } from 'vue-router'

import Home from '../view/home.vue'
import About from '../view/about.vue'
import New1 from '../view/new1.vue'
import Newdel from '../components/container.vue'

/* 创建路由 */

const router = createRouter({
    /* 创建导航 */
    history: createWebHistory(),
    linkExactActiveClass: 'active',

    routes: [
        /* 路由规则 */
        {
            name: "index",
            path: '/index',
            component: Home
        },
        /* 路由规则 */
        {
            name: "newlist",
            path: '/news1',
            component: New1,
            children: [{
                name: 'newdel',
                path: 'newdel',
                component: Newdel,
                props(route) {
                    /* 直接返回一整个参数对象 */
                    return route.query
                }
            }]
        },
        /* 路由规则 */
        {
            name: "about",
            path: '/about',
            component: About
        }

    ]

})

export default router 