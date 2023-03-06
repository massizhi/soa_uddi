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
          <h3 class="login-title" align="center">用户资料</h3>
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
    <pre> </pre>
    <div class="div1" style="text-align: left;
    margin: 40px 250px 0px 250px ; width: auto">
      <pre style="text-align: left ; font-size: 20px ; font-weight: bolder">
                                            用户已绑定的服务</pre>
      <el-row>
        <el-col :span="6" v-for="item in items" :key="item">
          <el-card :body-style="{ margin: '20px' , padding: '0px',height:'380px'}" shadow="hover">
            <el-image
                style="width: 200px; height: 200px"
                :src="item.pictureUrl"
                fit="fill"></el-image>
            <p style="alignment: left;text-align: left">服务名称：{{ item.name }}</p>
            <p style="alignment: left;text-align: left">服务WSDL：{{ item.wsdl }}</p>
            <el-button type="primary" plain @click="down(item.id)">取消绑定</el-button>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import Common from "@/components/Common";
import axios from "_axios@0.21.1@axios";

export default {
  name: "ProfileConsumer",
  mounted() {
    axios.get('http://localhost:8081/serviceConsumer/' +
        'getByName?name=' + Common.userName).then(
        response => {
          // console.log(Common.userName);
          // console.log(response.data.serviceConsumer.id);
          this.pBriefInfo = response.data.serviceConsumer.briefInfo;
          this.pPassword = response.data.serviceConsumer.password;
          this.pUrl = response.data.serviceConsumer.url;
          Common.id = response.data.serviceConsumer.id;
          this.id = response.data.serviceConsumer.id;
          this.circleUrl = response.data.serviceConsumer.url;
        }
    ),
    axios.get('http://localhost:8081/serviceBinding/getListByConsumerId?' +
        'consumerId='+Common.id).then(
      response => {
        // console.log(response);
        this.items = response.data.serviceDetailedInfoList;
      }
    )
  },
  data() {
    return {
      items: [],
      fit: 'fill',
      circleUrl: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
      //https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg
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
      //表单验证，需要再el-form-item 元素中增加prop属性
      rules: {
        password: [
          {
            required: true, message: '密码不能为空', trigger: 'blur'
          }
        ]
      },
    }
  },
  methods: {
    onSubmit(formName) {
      //为表单绑定验证功能
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.axios.post('http://localhost:8081/serviceConsumer/update', {
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
    },
    down(serviceId) {
      axios.get('http://localhost:8081/serviceBinding/delete?' +
          'consumerId='+Common.id+"&serviceId="+serviceId).then(
          response => {
            console.log(response);
            alert('服务取消绑定成功！');
          }
      )
    }
  }
}
</script>

<style scoped>
.box-card {
  /*background: url(../assets/3.jpg);*/
  /*background-size: cover;*/
  width: 800px;
  margin: 0px;
}
</style>