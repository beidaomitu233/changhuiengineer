import { createApp } from 'vue'
import './style.css'
import App from './App.vue'

/* 引入createPinia，用于创建pinia */
import { createPinia } from 'pinia'

/* 创建pinia */
const pinia = createPinia()


createApp(App).use(pinia).mount('#app')
