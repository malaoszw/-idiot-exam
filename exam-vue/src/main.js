import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Element from 'element-ui'
import axios from 'axios'
import moment from 'moment';
moment.locale('zh-cn');

import './plugins/element.js'
import "element-ui/lib/theme-chalk/index.css"
import './assets/css/global.css'//全局样式


Vue.use(Element)
Vue.prototype.$moment = moment
Vue.config.productionTip = false
Vue.prototype.$api = axios //
axios.defaults.baseURL="http://localhost:8081"

new Vue({
  router,
  store,
  axios,
  render: h => h(App)
}).$mount('#app')
