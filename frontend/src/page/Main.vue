<template>
  <div id="main">
    <el-container class="el-container">
      <el-header class="el-header">
        <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#3554f8"
            text-color="#fff"
            active-text-color="#ffd04b">
          <el-menu-item index="1">
            <router-link to="/index">首页</router-link>
          </el-menu-item>
          <el-menu-item index="2">
            <router-link to="/brief">服务列表</router-link>
          </el-menu-item>
          <el-menu-item v-if="this.identity==='服务消费者'" index="3">
            <router-link to="/searchConsumer">服务搜索</router-link>
          </el-menu-item>
          <el-menu-item v-if="this.identity==='服务提供者'" index="4">
            <router-link to="/search">服务搜索</router-link>
          </el-menu-item>
          <el-menu-item v-if="this.identity==='服务消费者'" index="5">
            <router-link to="/use">服务调用</router-link>
          </el-menu-item>
          <el-menu-item v-if="this.identity==='服务提供者'" index="6">
            <router-link to="/upload">服务上传</router-link>
          </el-menu-item>
          <el-menu-item v-if="this.identity==='服务提供者'" index="7">
            <router-link to="/profile">个人主页</router-link>
          </el-menu-item>
          <el-menu-item v-if="this.identity==='服务消费者'" index="8">
            <router-link to="/profileConsumer">个人主页</router-link>
          </el-menu-item>
          <el-menu-item index="9">
            <router-link to="/info">关于我们</router-link>
          </el-menu-item>
          <!--          <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>-->
          <!--          <el-menu-item index="3" disabled>消息中心</el-menu-item>-->
        </el-menu>
      </el-header>
      <el-main style="text-align: center" class="el-main">
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import Common from "@/components/Common";

export default {
  data() {
    return {
      userName: Common.userName,
      identity: Common.identity,
      id: Common.id,
      activeIndex: '1',
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  },
  props: ['name'],
  name: "Main"
}
</script>

<style scoped>
a {
  text-decoration: none;
}

.router-link-active {
  text-decoration: none;
}

.el-header {
  margin: 0;
  padding: 0;
  width: 100%;
  position: relative;
}

.el-main {
  margin: 0;
  padding: 0;
  width: 100%;
  position: relative;
}

.el-container {
  margin: 0;
  padding: 0;
  width: 100%;
  position: relative;
}
</style>