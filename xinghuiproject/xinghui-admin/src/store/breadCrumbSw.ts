// store/breadcrumb.js
import { defineStore } from 'pinia';

export const useBreadcrumbStore = defineStore('breadcrumb', {
    state: () => ({
        items: [
            { label: '首页', to: { path: '/' } },
            // 这里可以是动态添加的更多项
        ],
    }),
    actions: {
        addBreadcrumb(label, to) {
            this.items.push({ label, to });
        },
        clearBreadcrumbs() {
            this.items = [{ label: '首页', to: { path: '/' } }];
        },
    },
    // 计算
    getters: {}
});