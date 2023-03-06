import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from "@/page/Login";
import Register from "@/page/Register";
import Echarts from "@/components/Echarts";

import Info from "@/page/Info";
import Main from "@/page/Main";
import Upload from "@/page/Upload";
import Use from "@/page/Use";
import Index from "@/page/Index";
import Brief from "@/page/Brief";
import Search from "@/page/Search";
import SearchConsumer from "@/page/SearchConsumer";
import Profile from "@/page/Profile";
import ProfileConsumer from "@/page/ProfileConsumer";

import AdminMain from "@/admin/AdminMain";
import AdminProfile from "@/admin/AdminProfile";
import ServiceList from "@/admin/ServiceList";
import ConsumerList from "@/admin/ConsumerList";
import ProviderList from "@/admin/ProviderList";

import NotFound from "@/components/NotFound";

//安装路由
Vue.use(VueRouter);

//配置导出路由
export default new VueRouter({
    routes: [
        {
            props: true,
            path: '/main/:name',
            name: 'main',
            component: Main,
            children: [
                {
                    path: '/info',
                    name: 'info',
                    component: Info
                },
                {
                    path: '/index',
                    name: 'index',
                    component: Index
                },
                {
                    path: '/brief',
                    name: 'brief',
                    component: Brief
                },
                {
                    path: '/search',
                    name: 'search',
                    component: Search
                },
                {
                    path: '/searchConsumer',
                    name: 'searchConsumer',
                    component: SearchConsumer
                },
                {
                    path: '/profile',
                    name: 'profile',
                    component: Profile
                },
                {
                    path: '/profileConsumer',
                    name: 'profileConsumer',
                    component: ProfileConsumer
                },
                {
                    path: '/upload',
                    name: 'upload',
                    component: Upload
                },
                {
                    path: '/use',
                    name: 'use',
                    component: Use
                }
            ]
        },
        {
            path: '/login',
            name: 'login',
            component: Login
        },
        {
            path: '/register',
            name: 'register',
            component: Register
        },
        {
            path: '/adminMain/:name',
            name: 'adminMain',
            //一：AdminMain里传参数 二：这里props: true path: '/adminMain/:name'
            //三：AdminMain里 export里 props: ['name'],四：{{}}使用
            props: true,
            component: AdminMain,
            children: [
                {
                    path: '/adminProfile',
                    name: 'adminProfile',
                    component: AdminProfile
                },
                {
                    path: '/serviceList',
                    name: 'serviceList',
                    component: ServiceList
                },
                {
                    path: '/consumerList',
                    name: 'consumerList',
                    component: ConsumerList
                },
                {
                    path: '/providerList',
                    name: 'providerList',
                    component: ProviderList
                }
            ]
        },
        {
            //重定向
            path: '/adminHome',
            redirect: '/adminMain'
        },
        {
            path: '*',
            component: NotFound
        },
        {
            path:'/',
            name:'homePage',
            redirect: '/login'
        },
        {
            path: '/echarts',
            name: 'echarts',
            component: Echarts
        }
    ]
});
