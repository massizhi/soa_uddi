<template>
  <div class="info">
    <el-row>
      <el-col>
        <pre>  </pre>
        <pre>  </pre>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="8" :offset="2">
        <el-card shadow="hover" :body-style="{ padding: '10px',margin: '20px 100px 20px 100px'} ">
          <img src="../assets/erweima.jpg" class="image">
          <div style="padding: 14px;">
            <span>微信号：mkx-change</span>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card class="el-card" shadow="hover" :body-style="{ padding: '100px' }">
          <el-collapse v-model="activeName" accordion>
            <el-collapse-item title="项目介绍" name="1">
              <div>一种可信SOA框架的实现</div>
              <div> 本课题的主要目标是实现一种面向服务的架构，主要提供服务注册、服务搜索、服务绑定、身份信息管理等功能,
                并且采用区块链存储服务、服务提供者相关信息以实现可信。搜索引擎使用的是分布式的搜索和数据分析引擎
                Elasticsearch，同时集成了分词器、可视化界面等其他辅助工具。
              </div>
            </el-collapse-item>
            <el-collapse-item title="开发者信息" name="2">
              <div>马科学</div>
              <div>数学与计算机科学学院</div>
              <div>软件工程专业</div>
            </el-collapse-item>
            <el-collapse-item title="联系方式" name="3">
              <div>18259125513</div>
              <div>QQ：2750201946</div>
              <div>mkx-change</div>
            </el-collapse-item>
            <el-collapse-item title="Github / CNBlogs" name="4">
              <div>Github：https://github.com/massizhi/</div>
              <div>博客园：https://www.cnblogs.com/massizhi/</div>
            </el-collapse-item>
            <el-collapse-item title="更多  More" name="5">
              <div>版本：1.0.1</div>
              <div>Copyright @福州大学数学与计算机科学学院 马科学</div>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
    </el-row>
    <pre>  </pre>
    <pre>  </pre>
    <pre>  </pre>
  </div>
</template>

<script>
export default {
  name: "Info",
  data() {
    return {
      currentDate: new Date(),
      activeName: '1'
    };
  }
}
</script>

<style scoped>
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}


.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.el-card {
  height: 500px;
}

.info {
  background: url(../assets/4.jpg);
  background-size: cover;
}
</style>