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
            label="姓名"
            width="180">
        </el-table-column>
        <el-table-column
            prop="briefInfo"
            label="简介">
        </el-table-column>
        <el-table-column
            fixed="right"
            label="操作"
            prop="id"
            width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small">注销账号</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>
  </div>
</template>

<script>
import axios from "_axios@0.21.1@axios";

export default {
  name: "ConsumerList",
  data() {
    return {
      tableData: []
    }
  },
  mounted() {
    axios.get('http://localhost:8081/serviceConsumer/list').then(
        response => {
          //console.log(response.data.serviceConsumerList);
          this.tableData = response.data.serviceConsumerList;
        }
    )
  },
  methods: {
    handleClick(row) {
      console.log(row);
      this.axios.get('http://localhost:8081/serviceConsumer/delete?' +
          'id=' + row.id).then((response) => {
        alert(response.data.message);
      })
    }
  }
}
</script>

<style scoped>

</style>