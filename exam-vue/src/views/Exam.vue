<template>
	<div class="exam_container">
		<el-form ref="form" :model="form" label-width="80px">

			<el-form-item label="" style="margin: 10px; " type="flex" v-for="(item, index) in questionList" :key="index">
				<div class="sign_btn">
					<el-button v-if="item.isSign"  size="mini" type="danger"  circle @click="clickSign(index)"></el-button>				
					<el-button v-else  size="mini"  circle @click="clickSign(index)"></el-button>
				</div>
				
				<el-card >
				<div>
					<label style="font-size: 16px;">{{ index + 1 }}. {{ item.question }}</label>
				</div>
				<div>
					<el-radio-group v-model="radio[index]" @change="getValue(index)" justify="start">
						<el-radio label="A">A. {{ item.answerA }}</el-radio>
						<el-radio label="B">B. {{ item.answerB }}</el-radio>
						<el-radio label="C">C. {{ item.answerC }}</el-radio>
						<el-radio label="D">D. {{ item.answerD }}</el-radio>
					</el-radio-group>
				</div>
			</el-card>
			</el-form-item>
			<el-form-item style="margin: 50px 150px;">
				<div class="btn_box">
					<el-button type="primary"  @click="onSubmit">提交试卷</el-button>
					<el-button >重置答案</el-button>
				</div>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
export default {
	data() {
		return {
			form: {
				type: [],
				resource: ''
			},
			radio: [],
			questionList: [],
			jsonArr: [],
			count:'',
		};
	},
	created() {
		//console.log(this.$route.query.userId)
		//console.log(this.$route.query.examCode)
		this.getQuestion();
	},
	methods: {
		onSubmit() {
			//console.log('submit!');
			this.jsonArr = [];
			for (var i = 0; i < this.questionList.length; i++) {
				this.jsonArr.push({
					questionId: this.questionList[i].questionId,
					userAnswer: this.radio[i],
					examCode: this.$route.query.examCode,
					studentId: window.sessionStorage.getItem("studentId"),
					score: this.questionList[i].score
				});
			}
			console.log(this.radio.length);
			console.log(this.jsonArr);
			//console.log(this.jsonArr)
			this.$api.post('/Answer/add', this.jsonArr).then(res => {
				console.log(res);
				if (res.data.code == 200) {
					this.$router.push({ path: '/home' });
					this.$message.success('提交成功,请你吃鸡蛋');
				} else {
					//this.$router.push({path:'/home'});
					this.threeGo();
					this.$message.error('请勿重复提交，3秒后回到主页');
				}
			});
		},
		clickSign(index){
			this.questionList[index].isSign=!this.questionList[index].isSign;
		},
		getQuestion() {
			this.$api.get('/Questions/' + this.$route.query.pId).then(res => {
				console.log(res.data.singleChoice);
				res.data.singleChoice.forEach(
						 v => {
							  v.isSign =false;
						  }
						   );
				this.questionList = res.data.singleChoice;
				//console.log(this.questionList)
			});
		},
		getValue(index) {
			//var tip=index+1;
			//console.log("第 "+tip+"题"+this.radio[index]); // 打印的值，就是被选中的radio的值
			//this.radio[index].id=this.questionList[index].questionId;
			console.log(this.radio);
			//var status  = document.getElementsByName("status")[0];
		},
		threeGo() {
		const TIME_COUNT = 3;
		    if(!this.timer){
		      this.count = TIME_COUNT;
		      this.show = false;
		      this.timer = setInterval(()=>{
		        if(this.count > 0 && this.count <= TIME_COUNT){
		          this.count--;
		        }else{
		          this.show = true;
		          clearInterval(this.timer);
		          this.timer = null;
		          //跳转的页面
				  this.$router.push({ path: '/home' });		
		        }
		      },1000)
		    }

		}
	}
};
</script>
<style>
.exam_container{
	display: flex;
	justify-content: center;
    align-items: center;
	width: 80%;
	margin: 50px 50px;

	
}	
.btn_box{
	display: flex;
	align-items: center; 
	justify-content: space-between;
}

.sign_btn{
    position:absolute;
    left:-50px;
    top:35px;
}	


</style>
