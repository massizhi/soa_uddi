package com.mkx.soa.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ElasticSearchService {
    /**
     * 创建一个新的Es索引库，并且添加属性。
     */
    void initEs() throws IOException;

    /**
     * 将数据库中的服务信息复制到新建的Es索引库中
     */
    void addDataToEs() throws IOException;

    /**
     * 删除es索引中的文档
     */
    void deleteDataInEs() throws IOException;

    /**
     * 得到ES中的所有数据
     */
    List<Map<String,Object>> getDataInEs() throws IOException;

    /**
     * 根据关键字搜索service索引库中的相关服务信息
     */
    List<Map<String,Object>> getServicesByKeyWord(String keyWord) throws IOException;

    /**
     * 根据关键字搜索service索引库中的相关服务信息（这个是精准匹配，需要字符串完全对应）
     */
    List<Map<String,Object>> getServicesByKeyWord1(String keyWord) throws IOException;

    /**
     * 根据属性和关键字搜索service索引库中的相关服务信息
     */
    List<Map<String,Object>> getServicesByAttributeAndKeyWord(String attribute,String keyWord) throws IOException;

    /**
     * 根据属性和关键字搜索service索引库中的相关服务信息（这个是精准匹配，需要字符串完全对应）
     */
    List<Map<String,Object>> getServicesByAttributeAndKeyWord1(String attribute,String keyWord) throws IOException;
}
