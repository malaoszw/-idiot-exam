import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Exam from '../views/Exam.vue'


Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'index',
    redirect:{name:"Login"}
  },    
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/home',
    name: 'Home',
    component: Home
  },
  {
    path: '/exam',
    name: 'Exam',
    component: Exam
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

//路由拦截导航
router.beforeEach((to,from,next)=>{
	//to 将要访问跳转的路径
	//from 代表从哪个路径跳转而来
	//next 通行函数
	if(to.path === '/login') return next()
	//获取token
	const tokenStr = window.sessionStorage.getItem('token')
	if(!tokenStr) return next('/login')
	next()
})
export default router
