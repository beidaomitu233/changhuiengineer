// /src/types/housingNum.ts

export interface HouseCard { // 注意这里的export关键字
    id: number;
    title: string;
    number: number;
    cardColor: string;
}

// 定义整个菜单列表的接口
export interface HouseCardList {
    houseCards: HouseCard[];
}