package com.mkx.soa.controller;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.mkx.soa.entity.Service;
import com.mkx.soa.entity.ServiceBinding;
import com.mkx.soa.entity.ServiceConsumer;
import com.mkx.soa.entityPlus.ServiceDetailedInfo;
import com.mkx.soa.service.ServiceBindingService;
import com.mkx.soa.service.ServiceConsumerService;
import com.mkx.soa.service.ServiceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/serviceBinding")
@CrossOrigin
public class ServiceBindingController {
    @Autowired
    private ServiceBindingService serviceBindingService;
    @Autowired
    private ServiceConsumerService serviceConsumerService;
    @Autowired
    private ServiceInfoService serviceInfoService;

    /**
     * 增加新的服务绑定
     * @param serviceBinding
     * @return Map<"message",Object>
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private Map<String, Object> register(@RequestBody ServiceBinding serviceBinding) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = serviceBindingService.insertServiceBinding(serviceBinding);
        if (result == 1) {
            modelMap.put("message", "服务绑定成功");
        } else {
            modelMap.put("message", "服务绑定失败");
        }
        return modelMap;
    }

    /**
     * 删除服务绑定
     * @param consumerId
     * @param serviceId
     * @return Map<"message",Object>
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    private Map<String, Object> delete(Integer consumerId,Integer serviceId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = serviceBindingService.deleteServiceBinding(consumerId,serviceId);
        if (result == 1) {
            modelMap.put("message", "服务绑定解除成功");
        } else {
            modelMap.put("message", "服务绑定解除失败");
        }
        return modelMap;
    }

    /**
     * 返回全体服务绑定信息
     * @param
     * @return Map<"serviceBindingList",List<ServiceBinding>>
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Map<String,Object> list(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<ServiceBinding> serviceBindingList = serviceBindingService.getServiceBindingList();
        modelMap.put("serviceBindingList",serviceBindingList);
        return modelMap;
    }

    /**
     * 通过id得到服务绑定信息
     * @param id
     * @return Map<"serviceBinding",serviceBinding>
     */
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    private Map<String,Object> getById(Integer id){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ServiceBinding serviceBinding = serviceBindingService.getServiceBindingById(id);
        modelMap.put("serviceBinding",serviceBinding);
        return modelMap;
    }

    /**
     * 根据consumerId得到服务消费者绑定的服务的详细信息的列表
     * @param
     * @return Map<"serviceDetailedInfoList",List<ServiceDetailedInfo>>
     */
    @RequestMapping(value = "/getListByConsumerId", method = RequestMethod.GET)
    private Map<String,Object> getListByConsumerId(Integer consumerId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Integer> serviceIdList =
                serviceBindingService.getServiceBindingByConsumerId(consumerId);
        List<ServiceDetailedInfo> serviceDetailedInfoList = new ArrayList<>();
        for (Integer id:serviceIdList) {
            serviceDetailedInfoList.add(serviceInfoService.getServiceInfoById(id));
        }
        modelMap.put("serviceDetailedInfoList",serviceDetailedInfoList);
        return modelMap;
    }

    /**
     * 根据serviceId得到使用该服务的消费者的信息的列表
     * @param
     * @return Map<"serviceConsumerList",List<ServiceConsumer>>
     */
    @RequestMapping(value = "/getListByServiceId", method = RequestMethod.GET)
    private Map<String,Object> getListByServiceId(Integer serviceId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Integer> consumerIdList =
                serviceBindingService.getServiceBindingByServiceId(serviceId);
        List<ServiceConsumer> serviceConsumerList= new ArrayList<>();
        for (Integer id:consumerIdList) {
            serviceConsumerList.add(serviceConsumerService.getServiceConsumerById(id));
        }
        modelMap.put("serviceConsumerList",serviceConsumerList);
        return modelMap;
    }

    /**
     * 根据serviceId得到使用该服务的消费者的数量
     * @param serviceId
     * @return Map<"number",int>
     */
    @RequestMapping(value = "/getConsumerNumber", method = RequestMethod.GET)
    private Map<String,Object> getConsumerNumber(Integer serviceId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int number = serviceBindingService.getConsumerNumber(serviceId);
        modelMap.put("number",number);
        return modelMap;
    }
}
