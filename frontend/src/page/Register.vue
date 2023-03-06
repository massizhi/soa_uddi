<template>
  <div class="div1">
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <el-tabs type="border-card" class="el-table">
      <el-tab-pane label="服务消费者">
        <el-form ref="loginForm" :model="form" :rules="rules" label-width="60px" class="login-box">
          <h3 class="login-title" align="center">用户注册</h3>
          <el-form-item label="名称" prop="username">
            <el-input type="text" placeholder="请输入用户名" v-model="form.username"/>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" placeholder="请输入密码" v-model="form.password"/>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" v-on:click="onSubmit1('loginForm')">注册</el-button>
            <el-button @click="resetForm('loginForm')">重置</el-button>
            <el-button type="primary" plain @click="toLogin">用户登录</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="服务提供者">
        <el-form ref="loginForm" :model="form" :rules="rules" label-width="60px" class="login-box">
          <h3 class="login-title" align="center">用户注册</h3>
          <el-form-item label="账号" prop="username">
            <el-input type="text" placeholder="请输入账号" v-model="form.username"/>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" placeholder="请输入密码" v-model="form.password"/>
          </el-form-item>
          <el-form-item label="地址" prop="location">
            <el-select v-model="value" placeholder="请选择地址">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" v-on:click="onSubmit2('loginForm')">注册</el-button>
            <el-button @click="resetForm('loginForm')">重置</el-button>
            <el-button type="primary" plain @click="toLogin">用户登录</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
    </el-tabs>
    <pre>   </pre>
    <pre>   </pre>
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
export default {
  name: "Register",
  data() {
    return {
      form: {
        username: '',
        password: '',
        value: ''
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
    onSubmit1(formName) {
      //为表单绑定验证功能
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.axios.post('http://localhost:8081/serviceConsumer/register', {
            "name": this.form.username,
            "password": this.form.password
          }).then((response) => {
            let message = response.data.message;
            //console.log(message);
            if (message === '服务消费者身份注册成功') {
              alert('注册成功，点击确认进入登录界面');
              this.$router.push("/login");
            } else {
              alert('账号已存在，请重新输入');
              this.$refs[formName].resetFields();
            }
          })
        } else {
          alert('请输入用户名和密码');
          return false;
        }
      });
    },
    onSubmit2(formName) {
      //为表单绑定验证功能
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.axios.post('http://localhost:8081/serviceProvider/register', {
            "name": this.form.username,
            "password": this.form.password,
            "location": this.value
          }).then((response) => {
            let message = response.data.message;
            //console.log(message);
            if (message === '服务提供者身份注册成功') {
              alert('注册成功，点击确认进入登录界面');
              this.$router.push("/login");
            } else {
              alert('账号已存在，请重新输入');
              this.$refs[formName].resetFields();
            }
          })
        } else {
          alert('请输入用户名和密码');
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
    toLogin() {
      this.$router.push("/login");
    }
  }
}
</script>

<style scoped>
.div1 {
  background: url(../assets/4.jpg);
  background-size: cover;
}

.el-table {
  /*background: url(../assets/3.jpg);*/
  /*background-size: cover;*/
  width: 480px;
  margin: auto;
}
</style>