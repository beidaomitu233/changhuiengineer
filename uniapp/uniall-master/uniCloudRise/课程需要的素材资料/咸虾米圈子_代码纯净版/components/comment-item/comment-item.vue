<template>
	<view>
		<view class="comment-item">
			<view class="avatar">
				<u-avatar src="../../static/images/panda.jpg" size="26"></u-avatar>
			</view>

			<view class="wrap">
				<view class="username">王五</view>
				<view class="comment-content">评论的详细内容</view>
				<view class="info">
					<view class="reply-btn">3回复 </view>
					<view>
						<uni-dateformat :date="Date.now() - 35444582" :threshold="[60000,3600000*24*30]">
						</uni-dateformat>
					</view>
					<view>北京市</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		name: "comment-item",
		data() {
			return {

			};
		}
	}
</script>

<style lang="scss" scoped>
	.comment-item {
		display: flex;
				.wrap {
			flex: 1;
			padding-left: 20rpx;
			padding-bottom: 20rpx;

			.username {
				font-size: 26rpx;
				color: #666;
				padding: 10rpx 0;
			}

			.comment-content {
				font-size: 34rpx;
				color: #111;
				line-height: 1.8em;
			}

			.info {
				font-size: 26rpx;
				color: #666;
				display: flex;
				padding: 10rpx 0;
				align-items: center;

				view {
					margin-right: 25rpx;
				}

				.reply-btn {
					padding: 6rpx 18rpx;
					background: #e4e4e4;
					border-radius: 30rpx;
				}
			}
		}
	}
</style>
