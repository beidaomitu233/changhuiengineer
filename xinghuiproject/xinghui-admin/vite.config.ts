import { defineConfig, loadEnv } from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'


// 配置@路径
import Path from 'path'


/* 写成函数形式可以接收一些启动时的参数 */
export default defineConfig(({ mode }) => {
  const env = loadEnv(mode, process.cwd(), '')

  /* 这里可以判断启动模式 */
  return {
    // 配置env环境文件全局启用
    define: {
      __APP_ENV__: env.APP_ENV,
      /* 以process.env作为变量名全局都可以调用 */
      'process.env': env

    },
    /* 自动导入Element组件 */
    plugins: [vue(), AutoImport({
      resolvers: [ElementPlusResolver()],
    }),
    Components({
      resolvers: [ElementPlusResolver()],
    })],
    resolve: {
      alias: {
        '@': Path.resolve('./src')
      },
    },
    server: {
      // 是否自动在浏览器打开
      open: true,
      cors: true,
      proxy: {
        '/api': {
          target: 'https://mock.presstime.cn/mock/66421216d59f9a21eb50ba1f/api',
          changeOrigin: true,
          secure: false,
          rewrite: (path: any) => path.replace(/^\/api/, '')
        },
      }

    },
    css: {
      // 预处理器配置项
      preprocessorOptions: {
        less: {
          math: "always",
        },
      },
    },


  }


})
/* export default defineConfig({

  plugins: [vue(), AutoImport({
    resolvers: [ElementPlusResolver()],
  }),
  Components({
    resolvers: [ElementPlusResolver()],
  }),],
  resolve: {
    alias: {
      '@': Path.resolve('./src')
    }
  },
  server: {
    // 是否自动在浏览器打开
    open: true,
    cors: true,
    proxy: {
      '/api': {
        changeOrigin: true,
        secure: false,
        rewrite: (path: any) => path.replace(/^\/api/, '/api')
      },
    }

  }
})
 */