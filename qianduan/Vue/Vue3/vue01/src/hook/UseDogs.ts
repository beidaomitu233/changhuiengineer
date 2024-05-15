/* 实现一个请求图片然后展示在页面上的小功能点 */

import axios, { AxiosError } from "axios";
import { onMounted, reactive } from "vue";



/* Hook中的内容都是要向外暴露的 */

export default function () {

    let DogList = reactive<string[]>([])

    async function getPicture() {

        try {
            let dataz = await axios.get('https://dog.ceo/api/breed/pembroke/images/random')
            console.log(dataz);
            /* 根据数据的样子来赋值 */
            DogList.push(dataz.data.message)

        } catch (error) {

            const err = <AxiosError>error
            console.log("出错拉", err.message);
        }


        console.log(DogList);

    }

    /* 将函数挂在到周期函数上使其被调用 */

    onMounted(() => {
        getPicture()
    });


    return { DogList, getPicture }

}









