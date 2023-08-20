<template>
    <div class="home">
        <button @click="generateText">测试测试</button>
        <input type="text" v-model="prompt" placeholder="输入提示词">
        <!-- 将返回的内容呈现在文本域中 -->
        <textarea v-model="generatedText" cols="30" rows="10"></textarea>
    </div>
</template>

<script>
// @ is an alias to /src
import { ref, reactive,  } from 'vue'
import {api_key} from '../../config'
import { Configuration, OpenAIApi } from "openai";
import axios from 'axios'


export default {
    name: 'Chat',
    setup(){
    
    const prompt = ref('');
    const generatedText = ref('')
        const url = '/a';
        const headers = {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${api_key}`,
        };
        const generateText = async () => {
             const data = reactive({
                model: 'gpt-3.5-turbo',
                messages: [
                    { role: 'system', content: 'You are a helpful assistant.' },
                    { role: 'user', content: prompt.value } // 确保 prompt.value 是有效的字符串
                ],
            });
            try {
                console.log('req');
                console.log(prompt.value);
                const response = await axios.post(url, data, { headers });
                const result = response.data;
                if (result.choices && result.choices.length > 0) {
                    console.log(result.choices[0].message);
                    generatedText.value = result.choices[0].message.content; // 更新生成的文本
                } else {
                    generatedText.value = 'Error generating text';
                }
            } catch (error) {
                console.error('Error:', error);
                generatedText.value = 'Error generating text';
            }

    }
        return { generateText, prompt, generatedText }
    }
}
</script>
