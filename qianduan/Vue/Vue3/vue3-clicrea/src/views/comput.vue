<template>
    <div class="about">
        只读计算属性
        {{ count }}
        <h1>可编辑的计算属性</h1>
        {{ computz }}
        <h1>这是计算属性</h1>
    </div>
</template>

<script>

import { computed, ref } from 'vue';

export default {
    name: 'comput',
    setup() {
        const a = ref(5);
        const b = ref(10);

        // 只读计算属性
        const count = computed(() => {
            return a.value * b.value;
        });

        // 带有get和set的计算属性
        const computz = computed({
            get() {
                // 被读取调用
                return a.value + b.value;
            },
            set(newVal) {
                // 被修改调用
                return newVal;
            },
        });

        return {
            count,
            computz,
        };
    },
};



</script>
