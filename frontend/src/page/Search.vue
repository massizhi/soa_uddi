<template>
  <div style="margin: 0px 200px 0px 200px">
    <pre> </pre>
    <pre> </pre>
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item label="关键字">
        <el-input v-model="formInline.key" placeholder="请输入搜索关键字"></el-input>
      </el-form-item>
      <el-form-item label="条件搜索">
        <el-select v-model="formInline.way" placeholder="请选择搜索条件">
          <el-option label="服务名称" value="name"></el-option>
          <el-option label="发布位置" value="providerLocation"></el-option>
          <el-option label="提供者名称" value="providerName"></el-option>
          <el-option label="提供者简介" value="providerBriefInfo"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit1">模糊查询</el-button>
        <el-button @click="onSubmit2">精确查询</el-button>
      </el-form-item>
    </el-form>
    <el-row>
      <el-col :span="6" v-for="item in items" :key="item">
        <el-card :body-style="{ margin: '20px' , padding: '0px',height:'480px'}" shadow="hover">
          <el-image
              style="width: 200px; height: 200px"
              :src="item.pictureUrl"
              fit="fill"></el-image>
          <div style="padding: 15px;">
          </div>
          <p style="alignment: left;text-align: left">服务名称：{{ item.name }}</p>
          <p style="alignment: left;text-align: left">服务WSDL：{{ item.wsdl }}</p>
          <p style="alignment: left;text-align: left">发布位置：{{ item.providerLocation }}</p>
          <p style="alignment: left;text-align: left">提供者名称：{{ item.providerName }}</p>
          <p style="alignment: left;text-align: left">提供者简介：{{ item.providerBriefInfo }}</p>
        </el-card>
      </el-col>
    </el-row>
  </div>

</template>

<script>
import axios from "_axios@0.21.1@axios";
import Common from "@/components/Common";

export default {
  name: "Search",
  data() {
    return {
      userName: Common.userName,
      identity: Common.identity,
      id: Common.id,
      items: [],
      span: '',
      formInline: {
        key: '',
        way: ''
      }
    }
  },
  mounted() {
    axios.get('http://localhost:8081/es/allData').then(
        response => {
          //console.log(response.data);
          this.items = response.data;
        }
    )
  },
  methods: {
    onSubmit1() {
      axios.get('http://localhost:8081/es/getServiceByAK?' +
          'attribute=' + this.formInline.way + '&keyWord=' + this.formInline.key).then(
          response => {
            //console.log(response.data);
            this.items = response.data;
          }
      )
    },
    onSubmit2() {
      axios.get('http://localhost:8081/es/getServiceByAK1?' +
          'attribute=' + this.formInline.way + '&keyWord=' + this.formInline.key).then(
          response => {
            //console.log(response.data);
            this.items = response.data;
          }
      )
    }
  }
}
</script>

<style scoped>

</style>