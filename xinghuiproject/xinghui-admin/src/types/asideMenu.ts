// 定义菜单项接口
interface MenuItem {
    id: number;
    path: string;
    name: string;
    title: string;
    icon: string;
    children?: MenuItem[]; // 使用 ? 表示 children 是可选的
}

// 定义整个菜单列表的接口
interface MenuList {
    menu: MenuItem[];
}
