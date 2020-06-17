<template>
	<div class="login_container">
		<el-card class="box-card login_box">
			<el-form :model="loginForm" :rules="rules" ref="loginForm" label-width="80px">
				<!--用户名-->
				<el-form-item label="用户名" prop="username" class="login_input"><el-input type="text" v-model="loginForm.username" maxlength="12"></el-input></el-form-item>
				<!--密码-->
				<el-form-item label="密码" class="login_input" prop="password"><el-input v-model="loginForm.password" type="password"></el-input></el-form-item>
				<!--按钮开始-->
				<el-form-item class="btn_box">
					<div class="btn"><div class="btn_text" @click="login('loginForm')">登录</div></div>
					<div class="btn"><div class="btn_text" @click="resetForm()">重置</div></div>
				</el-form-item>

				<!--按钮结束-->
			</el-form>
		</el-card>
	</div>
</template>
<script>
export default {
	name: 'Login',
	data() {
		var validatePass = (rule, value, callback) => {
			if (value === '') {
				callback(new Error('请输入密码'));
			} else {
				callback();
			}
		};
		return {
			loginForm: {
				username: '张三',
				password: '123'
			},
			rules: {
				//规则
				username: [{ required: true, message: '用户名不能为空', trigger: 'blur' }, { min: 1, max: 10, message: '长度在 3 到 5 个字符' }],
				password: [{ validator: validatePass, trigger: 'blur' }]
			}
		};
	},
	methods: {
		onSubmit() {
			console.log('submit!');
		},
		resetForm() {
			this.$refs.loginForm.resetFields();
		},
		login(formName) {
			this.$refs[formName].validate(valid => {
				if (valid) {
					this.$api
						.post(
							'/student/login',this.loginForm,
							{
								emulateJSON: true
							}
						)
						.then(res => {
							/*const token=res.headers['authorization'];
							//_this.$store.commit('SET_TOKEN',token);
							//_this.$store.commit('SET_USREINFO',res.data.data);
							//_this.$router.push("/Home");
							console.log(res);
							window.sessionStorage.setItem("token",res.headers['authorization']);
							*/
							console.log(res.data);
							//console.log(res.data.code);
							if (res.data.code == 200) {
								this.$message.success('登录成功');
								//console.log(res.data.data.id)
								window.sessionStorage.setItem("studentId", res.data.data.studentId);
								const token = res.headers['authorization'];
								window.sessionStorage.setItem("token", token);
								this.$router.push({
									path: '/home'/*,
									query: {
										studentId: res.data.data.id
								}*/
								});
							} else {
								this.$message.error('用户不存在');
							}
						});
					//this.$router.push("/Home");
					//this.$message.success("登录成功")
				} else {
					this.$message.error('登录失败');
					console.log('提交失败');
					return false;
				}
			});
		}
	}
};
</script>
<style lang="less" scoped>
.login_container {
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: #efeeee;
	height: 100%;
}
.login_box {
	background-color: #fff;
	border-radius: 20px;
	padding: 10px;
	width: 450px;
}
.login_input {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-left: -20px;
}
.btn_box {
	display: flex;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-left: -80px;
}
.btn {
	width: 50px;
	height: 70px;
	margin: 20px 50px -200px;
	display: inline-block;
}
.btn .btn_text {
	width: 50px;
	height: 50px;
	box-shadow: 18px 18px 30px rgba(0, 0, 0, 0.1), -18px -18px 30px rgba(255, 255, 255, 1);
	border-radius: 10px;
	display: flex;
	align-items: center;
	justify-content: center;
	background-color: #efeeee;
	transition: box-shadow 0.2s ease-out;
	position: relative;
}

.btn .btn_text:hover {
	box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.2), 0px 0px 0px rgba(255, 255, 255, 0.8), inset 18px 18px 30px rgba(0, 0, 0, 0.1), inset -18px -18px 30px rgba(255, 255, 255, 1);
	transition: box-shadow 0.2s ease-out;
}
</style>
