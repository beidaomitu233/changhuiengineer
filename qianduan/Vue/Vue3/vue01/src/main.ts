/* 引入创建程序用于创建应用 */

import { createApp } from "vue"
import router from "./router"


/* 引入App组件 */
import App from "./App.vue"

createApp(App).use(router).mount('#app')

