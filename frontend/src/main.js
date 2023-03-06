import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import router from './router'//自动扫描里面的路由配置

import * as echarts from 'echarts'

Vue.prototype.$echarts = echarts
Vue.config.productionTip = false

Vue.use(VueRouter);
Vue.use(VueAxios,axios);
Vue.use(ElementUI);

new Vue({
  render: h => h(App),
  //配置路由
  router
}).$mount('#app')
