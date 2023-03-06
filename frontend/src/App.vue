<template>
<!--    <router-link to="/login">服务提供者/服务消费者</router-link>-->
    <router-view></router-view>
</template>

<script>

import Login from "@/page/Login";

export default {
  name: 'App',
  comments: {
    Login
  },
  methods: {
    provider: function () {}
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
