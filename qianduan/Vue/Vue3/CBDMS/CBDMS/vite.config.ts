import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// Element 自动导入功能
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'

// 配置@路径
import  Path  from 'path'


// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(),AutoImport({
    resolvers: [ElementPlusResolver()],
  }),
    Components({
      resolvers: [ElementPlusResolver()],
    }),],
  resolve:{
    alias:{
      '@':Path.resolve('./src')
    }
  }
})
