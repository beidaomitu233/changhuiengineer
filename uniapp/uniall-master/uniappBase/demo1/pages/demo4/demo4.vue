<template>
	<view>
		<myitem></myitem>		
		-------------
		
		<view @click="goback"> 返回上一页 </view>
		
		
		<form @submit="onSubmit">
			<view class="row">
				<input type="text" name="username">
			</view>
			
			<view class="row">
				<textarea name="content"></textarea>
			</view>
			
			<view class="row">
				<radio-group name="gender">
					<radio value="男">男</radio>
					<radio value="女">女</radio>
					<radio value="保密" checked>保密</radio>
				</radio-group>
			</view>
			
			<view class="row">
				<picker :range="options" name="school" :value="selectValue" @change="pickerChange">
					<view>点击选择学历：{{options[selectValue]}}</view>
				</picker>
			</view>
			
			<view>
				<button form-type="submit" type="primary">提交表单</button>
				<button form-type="reset">重置表单</button>
			</view>
			
			{{obj}}
		</form>
	
		<input type="text" v-model="title">
		<view>原标题：{{title}}</view>
		<view>修改后：{{changeTitle}}</view>		
		<view>{{demo}}</view>
		<view>{{fun()}}</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				obj:null,
				options:["高中","大专","本科","博士"],
				selectValue:2,
				title:"",
				text:"优课学院"
			};
		},
		methods:{
			goback(){
				uni.navigateBack()
			},
			onSubmit(e){				
				this.obj=e.detail.value
				this.obj.school=this.options[this.selectValue]
				console.log(this.obj)				
			},
			pickerChange(e){				
				this.selectValue=e.detail.value
			},
			fun(){
				return "vue学习"
			}
		},
		computed:{
			demo(){
				return this.text+"uniapp学习"
			},
			changeTitle(){
				return this.title.toLocaleUpperCase()
			}	
			
		},
		onLoad(e){
			console.log(e);
			
		}
	}
</script>

<style lang="scss">
input,textarea{ border:1px solid #eee;}
.row{ 
	padding:20rpx 0;
}
</style>
