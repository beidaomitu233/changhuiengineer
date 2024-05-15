import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    proxy: {
      '/processvideos': {
        target: 'http://localhost:6679',
        changeOrigin: true,
        secure: false,
        rewrite: (path) => path.replace(/^\/processvideos/, '')
      }
    }
  }
})
