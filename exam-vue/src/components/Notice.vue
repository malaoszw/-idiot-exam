<template>
	<div class="demo-fit">
		<el-card class="box-card">
			<div slot="header" class="clearfix">
                <span>考试通知</span>
				<el-button style="float: right; padding: 3px 0" type="text">点击查看</el-button>
			</div>
			<div class="text item">下周进行xxx考试</div>
            <div class="text item" style="float: right; padding: 3px 0">发布时间：2020-6-12</div>
		</el-card>
		<el-card class="box-card" style="margin-top: 10px;">
			<div slot="header" class="clearfix">
                <span>紧急通告通知</span>
				<el-button style="float: right; padding: 3px 0" type="text">点击查看</el-button>
			</div>
			<div class="text item">如果分数长期处于0分，且其他同学不为0分，请咨询热线1008611</div>
            <div class="text item" style="float: right; padding: 3px 0">发布时间：2020-6-14</div>
		</el-card>		
	</div>
</template>
<script>
export default {
	data() {
		return {
			url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
		};
	}
};
</script>

<style>
.text {
	font-size: 14px;
}

.item {
	margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
	display: table;
	content: '';
}
.clearfix:after {
	clear: both;
}

.box-card {
	width: 100%;
}
</style>
