
<template>
  <div class="container">
    <div class="glass-box">
      <h2>视频合成配置</h2>
      <form class="options-form" @submit.prevent="submitForm">
        <div class="option-container">
          <label for="inputDir">源视频目录</label>
          <input type="text" v-model="form.inputDir" id="inputDir"
                 required />
        </div>
        <div class="option-container">
          <label for="outputDir">合成视频输出目录</label>
          <input type="text" v-model="form.outputDir" id="outputDir"
                 required />
        </div>
        <div class="option-container">
          <label for="tempDir">临时存储目录</label>
          <input type="text" v-model="form.tempDir" id="tempDir"
                 required />
        </div>
        <div class="option-container">
          <label for="audioSource">合成视频声音选择</label>
          <select v-model="form.audioSource" id="audioSource">
            <option value="video1">第一个视频</option>
            <option value="video2">第二个视频</option>
          </select>
        </div>
        <button type="submit" :disabled="req" class="rounded-button"
                :class="req==true? 'rounded-button-disable':'' ">合成</button>
      </form>
    </div>
  </div>
</template>

<script>
import { reactive, ref } from 'vue';
import axios from 'axios';

export default {
  name: "Form",
  setup () {
    const form = reactive({
      inputDir: '',
      outputDir: '',
      tempDir: '',
      audioSource: 'video1'
    });

    const req = ref(false);


    const submitForm = async () => {
      // 简单地检查每个必填字段是否为空
      if (!form.inputDir || !form.outputDir || !form.tempDir) {
        alert('请确保所有必填项已填写');
        return;
      }

      try {
        // 发送POST请求到服务器
        req.value = true
        const response = await axios.post('http://localhost:6679/processvideos', form)
        alert("视频正在处理中")
        if (response.status === 400 && response.data.error === "输出文件已存在。是否覆盖？") {
          // 弹出覆盖提示
          if (confirm("输出文件已存在。是否覆盖？")) {
            // 发送覆盖请求
            const overwriteData = { ...form, overwrite: true };
            const overwriteResponse = await axios.post('http://localhost:6679/processvideos', overwriteData);
            if (overwriteResponse.data.error) {
              alert(overwriteResponse.data.error);
            } else {
              alert(overwriteResponse.data.message);
              // 成功提交后的处理
            }
          } else {
            // 用户选择不覆盖，停止操作
            alert("操作已停止，未覆盖文件。");
          }
        } else {
          // 处理成功的消息
          req.value = false
          alert(response.data.message);
        }
      } catch (error) {
        req.value = false
        console.error('Error submitting configuration:', error);
        alert('请求失败');
      }
    };


    return {
      form,
      submitForm,
      req
    };
  }
};
</script>





<style>
.error {
  border-color: red;
}
.error-message {
  color: red;
}
.error-message {
  color: red;
}

body {
  background-image: linear-gradient(to top, #fad0c4 0%, #ffd1ff 100%);
  color: black;
}
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 50vh;
  width: 400px;
}

.glass-box {
  background-color: rgba(255, 255, 255, 0.5);
  border-radius: 10px;
  padding: 20px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
  width: 720px;
  height: auto;
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.options-form {
  display: flex;
  flex-direction: column;
  border-bottom: 1px solid #ccc;
  padding-bottom: 10px;
}

.option-container {
  display: flex;
  flex-direction: row;
  align-items: center;
  gap: 10px;
  width: 100%;
  padding-top: 20px;
  border-bottom: 1px solid #ccc;
  justify-content: space-between;
}

.option-container:last-child {
  border-bottom: none;
}

.option label {
  width: 150px;
}

.option input,
.option select {
  flex-grow: 1;
  max-width: 300px;
  border: none;
  border-radius: 4px;
  padding: 8px;
}

.rounded-button {
  align-self: center;
  width: 50%;
  cursor: pointer;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 10px;
  padding: 10px 20px;
  font-size: 16px;
  margin-top: 10px;
  text-align: center;
}
.rounded-button-disable {
  background-color: #04203e;
  color: darkgray;
}
</style>