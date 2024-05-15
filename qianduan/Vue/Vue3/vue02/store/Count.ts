// 引入defineStore用于创建store
import {defineStore} from 'pinia'


export  const  useCountStore = defineStore('count',{

    actions:{},
    state() {

        return{
            PhoneNumber:1 as number
        }
    },
    getters:{
        countTenTime:(state)=>state.PhoneNumber*10

    }

})

