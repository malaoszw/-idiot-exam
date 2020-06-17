<template>
	<div>
		<el-card class="box-card">
		<el-table :data="tableData" style="width: 100%" :row-class-name="tableRowClassName">
			<div v-for="(item,index) in tableData" :key="index">
				<el-table-column prop="date" label="日期" width="180">{{item.cnTime}}</el-table-column>
				<el-table-column prop="subject" label="科目" width="180">{{item.subject}}</el-table-column>
				<el-table-column prop="examType" label="考试类型">期末考试</el-table-column>
				<el-table-column prop="score" label="分数">{{item.totalScore}}</el-table-column>
			</div>
		</el-table>
		</el-card>
	</div>

</template>

<script>
export default {
	data() {
		return {
			/*tableData: [{
          date: '2020-06-02',
          subject: '形式与政策',
          examType: '2020第二学期期末考试',
		  score:'90'
        }, {
          date: '2020-06-04',
          subject: '高数',
          examType: '2020第二学期期末考试',
		  score:'99'
        }, {
          date: '2020-03-01',
          subject: '高数',
          examType: '2020第二学期期中考试',
		  score:'93'
        }, {
          date: '2020-03-03',
          subject: '形式与政策',
          examType: '2020第二学期期中考试',
		  score:'92'
        }]*/
			tableData: []
		};
	},
	created() {
		this.getScore();
		
	},
	methods: {
		tableRowClassName({ row, rowIndex }) {
			if (rowIndex === 1) {
				return 'warning-row';
			} else if (rowIndex === 2) {
				return 'success-row';
			}
			return '';
		},
		getScore() {
			this.$api   //this.$route.query.studentId
				.get('/Score/'+window.sessionStorage.getItem("studentId")).then((res) => {
					console.log(res.data.data);
					res.data.data.forEach(
					 v => {
						  v.cnTime =this.$moment(v.answerDate).format('YYYY-MM-DD ');
					  }
					   );
					this.tableData = res.data.data;
				});
		}
	}
};
</script>

<style>
.el-table .warning-row {
	background: oldlace;
}

.el-table .success-row {
	background: #f0f9eb;
}
</style>
