<template>
  <div class="container">
    <div class="glass-box">
      <h2>Configuration Options</h2>
      <form class="options-form">
        <div class="option-container">
          <label for="inputDir">Input Directory:</label>
          <input type="text" v-model="inputDir" id="inputDir" />
        </div>
        <div class="option-container">
          <label for="outputDir">Output Directory:</label>
          <input type="text" v-model="outputDir" id="outputDir" />
        </div>
        <div class="option-container">
          <label for="tempDir">Temporary Directory:</label>
          <input type="text" v-model="tempDir" id="tempDir" />
        </div>
        <div class="option-container">
          <label for="audioSource">Audio Source:</label>
          <select v-model="audioSource" id="audioSource">
            <option value="video1">Video 1</option>
            <option value="video2">Video 2</option>
            <option value="external">External</option>
          </select>
        </div>
        <button type="button" @click="submitConfig"
                class="rounded-button">Submit</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data () {
    return {
      inputDir: '',
      outputDir: '',
      tempDir: '',
      audioSource: 'video1'
    };
  },
  methods: {
    async submitConfig () {
      try {
        await axios.post('http://127.0.0.1:6679/process_videos', {
          input_dir: this.inputDir,
          output_dir: this.outputDir,
          temp_dir: this.tempDir,
          audio_source: this.audioSource
        });
        alert('Configuration submitted successfully!');
      } catch (error) {
        console.error('Error submitting configuration:', error);
        alert('Error submitting configuration. Please try again later.');
      }
    }
  }
};
</script>

<style>
body {
  background-image: linear-gradient(to top, #fad0c4 0%, #ffd1ff 100%);
}
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
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
  border-bottom: 1px solid #ccc;
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
</style>