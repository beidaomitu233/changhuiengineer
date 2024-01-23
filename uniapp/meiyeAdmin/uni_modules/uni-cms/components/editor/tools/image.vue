<template>
	<view>
		<slot :change="change">
			<toolbarTool type="button" @change="change" :active="active" :disabled="disabled" :tooltip="{content: '插入图片'}">
				<uni-icons custom-prefix="editor-icon" type="icon-image" size="22px" style="padding: 1px;"></uni-icons>
			</toolbarTool>
		</slot>
    <uni-drawer
        class="insert-image-drawer"
        v-if="drawerWidth"
        ref="insertImageDrawer"
        mode="right"
        :width="drawerWidth"
    >
      <uni-media-library
          mode="picker"
          :selected-count="1"
          :media-tabs="['image']"
          @onInsert="onInsert"
      ></uni-media-library>
    </uni-drawer>
	</view>
</template>

<script>
import ToolbarTool from "./base.vue";

export default {
	name: "tool-image",
	emits: ['change'],
	props: {
		active: Boolean,
    disabled: Boolean
	},
	components: {
		ToolbarTool
	},
  data () {
    return {
      drawerWidth: null
    }
  },
  mounted () {
    const sysinfo = uni.getSystemInfoSync()
    this.drawerWidth = sysinfo.windowWidth * .8
  },
	methods: {
		change() {
      this.$refs.insertImageDrawer.open()
		},
    onInsert (selectedMediaList) {
      this.$refs.insertImageDrawer.close()

      this.$emit('change', {
        type: 'image',
        value: {
          src: selectedMediaList[0].src,
          alt: selectedMediaList[0].alt,
          data: {
            source: selectedMediaList[0].src
          }
        }
      })
    }
	}
}
</script>

<style scoped>
// #ifdef H5
@import '@/uni_modules/uni-cms/common/style/editor-icon.css';
// #endif
</style>
