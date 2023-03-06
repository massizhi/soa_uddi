<template>
  <div>
    <div class="div1" style="text-align: left;
    margin: 40px 0px 0px 350px ; width: auto">
      <div class="block" :key="fit"
           style="text-align: left; margin: 10px 10px 20px 0px;width: 150px;padding: 0px">
        <el-image
            style="width: 100px; height: 100px"
            :src="circleUrl"
            :fit="fit"></el-image>
      </div>
      <div style="margin: 20px 0px 0px 0px ;padding: 0px;width: auto">
        <el-card class="box-card">
          <h3 class="login-title" align="center">个人信息</h3>
          <el-form ref="loginForm" :model="form" :rules="rules" label-width="60px" class="login-box">
            <el-form-item label="名称" prop="username">
              <el-input type="text" :disabled="true" :placeholder="pUserName" v-model="form.username"/>
            </el-form-item>
            <el-form-item label="简介" prop="briefInfo">
              <el-input type="text" :placeholder="pBriefInfo" v-model="form.briefInfo"/>
            </el-form-item>
            <el-form-item label="图片" prop="url">
              <el-input type="text" :placeholder="pUrl" v-model="form.url"/>
            </el-form-item>
            <el-form-item label="密码" prop="password">
              <el-input type="password" :placeholder="pPassword" v-model="form.password"/>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" v-on:click="onSubmit('loginForm')">上传信息</el-button>
              <el-button @click="resetForm('loginForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "_axios@0.21.1@axios";
import Common from "@/components/Common";

export default {
  name: "AdminProfile",
  mounted() {
    axios.get('http://localhost:8081/administrator/' +
        'getByName?name=' + Common.userName).then(
        response => {
          // console.log(Common.userName);
          // console.log(response.data.serviceConsumer.id);
          this.pBriefInfo = response.data.administrator.briefInfo;
          this.pPassword = response.data.administrator.password;
          this.pUrl = response.data.administrator.url;
          Common.id = response.data.administrator.id;
          this.id = response.data.administrator.id;
          this.circleUrl = response.data.administrator.url;
        }
    )
  },
  data() {
    return {
      circleUrl: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
      //https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg
      fit: 'fill',
      pUserName: Common.userName,
      pBriefInfo: '',
      pUrl: '',
      pPassword: '',
      id: '',
      form: {
        username: '',
        password: '',
        url: '',
        briefInfo: ''
      },
      rules: {
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
        if (valid) {
          this.axios.post('http://localhost:8081/administrator/update', {
            "id": this.id,
            "briefInfo": this.form.briefInfo,
            "url": this.form.url,
            "password": this.form.password,
          }).then(() => {
            alert('更新成功');
          })
        } else {
          alert('请输入用户密码');
          return false;
        }
      });
    },
    handleClose: function () {
      console.log("Handle Close，空函数");
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
.box-card {
  width: 800px;
}
</style>