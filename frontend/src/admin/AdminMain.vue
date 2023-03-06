<template>
  <div>
    <el-container class="el-container">
    <el-header>
      <el-menu
          class="el-menu-vertical-demo"
          background-color="#545c64"
          text-color="#fff"
          mode="horizontal"
          active-text-color="#ffd04b">
        <el-menu-item index="1">
          <i class="el-icon-user-solid"></i>
          <router-link to="/adminProfile" class="link">个人信息</router-link>
        </el-menu-item>
        <el-menu-item index="2">
          <i class="el-icon-menu"></i>
          <router-link to="/providerList" class="link">服务提供者</router-link>
        </el-menu-item>
        <el-menu-item index="3">
          <i class="el-icon-document"></i>
          <router-link to="/consumerList" class="link">服务消费者</router-link>
        </el-menu-item>
        <el-menu-item index="4">
          <i class="el-icon-s-cooperation"></i>
          <router-link to="/serviceList" class="link">服务</router-link>
        </el-menu-item>
        <el-menu-item index="5">
          <i class="el-icon-edit"></i>
          <span slot="title" @click="update">更新ES索引</span>
        </el-menu-item>
        <el-menu-item index="6">
          <i class="el-icon-circle-close"></i>
          <router-link to="/login">退出登录</router-link>
        </el-menu-item>
      </el-menu>
    </el-header>

    <el-main style="text-align: center">
      <router-view></router-view>
    </el-main>
    </el-container>
  </div>
</template>

<script>
import axios from "_axios@0.21.1@axios";

export default {
  props: ['name'],
  name: "AdminMain",
  methods: {
    update() {
      axios.get('http://localhost:8081/es/updateDocumentFromDB').then(
          response => {
            //console.log(response.data.message);
            alert(response.data.message);
          }
      )
    }
  }
}
</script>

<style scoped lang="scss">

a {
  text-decoration: none;
}

.router-link-active {
  text-decoration: none;
}

.el-menu-vertical-demo {
  height: max-content;
}

.link {
  color: ghostwhite;
}
</style>