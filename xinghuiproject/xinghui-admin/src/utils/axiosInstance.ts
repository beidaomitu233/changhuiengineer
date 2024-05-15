import axios, { AxiosResponse } from 'axios';

/* 错误提示，可以从后端获取，本地也存储一些最基本的错误。 */
import { ElMessage } from 'element-plus';
const NETWORK_ERROR = '网络请求异常，请稍后再尝试。'

/* 定义参数类型 */
import { requestOptionObj } from '../types/requesOption';

/* 引入环境变量 */

export const instance = axios.create({
    baseURL: process.env.VITE_API_BASE_URL || '', // 获取变量中的URL
    timeout: 10000, // 请求超时时间
    headers: { 'Content-Type': 'application/json' }, // 默认请求头
});

/* 请求拦截 */
instance.interceptors.request.use(config => {
    /*
     可以自定义header
     jwt-token认证的时候 
*/
    return config;
}, error => {
    // 对请求错误做些什么
    return Promise.reject(error);
});

/* 接收拦截 */
instance.interceptors.response.use(response => {
    // 直接将数据结构出来后返回，后面就不需要重复结构
    const { code, data, msg } = response.data
    if (code == 200) {
        return data
    } else {
        /* 如果后端返回错误数据，就是用后端的，没有就是用本地基本报错 */
        ElMessage.error(msg || NETWORK_ERROR);
        /* 一般返回的都是promis格式，所以需要用promise来reject */
        return Promise.reject(msg || NETWORK_ERROR)
    }

}, error => {
    // 处理响应错误
    return Promise.reject(error);
});



/* 封装核心函数 */

/* requestOption以对象格式传参，对象里包含，
@url：请求路径
@method：请求方法
@params：参数列表
*/
export async function request<T>(options: requestOptionObj): Promise<T> {
    /* 默认设置get请求 */
    options.method = options.method || 'get'
    //有一些人会写GET,所以需要转换一下。
    if (options.method.toLocaleLowerCase() == 'get') {
        options.method
    }
    /* 对mock进行严格控制,十个接口中总开关是开启或关闭时，可以设置一个mock接口为true进行开启。。 */
    /*     let isMock=config.mock
        if(typeof options.mock !=='undefined'){
            isMock=options.mock
        } */
    /* 为了防止在生产环境中使用到mock数据。 */
    if (process.env.mode == 'prod') {
        /* 直接将请求地址，设置为线上API地址 */
        instance.defaults.baseURL = process.env.VITE_API_BASE_URL
    } else {
        /* 设置为mock */
        instance.defaults.baseURL = process.env.VITE_API_BASE_URL
    }

    try {
        const response = await instance(options);

        return response as T;
    } catch (error) {
        throw error;
    }

}

