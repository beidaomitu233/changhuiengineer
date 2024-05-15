import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from "./route"
import * as ElementPlusIconsVue from '@element-plus/icons-vue'


/* 引入createPinia，用于创建pinia */
import { createPinia } from 'pinia'

/* 创建pinia */
const pinia = createPinia()


const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}



app.use(router).use(pinia).mount('#app')

