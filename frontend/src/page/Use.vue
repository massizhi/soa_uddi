<template>
  <div class="div1">
    <pre class="pre1">  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <div style="margin: 20px 250px 0px 250px">
      <el-row>
        <el-col :span="12">
          <el-card :body-style="{ margin: '20px' , padding: '0px',height:'480px'}" shadow="hover">
            <h1>城市天气服务</h1>
            <pre> </pre>
            <el-form :inline="true" :model="formInline1" class="demo-form-inline">
              <el-form-item label="城市：">
                <el-input v-model="formInline1.city" placeholder="请输入想要查询的城市天气"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="onSubmit1">查询</el-button>
              </el-form-item>
              <pre> </pre>
              <textarea v-model="this.weather" rows="12" cols="50">
              </textarea>
            </el-form>
            <h4>调用方式： HttpUrlConnection</h4>
            <h4>请求方式： GET</h4>
          </el-card>
        </el-col>
        <el-col :span="12">
          <el-card :body-style="{ margin: '20px' , padding: '0px',height:'480px'}" shadow="hover">
            <h1>号码归属地查询服务</h1>
            <pre> </pre>
            <el-form :inline="true" :model="formInline2" class="demo-form-inline">
              <el-form-item label="号码：">
                <el-input v-model="formInline2.telephone" placeholder="请输入想要查询的手机号码"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="onSubmit2">查询</el-button>
              </el-form-item>
              <pre> </pre>
              <textarea v-model="this.location" rows="12" cols="50">
              </textarea>
            </el-form>
            <h4>调用方式： HttpUrlConnection</h4>
            <h4>请求方式： POST</h4>
            <pre> </pre>
          </el-card>
        </el-col>
      </el-row>
    </div>
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
  </div>
</template>

<script>
export default {
  name: "Use",
  data() {
    return {
      formInline1: {
        city: ''
      },
      formInline2: {
        telephone: ''
      },
      weather: '',
      location: ''
    }
  },
  methods: {
    onSubmit1() {
      this.axios.get('http://localhost:8081/call/weather?' +
          'city=' + this.formInline1.city).then((response) => {
        //console.log(response.data);
        this.weather = response.data.weather;
      })
    },
    onSubmit2() {
      this.axios.post('http://localhost:8081/call/telephone', {
        "telephone": this.formInline2.telephone
      }).then((response) => {
        this.location = response.data.location;
      })
    }
  }
}
</script>

<style scoped>
.div1 {
  background: url(../assets/4.jpg);
  background-size: cover;
}

.pre1 {
  margin: 0;
  padding: 0;
  width: 100%;
  position: relative;
}
</style>