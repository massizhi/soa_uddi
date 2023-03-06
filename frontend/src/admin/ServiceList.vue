<template>
  <div>
    <template>
      <el-table
          :data="tableData"
          stripe
          style="width: 100%">
        <el-table-column
            prop="id"
            label="id"
            width="180">
        </el-table-column>
        <el-table-column
            prop="name"
            label="服务名称"
            width="180">
        </el-table-column>
        <el-table-column
            prop="providerId"
            label="提供者id"
            width="180">
        </el-table-column>
        <el-table-column
            prop="wsdl"
            label="WSDL">
        </el-table-column>
        <el-table-column
            fixed="right"
            label="操作"
            prop="id"
            width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small">下架服务</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>
  </div>
</template>

<script>
import axios from "_axios@0.21.1@axios";

export default {
  name: "ServiceList",
  data() {
    return {
      tableData: []
    }
  },
  mounted() {
    axios.get('http://localhost:8081/service/list').then(
        response => {
          //console.log(response.data.serviceInfoList);
          this.tableData = response.data.serviceInfoList;
        }
    )
  },
  methods: {
    handleClick(row) {
      console.log(row);
      this.axios.get('http://localhost:8081/service/delete?' +
          'id=' + row.id).then((response) => {
        alert(response.data.message);
      })
    }
  }
}
</script>

<style scoped>

</style>