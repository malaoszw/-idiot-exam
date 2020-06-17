<template>
    <div >
		<!--tabar-->
		<el-container  class="home_container" direction="vertical">
		  
			    <el-menu
			    :default-active="activeIndex"
			    class="el-menu-demo"
			    mode="horizontal"
			    @select="handleSelect"
			    background-color="#545c64"
			    text-color="#fff"
			    default-active="1"
			    active-text-color="#ffd04b" >
			    <el-menu-item index="1">考试</el-menu-item>
			    <el-menu-item index="2">我的成绩</el-menu-item>
			    <el-menu-item index="3">消息中心</el-menu-item>
			    <el-menu-item index="4">个人中心</a></el-menu-item>
				<el-menu-item index="5"  style="float: right; padding: 2px 10px" icon="el-icon-delete" @click="Logout">
				<el-button type="danger" circle></el-button><a style="margin:0 6px;">退出账号</a>
				</el-menu-item>
			    </el-menu>
		  
		  <!--body-->
		  <el-main class="main_box">
			    <div v-show="key=='1'"
				style="display: flex; margin-top: 20px; height: 200px;">
					<transition name="el-fade-in-linear" v-for="(item, index) in ExamList" :key="index" >
					    <div  class="transition-box" @click="gotoExam(index)">
							<h3>{{item.subject}}</h3>
							<p>{{item.description}}</p>
							<td style="float: right; padding: 2px 10px" type="text">{{item.cnTime }}</td>
							</div>
					</transition>
				</div>

				<div v-show="key=='2'" class="mine-box">
					<v-score></v-score>
				</div>
				<div v-show="key=='3'" class="mine-box">
					<v-notice></v-notice>
				</div>
				<div v-show="key=='4'" class="mine-box">
					<v-mine></v-mine>
				</div>
		  </el-main>
		</el-container>	
    </div>
</template>
<script>
	import vMine from '../components/Mine.vue'
	import vScore from '../components/Score.vue'
	import vNotice from '../components/Notice.vue'
    export default {
		components:{
			vMine,
			vScore,
			vNotice
		},
        data() {
            return {
				activeIndex: '1',
				key:'1',
				ExamList:[],//考试科目信息
            };
        },
		created() {
			this.getExam();
			//console.log(this.$route.query.userId)
		},		
        methods: {
			handleSelect(key, keyPath) {
				this.key=key;
			    console.log(key, keyPath);
			},
			Logout(){
				this.$api.get('/student/logout').then((res)=>{
					console.log(res)
					if(res.status=200)
					{
						window.sessionStorage.removeItem("studentId");
						window.sessionStorage.removeItem("token"); 
						this.$router.push({path:'/login'})
						this.$message.success('退出成功');
					}else{
						this.$message.error("退出失败，系统错误")
					}
				})
				

			},
			getExam(){
				this.$api.get('/Exam/findAllExam').then((res)=>{
					console.log(res.data);
					if(res.data.data.length>0)
					{						
						res.data.data.forEach(
						 v => {
							  v.cnTime =this.$moment(v.examDate).format('YYYY-MM-DD ');
						  }
						   );
						this.ExamList=res.data.data;
					}else{
						this.$message.error("没有找到考试信息")
					}
				});
			},
			gotoExam(index){
				this.$router.push({path: '/exam',
				query: {
					examCode: this.ExamList[index].examCode,
					//studentId:sessionStorage.getItem("studentId"),
					pId:this.ExamList[index].paperId
					} });
			}
        },
    }
</script>
<style lang='less' scoped>
.home_container{
	display: flex;
	justify-content: center;
	width:100%;
	height: 900px;

	
}
.main_box{
	display: flex;
	justify-content: start;
	padding: 100px ;
	
}
.transition-box {
    margin-bottom: 10px;
    width: 300px;
    height: 200px;
    border-radius: 15px;
    background-color: #ffffff;
    text-align: center;
    color: #000000;
    box-sizing: border-box;
    margin: 0 60px;
	box-shadow: 30px 30px 60px rgba(0, 0, 0, 0.3),
	-30px -30px 60px rgba(255, 255, 255, 3);
  }
.transition-box h3{
    margin-top: 50px;
} 
.transition-box p{
	font-size: 20px;
	margin-top: 50px;
	justify-content: center;

}
.mine-box{
	justify-content: center;
	width:100%;
	height: 500px;
	
}
</style>