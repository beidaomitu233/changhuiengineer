<template>
  <div class="app">
    <!-- 使用TS来实现类型的严谨性。 -->
    {{ BookInfoList }}

    <p>接收的数据</p>
    <p>{{ data1 }}</p>
  </div>
</template>

<script lang="ts">
import axios from 'axios'
import { defineProps, onMounted } from 'vue'
import { BookInfo } from '../types'
export default {
  name: 'Home',
  props: {
    data: {
      type: String
    }
  },
  setup(props) {
    let BookInfoList: Array<BookInfo> = [{ BookName: '成为自己', BookPrint: '机械', BookPrice: 199 }]
    let data1 = props.data

    function getdata() {
      axios({
        method: 'GET',
        url: '',
        data: {}
      })
    }

    return { BookInfoList, data1, getdata }
  },
  onMounted() {}
}
</script>


<style scoped>
.app {
  height: 300px;
  background-color: rgb(185, 229, 155);
  box-shadow: 10, 10, 10, 10;
}
</style>