import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
//引入element-ui的样式
//import 'element-ui/lib/theme-chalk/index.css'

//Vue.use(ElementUI)
 
//按需引入
import { Button, Select, Slider } from "element-ui";

//第一个参数是组件名，就是在组件总是用的名字，第二个是组件
Vue.component(Slider.name, Slider);


Vue.config.productionTip = false

new Vue({
  render: (h) => h(App),
}).$mount("#app");
