package com.mkx.soa.controller;

import com.mkx.soa.entity.Administrator;
import com.mkx.soa.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/administrator")
@CrossOrigin
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    /**
     * 更新管理员信息
     * @param administrator
     * @return Map<"message",Object>
     */

    private Map<String, Object> update(@RequestBody Administrator administrator) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = administratorService.updateAdministrator(administrator);
        if (result == 1) {
            modelMap.put("message", "服务更新成功");
        } else {
            modelMap.put("message", "服务更新失败");
        }
        return modelMap;
    }

    /**
     * 通过id得到管理员对象
     * @param id
     * @return Map<"administrator",administrator>
     */
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    private Map<String,Object> getById(Integer id){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Administrator administrator = administratorService.getAdministratorById(id);
        modelMap.put("administrator",administrator);
        return modelMap;
    }

    /**
     * 通过name得到管理员对象
     * @param name
     * @return Map<"administrator",administrator>
     */
    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    private Map<String,Object> getByName(String name){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Administrator administrator = administratorService.getAdministratorByName(name);
        modelMap.put("administrator",administrator);
        return modelMap;
    }

    /**
     * 登录（通过服务消费者name和password判断是否可以成功登录）
     * @param name
     * @param pwd
     * @return Map<"success",int>(1 成功,0 失败)
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private Map<String,Object> login(String name,String pwd){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String password = administratorService.getPasswordByName(name);
        int success = (password.compareTo(pwd)==0 ?1:0);
        modelMap.put("success",success);
        return modelMap;
    }

    /**
     * 下架服务
     * @param administratorId
     * @param serviceId
     * @return Map<"message",Object>
     */
    @RequestMapping(value = "/deleteService", method = RequestMethod.GET)
    private Map<String, Object> deleteService(Integer administratorId,Integer serviceId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = administratorService.deleteService(administratorId,serviceId);
        if (result == 1) {
            modelMap.put("message", "下架服务成功");
        } else {
            modelMap.put("message", "下架服务失败");
        }
        return modelMap;
    }

    /**
     * 注销服务消费者账号
     * @param administratorId
     * @param consumerId
     * @return Map<"message",Object>
     */
    @RequestMapping(value = "/deleteConsumer", method = RequestMethod.GET)
    private Map<String, Object> deleteConsumer(Integer administratorId,Integer consumerId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = administratorService.deleteServiceConsumer(administratorId,consumerId);
        if (result == 1) {
            modelMap.put("message", "注销服务消费者账号成功");
        } else {
            modelMap.put("message", "注销服务消费者账号失败");
        }
        return modelMap;
    }

    /**
     * 注销服务提供者账号
     * @param administratorId
     * @param providerId
     * @return Map<"message",Object>
     */
    @RequestMapping(value = "/deleteProvider", method = RequestMethod.GET)
    private Map<String, Object> deleteProvider(Integer administratorId,Integer providerId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = administratorService.deleteServiceProvider(administratorId,providerId);
        if (result == 1) {
            modelMap.put("message", "注销服务提供者账号成功");
        } else {
            modelMap.put("message", "注销服务提供者账号失败");
        }
        return modelMap;
    }

}
