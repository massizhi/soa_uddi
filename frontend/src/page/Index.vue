<template>
  <div class="box1">
    <div class="box2">
      <pre class="one">    </pre>
      <pre>    </pre>
      <pre>    </pre>
      <pre>    </pre>
      <pre style="alignment: center; text-align: center;
    color: ghostwhite; font-size: 40px;">我的面向服务框架</pre>
      <pre style="alignment: center; text-align: center;
    color: ghostwhite; font-size: 30px;">公共UDDI</pre>
      <pre>    </pre>
      <pre>    </pre>
      <el-button v-on:click="toBrief" type="primary">开始使用</el-button>
      <el-button v-on:click="toInfo">了解我们</el-button>
      <pre>    </pre>
      <pre>    </pre>
      <pre>    </pre>
      <pre class="one">    </pre>
    </div>
    <div class="box3">
      <pre class="one">    </pre>
      <el-row class="el-row">
        <el-col :span="8"><pre class="three">SOA简介                           </pre></el-col>
        <el-col :span="8"><pre class="three">技术栈           </pre></el-col>
        <el-col :span="8"><pre class="three">Elastic Stack </pre></el-col>
      </el-row>
      <pre class="one">    </pre>
      <el-row class="el-row">
        <el-col :span="8">
          <pre class="two">定义：一套可以被调用的组件,用户可以发布并发现其接口。</pre>
        </el-col>
        <el-col :span="8">
          <pre class="two">SpringBoot     MyBatis    </pre>
        </el-col>
        <el-col :span="8">
          <pre class="two">Elastic Search       </pre>
        </el-col>
      </el-row>
      <pre class="one">    </pre>
      <el-row class="el-row">
        <el-col :span="8">
          <pre class="two">参与者：服务消费者、服务提供者、服务注册中心。       </pre>
        </el-col>
        <el-col :span="8">
          <pre class="two">Vue    Axios     ElementUI</pre>
        </el-col>
        <el-col :span="8">
          <pre class="two">Kibana               </pre>
        </el-col>
      </el-row>
      <pre class="one">    </pre>
      <el-row class="el-row">
        <el-col :span="8">
          <pre class="two">技术：WSDL、Web Service、Soap、UDDI等。              </pre>
        </el-col>
        <el-col :span="8">
          <pre class="two">ElasticSearch      SOA    </pre>
        </el-col>
        <el-col :span="8">
          <pre class="two">Beats   Logstash     </pre>
        </el-col>
      </el-row>
      <pre class="one">    </pre>
      <pre style="color: ghostwhite; font-size: 10px;">Copyright @XX大学数学与计算机科学学院 XXX</pre>
      <pre class="one">    </pre>
    </div>
  </div>
</template>

<script>
export default {
  name: "Index",
  methods: {
    toBrief: function () {
      this.$router.push("/brief");
    },
    toInfo: function () {
      this.$router.push("/info");
    }
  }
}
</script>

<style scoped>
.box1 {
  margin: 0;
  padding: 0;
  width: 100%;
  position: relative;
}

.box2 {
  background: url(../assets/4.jpg);
  background-size: cover;
  margin: 0;
  padding: 0;
  width: 100%;
  position: relative;
}

.box3 {
  background: #5a73f8;
  margin: 0;
  padding: 0;
  width: 100%;
  position: relative;
}

.one {
  margin: 0;
  padding: 0;
  width: 100%;
  position: relative;
}

.three {
  margin: 0;
  padding: 0;
  font-size: 20px;
  color: ghostwhite;
  alignment: left;
}

.two {
  margin: 0;
  padding: 0;
  font-size: 13px;
  color: ghostwhite;
  alignment: center;
}
</style>