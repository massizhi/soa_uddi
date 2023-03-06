<template>
  <div class="div1">
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <el-card class="box-card" shadow="always">
      <el-form ref="loginForm" :model="form" :rules="rules" label-width="60px" class="login-box">
        <h3 class="login-title" align="center">用户登录</h3>
        <el-form-item label="账号" prop="username">
          <el-input type="text" placeholder="请输入账号" v-model="form.username"/>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" placeholder="请输入密码" v-model="form.password"/>
        </el-form-item>
        <el-form-item>
          <el-radio v-model="radio" label="mainProvider">服务提供者</el-radio>
          <el-radio v-model="radio" label="mainConsumer">服务消费者</el-radio>
          <el-radio v-model="radio" label="adminMain">管理员</el-radio>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="onSubmit('loginForm')">登录</el-button>
          <el-button @click="resetForm('loginForm')">重置</el-button>
          <el-button type="primary" plain @click="toRegister">注册账号</el-button>
        </el-form-item>
      </el-form>
    </el-card>
    <pre>   </pre>
    <pre>   </pre>
    <pre>   </pre>
    <pre>   </pre>
    <pre>   </pre>
    <pre>   </pre>
    <pre>   </pre>
    <pre>   </pre>
  </div>
</template>

<script>
import axios from "axios";
import Common from "@/components/Common";

export default {
  name: "Login",
  data() {
    return {
      radio: '1',
      success: '',
      form: {
        username: '',
        password: ''
      },
      //表单验证，需要再el-form-item 元素中增加prop属性
      rules: {
        username: [
          {
            required: true, message: '账号不能为空', trigger: 'blur'
          }
        ],
        password: [
          {
            required: true, message: '密码不能为空', trigger: 'blur'
          }
        ]
      }
    }
  },
  methods: {
    onSubmit(formName) {
      //为表单绑定验证功能
      this.$refs[formName].validate((valid) => {
        if (valid && this.radio === 'adminMain') {
          axios.get('http://localhost:8081/administrator/' +
              'login?name=' + this.form.username + '&pwd=' + this.form.password).then(
              response => {
                // console.log(response.data.success);
                this.success = response.data.success;
                if (this.success === 1) {
                  //使用 vue-router路由到指定页面，该方式称之为编程式导航
                  Common.userName = this.form.username;
                  Common.identity = '管理员';
                  this.$router.push("/adminProfile");
                } else {
                  alert('密码错误，请重新输入！');
                  this.$refs[formName].resetFields();
                }
              }
          )
        } else if (valid && this.radio === 'mainConsumer') {
          axios.get('http://localhost:8081/serviceConsumer/' +
              'login?name=' + this.form.username + '&pwd=' + this.form.password).then(
              response => {
                // console.log(response.data.success);
                this.success = response.data.success;
                if (this.success === 1) {
                  Common.userName = this.form.username;
                  Common.identity = '服务消费者';
                  this.$router.push("/index");
                } else {
                  alert('密码错误，请重新输入！');
                  this.$refs[formName].resetFields();
                }
              }
          )
        } else if (valid && this.radio === 'mainProvider') {
          axios.get('http://localhost:8081/serviceProvider/' +
              'login?name=' + this.form.username + '&pwd=' + this.form.password).then(
              response => {
                // console.log(response.data.success);
                this.success = response.data.success;
                if (this.success === 1) {
                  Common.userName = this.form.username;
                  Common.identity = '服务提供者';
                  this.$router.push("/index");
                } else {
                  alert('密码错误，请重新输入！');
                  this.$refs[formName].resetFields();
                }
              }
          )
        } else {
          alert('请输入用户名和密码并选择身份');
        }
      });
    },
    handleClose: function () {
      console.log("Handle Close，空函数");
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    toRegister() {
      this.$router.push("/register");
    }
  }
}
</script>

<style scoped>
.div1 {
  background: url(../assets/4.jpg);
  background-size: cover;
}

.box-card {
  background: url(../assets/3.jpg);
  background-size: cover;
  width: 480px;
  margin: auto;
}
</style>