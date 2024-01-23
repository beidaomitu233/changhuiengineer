<template>
    <div class="home">
        <img alt="Vue logo" src="../assets/logo.png">
        <button @click="getlog">打个招呼</button>
        <p>{{ personame }}</p>
        <p>{{ age }}</p>
    </div>
</template>

<script>
// @ is an alias to /src
import {ref, toRef,toRefs, reactive } from 'vue'
export default {
    name: 'torefsz',
    setup() {
        let person=reactive({
            name:'lisi',
            age:18
        })

        function getlog(){
            console.log('``````person源对象``````````');
            console.log(person);
            console.log(person.name);
            console.log('``````torefs对象``````````');
             console.log(toRefs(person));         
        }
     
        console.log(toRefs(person));
         const personame= toRef(person, 'name')

        return {
            getlog,
            ...toRefs(person),
           personame
        }
    }
}
</script>
