<template>
  <div style="margin: 40px 200px 0px 200px">
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
export default {
  name: "Brief",
  data() {
    return {
      items: [],
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
}
</script>

<style scoped>

</style>