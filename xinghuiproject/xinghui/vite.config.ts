import { defineConfig, loadEnv } from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'



const env = loadEnv(process.cwd(), '')
// https://vitejs.dev/config/
export default defineConfig({
  define: {
    __APP_ENV__: env.APP_ENV,
    /* 以process.env作为变量名全局都可以调用 */
    'process.env': env

  },
  plugins: [vue(), AutoImport({
    resolvers: [ElementPlusResolver()],
  }),
  Components({
    resolvers: [ElementPlusResolver()],
  }),],
  server: {
    // 是否自动在浏览器打开
    open: true,
    cors: true,
    proxy: {
      '/api': {
        target: env.VITE_API_BASE_URL,
        changeOrigin: true,
        secure: false,
        rewrite: (path: any) => path.replace(/^\/api/, '')
      },
    }

  }
})
