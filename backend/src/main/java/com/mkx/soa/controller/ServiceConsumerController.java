package com.mkx.soa.controller;

import com.mkx.soa.entity.ServiceConsumer;
import com.mkx.soa.service.ServiceConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/serviceConsumer")
@CrossOrigin
public class ServiceConsumerController {
    @Autowired
    private ServiceConsumerService serviceConsumerService;

    /**
     * 增加新的服务消费者（注册）
     * @param serviceConsumer
     * @return Map<"message",Object>
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private Map<String, Object> register(@RequestBody ServiceConsumer serviceConsumer) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = serviceConsumerService.insertServiceConsumer(serviceConsumer);
        if (result == 1) {
            modelMap.put("message", "服务消费者身份注册成功");
        } else {
            modelMap.put("message", "服务消费者身份注册失败");
        }
        return modelMap;
    }

    /**
     * 删除服务消费者（注销账号）
     * @param id
     * @return Map<"message",Object>
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    private Map<String, Object> delete(Integer id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = serviceConsumerService.deleteServiceConsumer(id);
        if (result == 1) {
            modelMap.put("message", "服务消费者身份删除成功");
        } else {
            modelMap.put("message", "服务消费者身份删除失败");
        }
        return modelMap;
    }

    /**
     * 更新服务消费者信息
     * @param serviceConsumer
     * @return Map<"message",Object>
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    private Map<String, Object> update(@RequestBody ServiceConsumer serviceConsumer) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = serviceConsumerService.updateServiceConsumer(serviceConsumer);
        if (result == 1) {
            modelMap.put("message", "服务消费者信息更新成功");
        } else {
            modelMap.put("message", "服务消费者信息更新失败");
        }
        return modelMap;
    }

    /**
     * 返回全体服务消费者列表
     * @param
     * @return Map<"serviceConsumerList",List<ServiceConsumer>>
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Map<String,Object> list(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<ServiceConsumer> serviceConsumerList = serviceConsumerService.getServiceConsumerList();
        modelMap.put("serviceConsumerList",serviceConsumerList);
        return modelMap;
    }

    /**
     * 通过id得到服务消费者对象
     * @param id
     * @return Map<"serviceConsumer",serviceConsumer>
     */
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    private Map<String,Object> getById(Integer id){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ServiceConsumer serviceConsumer = serviceConsumerService.getServiceConsumerById(id);
        modelMap.put("serviceConsumer",serviceConsumer);
        return modelMap;
    }

    /**
     * 通过name得到服务消费者对象
     * @param name
     * @return Map<"serviceConsumer",serviceConsumer>
     */
    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    private Map<String,Object> getByName(String name){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ServiceConsumer serviceConsumer = serviceConsumerService.getServiceConsumerByName(name);
        modelMap.put("serviceConsumer",serviceConsumer);
        return modelMap;
    }

    /**
     * 登录（通过服务消费者name和password判断是否可以成功登录）
     * @param name
     * @return Map<"success",int>(1 成功,0 失败)
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private Map<String,Object> login(String name,String pwd){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String password = serviceConsumerService.getPasswordByName(name);
        int success = (password.compareTo(pwd)==0 ?1:0);
        modelMap.put("success",success);
        return modelMap;
    }
}
