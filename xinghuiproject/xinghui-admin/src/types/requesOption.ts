export interface requestOptionObj { // 注意这里的export关键字
    method: string;
    url: string;
    params?: object;
    mock: boolean
}
