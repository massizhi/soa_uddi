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
            <el-form-item label="地址" prop="location">
              <el-select v-model="value" :placeholder="pLocation">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
              </el-select>
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
                                            用户已上传的服务</pre>
      <el-row>
        <el-col :span="6" v-for="item in items" :key="item">
          <el-card :body-style="{ margin: '20px' , padding: '0px',height:'380px'}" shadow="hover">
            <el-image
                style="width: 200px; height: 200px"
                :src="item.pictureUrl"
                fit="fill"></el-image>
            <p style="alignment: left;text-align: left">服务名称：{{ item.name }}</p>
            <p style="alignment: left;text-align: left">服务WSDL：{{ item.wsdl }}</p>
            <el-button type="primary" plain @click="down(item.id)">下架服务</el-button>
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
  name: "Profile",
  mounted() {
    axios.get('http://localhost:8081/serviceProvider/' +
        'getByName?name=' + Common.userName).then(
        response => {
          // console.log(Common.userName);
          // console.log(response.data.serviceProvider.id);
          this.pBriefInfo = response.data.serviceProvider.briefInfo;
          this.pLocation = response.data.serviceProvider.location;
          this.pPassword = response.data.serviceProvider.password;
          this.pUrl = response.data.serviceProvider.url;
          Common.id = response.data.serviceProvider.id;
          this.id = response.data.serviceProvider.id;
          this.circleUrl = response.data.serviceProvider.url;
        }
    )
    axios.get('http://localhost:8081/service/getListByProviderId?' +
        'providerId='+Common.id).then(
        response => {
          // console.log(this.id);
          // console.log(response);
          // console.log("response");
          // console.log(response);
          this.items = response.data.serviceInfoList;
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
      pLocation: '',
      id: '',
      form: {
        username: '',
        password: '',
        value: '',
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
      options: [{
        value: '安徽',
        label: '安徽'
      }, {
        value: '北京',
        label: '北京'
      }, {
        value: '重庆',
        label: '重庆'
      }, {
        value: '福建',
        label: '福建'
      }, {
        value: '甘肃',
        label: '甘肃'
      }, {
        value: '广东',
        label: '广东'
      }, {
        value: '广西',
        label: '广西'
      }, {
        value: '贵州',
        label: '贵州'
      }, {
        value: '海南',
        label: '海南'
      }, {
        value: '河北',
        label: '河北'
      }, {
        value: '河南',
        label: '河南'
      }, {
        value: '黑龙江',
        label: '黑龙江'
      }, {
        value: '湖北',
        label: '湖北'
      }, {
        value: '湖南',
        label: '湖南'
      }, {
        value: '江西',
        label: '江西'
      }, {
        value: '吉林',
        label: '吉林'
      }, {
        value: '江苏',
        label: '江苏'
      }, {
        value: '辽宁',
        label: '辽宁'
      }, {
        value: '内蒙古',
        label: '内蒙古'
      }, {
        value: '宁夏',
        label: '宁夏'
      }, {
        value: '青海',
        label: '青海'
      }, {
        value: '山西',
        label: '山西'
      }, {
        value: '山东',
        label: '山东'
      }, {
        value: '陕西',
        label: '陕西'
      }, {
        value: '上海',
        label: '上海'
      }, {
        value: '四川',
        label: '四川'
      }, {
        value: '天津',
        label: '天津'
      }, {
        value: '西藏',
        label: '西藏'
      }, {
        value: '新疆',
        label: '新疆'
      }, {
        value: '云南',
        label: '云南'
      }, {
        value: '浙江',
        label: '浙江'
      }
      ],
      value: ''
    }
  },
  methods: {
    onSubmit(formName) {
      //为表单绑定验证功能
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.axios.post('http://localhost:8081/serviceProvider/update', {
            "id": this.id,
            "briefInfo": this.form.briefInfo,
            "url": this.form.url,
            "password": this.form.password,
            "location": this.value
          }).then((response) => {
            let message = response.data.message;
            //console.log(message);
            if (message === '服务更新成功') {
              alert('更新成功');
              this.$router.push("/profile");
            } else {
              alert('服务更新失败，请重新输入');
              this.$refs[formName].resetFields();
            }
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
    down(id) {
      this.axios.get('http://localhost:8081/service/delete?' +
          'id='+id).then((response) => {
        console.log(response.data.message);
        alert('服务下架成功！');
      })
    }
  }
  // beforeRouteEnter: (to, from, next) => {
  //   //console.log();
  //   next(vm => {
  //     vm.getData();
  //   });
  // }
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