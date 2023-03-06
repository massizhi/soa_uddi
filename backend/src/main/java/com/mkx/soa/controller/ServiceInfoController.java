package com.mkx.soa.controller;

import com.mkx.soa.entity.Service;
import com.mkx.soa.entityPlus.ServiceDetailedInfo;
import com.mkx.soa.service.ServiceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/service")
@CrossOrigin
public class ServiceInfoController {
    @Autowired
    private ServiceInfoService serviceInfoService;

    /**
     * 服务注册
     * @param service (name providerId...)
     * @return Map<"message",String>
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private Map<String, Object> register(@RequestBody Service service) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = serviceInfoService.insertService(service);
        if (result == 1) {
            modelMap.put("message", "服务注册成功");
        } else {
            modelMap.put("message", "服务注册失败");
        }
        return modelMap;
    }

    /**
     * 服务删除
     * @param id
     * @return Map<"message",String>
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    private Map<String, Object> delete(Integer id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = serviceInfoService.deleteService(id);
        if (result == 1) {
            modelMap.put("message", "服务删除成功");
        } else {
            modelMap.put("message", "服务删除失败");
        }
        return modelMap;
    }

    /**
     * 服务更新
     * @param service (id wsdl...)
     * @return Map<"message",String>
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    private Map<String, Object> update(@RequestBody Service service) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = serviceInfoService.updateService(service);
        if (result == 1) {
            modelMap.put("message", "服务更新成功");
        } else {
            modelMap.put("message", "服务更新失败");
        }
        return modelMap;
    }

    /**
     * 获取所有服务详细信息（包括服务提供者信息）列表
     * @param
     * @return Map<"serviceInfoList",List<ServiceDetailedInfo>>
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Map<String,Object> list(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<ServiceDetailedInfo> serviceDetailedInfoList = serviceInfoService.getServiceDetailedInfoList();
        modelMap.put("serviceInfoList",serviceDetailedInfoList);
        return modelMap;
    }

    /**
     * 通过id得到服务对象详细信息（包括服务提供商信息）
     * @param id
     * @return Map<"serviceInfo",serviceDetailedInfo>
     */
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    private Map<String,Object> getById(Integer id){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ServiceDetailedInfo serviceDetailedInfo = serviceInfoService.getServiceInfoById(id);
        modelMap.put("serviceInfo",serviceDetailedInfo);
        return modelMap;
    }

    /**
     * 通过名称得到服务对象详细信息（包括服务提供商信息）的列表（like）
     * @param name
     * @return Map<"serviceInfoList",List<ServiceDetailedInfo>>
     */
    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    private Map<String,Object> getByName(String name){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<ServiceDetailedInfo> serviceDetailedInfoList = serviceInfoService.getServiceInfoByName(name);
        modelMap.put("serviceInfoList",serviceDetailedInfoList);
        return modelMap;
    }

    /**
     * 通过服务提供者id得到服务对象详细信息（包括服务提供商信息）的列表
     * @param providerId
     * @return Map<"serviceInfoList",List<ServiceDetailedInfo>>
     */
    @RequestMapping(value = "/getListByProviderId", method = RequestMethod.GET)
    private Map<String,Object> getListByProviderId(Integer providerId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<ServiceDetailedInfo> serviceDetailedInfoList = serviceInfoService.getServiceInfoByProviderId(providerId);
        modelMap.put("serviceInfoList",serviceDetailedInfoList);
        return modelMap;
    }
}