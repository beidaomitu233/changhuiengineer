<script>
	import {
		mapActions,
		mapMutations
	} from 'vuex'
	import config from '@/admin.config.js'
	import {
		version
	} from './package.json'
	import { UNI_ADMIN_THEME, UNI_ID_TOKEN_EXPIRED } from './store/constants.js'
	export default {
		created() {
			this.clear = undefined
		},
		methods: {
			...mapMutations('app',['SET_THEME']),
			...mapActions({
				init: 'app/init'
			}),
			clearPlatform() {
				const keysOfPlatform = uni.getStorageInfoSync().keys.filter(key => key.indexOf('platform') > -1)
				keysOfPlatform.length && keysOfPlatform.forEach(key => uni.removeStorageSync(key))
			}
		},
		onPageNotFound(msg) {
			uni.redirectTo({
				url: config.error.url
			})
		},
		onLaunch: function() {
			// #ifdef H5
			console.log(
				`%c uni-admin %c v${version} `,
				'background:#35495e ; padding: 1px; border-radius: 3px 0 0 3px;  color: #fff',
				'background:#007aff ;padding: 1px; border-radius: 0 3px 3px 0;  color: #fff; font-weight: bold;'
			)
			// #endif
			// #ifdef H5
			// 此处为强制用户必须登录才能访问其他页面，如果需要部分页面不登录也能访问，需要在此过滤这些页面不执行下面的代码或直接注释掉此代码
			// let uni_id_token_expired = uni.getStorageSync(UNI_ID_TOKEN_EXPIRED);
			// if (!uni_id_token_expired || uni_id_token_expired < Date.now()) {
			// 	uni.reLaunch({
			// 		url: config.login.url
			// 	})
			// }
			// #endif
			// 线上示例使用
			// console.log('%c uni-app官方团队诚邀优秀前端工程师加盟，一起打造更卓越的uni-app & uniCloud，欢迎投递简历到 hr2013@dcloud.io', 'color: red');
			console.log('App Launch')
			if (this.$uniIdPagesStore.store.hasLogin) {
				this.init()
			}

			// 登录成功回调
			uni.$on('uni-id-pages-login-success', () => {
				this.init()
			})

			// theme
			this.SET_THEME(uni.getStorageSync(UNI_ADMIN_THEME) || 'default')
		},
		onShow: function() {
			console.log('App Show')
			this.clear = setInterval(() => this.clearPlatform(), 15*60*1000)
		},
		onHide: function() {
			console.log('App Hide')
			this.clear && clearInterval(this.clear)
		}
	}
</script>

<style lang="scss">
	@import '@/common/uni.css';
	@import '@/common/uni-icons.css';
	@import '@/common/admin-icons.css';
	@import '@/common/theme.scss';
	@import '@/static/fonts/iconfont.css';
</style>
