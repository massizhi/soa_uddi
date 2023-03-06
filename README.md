# SOA UDDI 服务注册与搜索中心

---

## 1. 功能

本项目的主要目标是实现面向服务架构中的服务管理中心UDDI，主要提供服务注册、服务搜索、服务绑定、身份信息管理等功能。搜索引擎使用的是搜索和数据分析引擎 Elasticsearch，同时集成了 ik 分词器、可视化界面等其他辅助工具。项目中的服务信息同时存储在数据库与分布式的 Elasticsearch 索引中，利用负载均衡、节点故障处理功能实现服务数据的安全可信。(项目包括前端+后端+数据库+ES，ES需自行安装)

## 2. 环境配置

 - MySql 8.0
 - Java 1.8
 - Javascript
 - navicat
 - SpringBoot 2.2.6
 - Mybatis 5.7

## 3. 运行效果
![此处输入图片的描述][1]
![此处输入图片的描述][2]


  [1]: https://images.cnblogs.com/cnblogs_com/massizhi/2180441/o_230306135134_%E5%9B%BE%E7%89%871.png
  [2]: https://images.cnblogs.com/cnblogs_com/massizhi/2180441/o_230306135141_%E5%9B%BE%E7%89%872.png
