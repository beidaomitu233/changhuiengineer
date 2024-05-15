<template>
  <div class="app">
    <!-- -->
    <p>{{ Persionaddress }}</p>
    <button @click="changeAddress">改地址</button>

    <h6>
      书名：《{{ Bookinfo.bookname }}》,书的类型是：{{ Bookinfo.booktype }},价格是：{{ Bookinfo.bookprice }}
    </h6>

  </div>
</template>

<script>
import { reactive, ref, toRefs } from 'vue';

export default {
  name: 'Home',
  setup () {

    let Persionaddress = ref('湖北')

    let Bookinfo = reactive({
      booktype: "哲学",
      bookname: "重新认识你自己",
      bookprice: 29.9

    })
    let Bookinfo2 = ref({
      booktype: "哲学",
      bookname: "重新认识你自己",
      bookprice: 29.9
    })

    let { booktype, bookname, bookprice } = toRefs(Bookinfo)

    function changeAddress () {
      Persionaddress.value = '广西'
      console.log(Persionaddress.value);
      console.log(Persionaddress);
      console.log(Bookinfo);
      console.log(Bookinfo2);

      console.log(booktype);

    }


    return { Persionaddress, changeAddress, Bookinfo }
  }




};
</script>

<style scoped>
.app {
  height: 300px;
  background-color: rgb(185, 229, 155);
  box-shadow: 10, 10, 10, 10;
}
</style>