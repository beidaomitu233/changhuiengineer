
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            name: "Main",
            path: "/",
            redirect: "/housing",
            component: import("@/view/Main.vue"), // 确保这是正确的组件
            children: [
                {
                    name: "Home",
                    path: "/Home",
                    component: import("@/view/Home.vue"), // 确保这是正确的组件
                },
                {
                    name: "housing",
                    path: "/housing",
                    component: () => import("@/view/housingManagement.vue"),
                },
                {
                    name: "Renter",
                    path: "/Renter",
                    component: () => import("@/view/RenterManagement.vue"),
                },
                {
                    name: "staffManagement",
                    path: "/staffManagement",
                    component: () => import("@/view/StoreMan/empManagement.vue"),
                },
                {
                    name: "operationRecords",
                    path: "/operationRecords",
                    component: () => import("@/view/StoreMan/operatingdata.vue"),
                }
            ]
        }


    ],
});

export default router;
