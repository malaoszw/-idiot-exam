<template>
	<div class="demo-fit">

		<el-card class="box-card">
			<div slot="header" class="clearfix">
				<div class="block">
					<el-avatar shape="square" :size="100" fit="fill" :src="userList.avatar"></el-avatar>
				</div>
				<el-button style="float: right; padding: 3px 0" type="text">修改个人信息</el-button>
			</div>
			<div class="text item">用户名: {{userList.username}}</div>
			<div class="text item">电话: {{userList.phone}}</div>
			<div class="text item">email: {{userList.email}}</div>
		</el-card>
	</div>
</template>
<script>
export default {
	data() {
		return {
			userList:[]
		};
	},
	created() {
		this.getUser();
	},
	methods:{
		getUser(){
			this.$api   //this.$route.query.studentId
				.get('/Student/'+window.sessionStorage.getItem("studentId")).then((res) => {
					console.log(res.data);
					this.userList=res.data.data;
					
				});
		}
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
	width: 480px;
}
</style>
