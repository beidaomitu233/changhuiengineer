const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      "/a": {
        target:
          "https://service-pt90ytjw-1301313908.usw.apigw.tencentcs.com/v1/chat/completions",
        changeOrigin: true,
        pathRewrite: {
          "^/a": "",
        },
      },
    },
  },
});
 