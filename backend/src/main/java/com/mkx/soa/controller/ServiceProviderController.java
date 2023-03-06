package com.mkx.soa.controller;

import com.mkx.soa.entity.ServiceProvider;
import com.mkx.soa.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/serviceProvider")
@CrossOrigin
public class ServiceProviderController {
    @Autowired
    private ServiceProviderService serviceProviderService;

    /**
     * 增加新的服务提供者（注册）
     * @param serviceProvider
     * @return Map<"message",Object>
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private Map<String, Object> register(@RequestBody ServiceProvider serviceProvider) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = serviceProviderService.insertServiceProvider(serviceProvider);
        if (result == 1) {
            modelMap.put("message", "服务提供者身份注册成功");
        } else {
            modelMap.put("message", "服务提供者身份注册失败");
        }
        return modelMap;
    }

    /**
     * 删除服务提供者（注销账号）
     * @param id
     * @return Map<"message",Object>
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    private Map<String, Object> delete(Integer id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = serviceProviderService.deleteServiceProvider(id);
        if (result == 1) {
            modelMap.put("message", "服务提供者身份删除成功");
        } else {
            modelMap.put("message", "服务提供者身份删除失败");
        }
        return modelMap;
    }

    /**
     * 更新服务提供者信息
     * @param serviceProvider
     * @return Map<"message",Object>
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    private Map<String, Object> update(@RequestBody ServiceProvider serviceProvider) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = serviceProviderService.updateServiceProvider(serviceProvider);
        if (result == 1) {
            modelMap.put("message", "服务更新成功");
        } else {
            modelMap.put("message", "服务更新失败");
        }
        return modelMap;
    }

    /**
     * 返回全体服务提供者列表
     * @param
     * @return Map<"serviceProviderList",List<ServiceProvider>>
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Map<String,Object> list(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<ServiceProvider> serviceProviderList = serviceProviderService.getServiceProviderList();
        modelMap.put("serviceProviderList",serviceProviderList);
        return modelMap;
    }

    /**
     * 通过id得到服务提供者对象
     * @param id
     * @return Map<"serviceProvider",serviceProvider>
     */
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    private Map<String,Object> getById(Integer id){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ServiceProvider serviceProvider = serviceProviderService.getServiceProviderById(id);
        modelMap.put("serviceProvider",serviceProvider);
        return modelMap;
    }

    /**
     * 通过name得到服务提供者对象
     * @param name
     * @return Map<"serviceProvider",serviceProvider>
     */
    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    private Map<String,Object> getByName(String name){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ServiceProvider serviceProvider = serviceProviderService.getServiceProviderByName(name);
        modelMap.put("serviceProvider",serviceProvider);
        return modelMap;
    }

    /**
     * 登录（通过服务提供者name和password判断是否可以成功登录）
     * @param name
     * @return Map<"success",int>(1 成功,0 失败)
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private Map<String,Object> login(String name,String pwd){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String password = serviceProviderService.getPasswordByName(name);
        int success = (password.compareTo(pwd)==0 ?1:0);
        modelMap.put("success",success);
        return modelMap;
    }

    /**
     * 通过location得到该区域服务提供者的数量
     * @param location
     * @return Map<"number",int>(该区域服务提供者的数量)
     */
    @RequestMapping(value = "/getNumberByLocation", method = RequestMethod.GET)
    private Map<String,Object> getNumberByLocation(String location){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int number = serviceProviderService.getNumberByLocation(location);
        modelMap.put("number",number);
        return modelMap;
    }
}
