<template>
  <div class="div1">
    <pre class="one">  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <el-card class="box-card" shadow="hover">
      <el-form ref="loginForm" :model="form" :rules="rules" label-width="60px" class="login-box">
        <h3 class="login-title" align="center">服务上传</h3>
        <el-form-item label="名称" prop="serviceName">
          <el-input type="text" placeholder="请输入服务名称" v-model="form.serviceName"/>
        </el-form-item>
        <el-form-item label="WSDL" prop="wsdl">
          <el-input type="text" placeholder="请输入WSDL或者它的URL" v-model="form.wsdl"/>
        </el-form-item>
        <el-form-item label="图片" prop="picture">
          <el-input type="text" placeholder="请输入图片的URL地址" v-model="form.picture"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="onSubmit('loginForm')">上传</el-button>
          <el-button @click="resetForm('loginForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-card>
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
  </div>
</template>

<script>
import axios from "axios";
import Common from "@/components/Common";

export default {
  name: "Upload",
  mounted() {
    axios.get('http://localhost:8081/serviceProvider/' +
        'getByName?name=' + Common.userName).then(
        response => {
          // console.log(Common.userName);
          // console.log(response.data.serviceProvider.id);
          Common.id = response.data.serviceProvider.id;
          this.id = Common.id;
        }
    )
  },
  data() {
    return {
      identity: Common.identity,
      id: Common.id,
      form: {
        serviceName: '',
        wsdl: '',
        picture: ''
      },
      //表单验证，需要再el-form-item 元素中增加prop属性
      rules: {
        serviceName: [
          {
            required: true, message: '账号不能为空', trigger: 'blur'
          }
        ],
        wsdl: [
          {
            required: true, message: '密码不能为空', trigger: 'blur'
          }
        ]
      }
    };
  },
  methods: {
    onSubmit(formName) {
      //为表单绑定验证功能
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.axios.post('http://localhost:8081/service/register', {
            "name": this.form.serviceName,
            "providerId": this.id,
            "wsdl": this.form.wsdl,
            "pictureUrl": this.form.picture
          }).then((response) => {
            let message = response.data.message;
            console.log(message);
            if (message === '服务注册成功') {
              alert('服务上传成功');
            } else {
              alert('服务名已存在，请重新输入');
              this.$refs[formName].resetFields();
            }
          })
        } else {
          alert('请将服务名称和WSDL(URL)填写完整');
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
  background: url(../assets/3.jpg);
  background-size: cover;
  width: 480px;
  margin: auto;
}

.div1 {
  background: url(../assets/4.jpg);
  background-size: cover;
}


.one {
  margin: 0;
  padding: 0;
  width: 100%;
  position: relative;
}
</style>