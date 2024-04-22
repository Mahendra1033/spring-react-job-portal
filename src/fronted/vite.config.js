import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    port: 3000,
    proxy: {
       '/baseUrl': {
         target: 'http://localhost:9898',
         changeOrigin: true,
         rewrite: (path) => path.replace(/^\/baseUrl/, ''),
       }
    }
  },
})
