
import { request } from '@/utils/axiosInstance'

/* 返回数据格式： */
import { HouseCardList } from '../types/housingNum';
import { get } from 'node_modules/axios/index.d.cts';

export default {
    /* 获取home组件菜单数据 */
    getHousingList(params: object) {
        return request<HouseCardList>({
            url: '/homeStatus',
            method: 'get',
            params: params,
            mock: true
        })

    },

    getMenuList(params: object) {
        return request<HouseCardList>({
            url: '/menu',
            method: 'get',
            params: params,
            mock: true
        })
    }

}