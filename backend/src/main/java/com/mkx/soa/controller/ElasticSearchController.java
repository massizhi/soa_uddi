package com.mkx.soa.controller;

import com.mkx.soa.entity.Service;
import com.mkx.soa.service.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/es")
@CrossOrigin
public class ElasticSearchController {
    @Autowired
    private ElasticSearchService elasticSearchService;

    /**
     * es索引建立
     * @return Map<"message",String>
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    private Map<String, Object> create() throws IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        elasticSearchService.initEs();
        modelMap.put("message", "创建成功！");
        return modelMap;
    }

    /**
     * es索引库添加文档
     * @return Map<"message",String>
     */
    @RequestMapping(value = "/addDocumentFromDB", method = RequestMethod.GET)
    private Map<String, Object> addDocumentFromDB() throws IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        elasticSearchService.addDataToEs();
        modelMap.put("message", "数据添加成功！");
        return modelMap;
    }

    /**
     * 清空es索引库
     * @return Map<"message",String>
     */
    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    private Map<String, Object> clear() throws IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        elasticSearchService.deleteDataInEs();
        modelMap.put("message", "数据已清除！");
        return modelMap;
    }

    /**
     * 更新es索引库（和数据库里的数据保持同步）
     * @return Map<"message",String>
     */
    @RequestMapping(value = "/updateDocumentFromDB", method = RequestMethod.GET)
    private Map<String, Object> updateDocumentFromDB() throws IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        elasticSearchService.deleteDataInEs();
        elasticSearchService.addDataToEs();
        modelMap.put("message", "ElasticSearch数据已和数据库同步！");
        return modelMap;
    }

    /**
     * 得到es索引库所有数据
     * @return List<Map<String, Object>>
     */
    @RequestMapping(value = "/allData", method = RequestMethod.GET)
    private List<Map<String, Object>> allData() throws IOException {
        return elasticSearchService.getDataInEs();
    }

    /**
     * 根据关键字搜索service索引库中的相关服务信息
     * @return List<Map<String, Object>>
     */
    @RequestMapping(value = "/getServiceByKW", method = RequestMethod.GET)
    private List<Map<String, Object>> getServiceByKW(String keyWord) throws IOException {
        return elasticSearchService.getServicesByKeyWord(keyWord);
    }

    /**
     * 根据关键字搜索service索引库中的相关服务信息（这个是精准匹配，需要字符串完全对应）
     * @return List<Map<String, Object>>
     */
    @RequestMapping(value = "/getServiceByKW1", method = RequestMethod.GET)
    private List<Map<String, Object>> getServiceByKW1(String keyWord) throws IOException {
        return elasticSearchService.getServicesByKeyWord1(keyWord);
    }

    /**
     * 根据属性和关键字搜索service索引库中的相关服务信息
     * @return List<Map<String, Object>>
     */
    @RequestMapping(value = "/getServiceByAK", method = RequestMethod.GET)
    private List<Map<String, Object>> getServiceByAK(String attribute,String keyWord) throws IOException {
        return elasticSearchService.getServicesByAttributeAndKeyWord(attribute,keyWord);
    }

    /**
     * 根据属性和关键字搜索service索引库中的相关服务信息（这个是精准匹配，需要字符串完全对应）
     * @return List<Map<String, Object>>
     */
    @RequestMapping(value = "/getServiceByAK1", method = RequestMethod.GET)
    private List<Map<String, Object>> getServiceByAK1(String attribute,String keyWord) throws IOException {
        return elasticSearchService.getServicesByAttributeAndKeyWord1(attribute,keyWord);
    }
}
