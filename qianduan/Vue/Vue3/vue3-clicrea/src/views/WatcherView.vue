<template>
  <div>
    这是数据1
    {{ person.name }}
    {{age}}

    <button @click="age+=1">加一岁</button>
  </div>
</template>


<script>
import { reactive, ref, watch, watchEffect } from 'vue'
//导入钩子
import usepoint from '../hooks/usepoint.js'
export default {
  name: 'WatcherView',

  setup () {
    let a = ref(5)
    let age = ref(20)
    let person = reactive({
      name: 'lisi',

    })

    watch(age, ((newvalue, oldvalue) => {
      console.log(newvalue, oldvalue);
    }))

    watch(person, (newvalue, oldvalue) => {
      console.log(newvalue, oldvalue);
    })

    watchEffect(() => {
      const x1 = age.value
      const n2 = person.name
      console.log('检测的数据发生了变化，马上就会调用后续的代码');

      //调用Hook
      let localtion = usepoint()
      console.log(localtion);
    })

    return {
      person,
      age
    }
  }

}



</script>

