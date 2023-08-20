<template>
    <div>
        abc的值分别是
        {{ a }}
        {{ b }}
        {{ c }}
    </div>
    <button @click="c+=1">给c++</button>
    <button @click="b+=1">给B++</button>
</template>


<script>
import { watch,ref } from 'vue'
export default {
name: 'watcher',
setup(props) {
    let a=ref(1)
    let b=ref(2)
    let c=ref(3)
    //监视所定义的一个响应式数据。
    watch(c,(newVal,oldVal)=>{
        //do something
        console.log('新的值,旧的值');
        console.log(newVal,oldVal);
        return newVal
    })
    //监视多个数据
    watch([a,b],(newVal,oldVal)=>{
        //do something
        console.log('新的值,旧的值');
        console.log(newVal,oldVal);
        return newVal
    })
    
    return {
        a,
        b,
        c
    }
},   

}



</script>