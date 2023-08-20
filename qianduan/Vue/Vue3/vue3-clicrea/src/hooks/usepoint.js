import { reactive,onBeforeMount } from "vue"

export default function () {

    let pointposition=reactive({
        x:0,
        y:0,
        sum:0,
    })

    function countpoint(){
       return pointposition.sum=pointposition.x+pointposition.y
    }

    onBeforeMount(()=>{
        //挂载前调用
     countpoint()
     console.log("onBeforeMount")
    })



    return{
        pointposition
    }
}