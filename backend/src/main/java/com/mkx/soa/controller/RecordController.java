package com.mkx.soa.controller;

import com.mkx.soa.entity.Record;
import com.mkx.soa.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/record")
@CrossOrigin
public class RecordController {
    @Autowired
    private RecordService recordService;

    /**
     * 返回全体操作记录
     * @param
     * @return Map<"recordList",List<Record>>
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Map<String,Object> list(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Record> recordList = recordService.getRecordList();
        modelMap.put("recordList",recordList);
        return modelMap;
    }

    /**
     * 通过id得到记录对象
     * @param id
     * @return Map<"record",record>
     */
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    private Map<String,Object> getById(Integer id){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Record record = recordService.getRecordById(id);
        modelMap.put("record",record);
        return modelMap;
    }

    /**
     * 通过administratorId得到记录对象
     * @param adminId
     * @return @return Map<"recordList",List<Record>>
     */
    @RequestMapping(value = "/getListByAdminId", method = RequestMethod.GET)
    private Map<String,Object> getListByAdminId(Integer adminId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Record> recordList = recordService.getRecordByAdministratorId(adminId);
        modelMap.put("recordList",recordList);
        return modelMap;
    }

    /**
     * 通过administratorId和objectClass得到记录对象
     * @param administratorId,objectClass
     * @return @return Map<"recordList",List<Record>>
     */
    @RequestMapping(value = "/getListByObjectClass", method = RequestMethod.GET)
    private Map<String,Object> getListByObjectClass(Integer administratorId,String objectClass){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Record> recordList = recordService.getRecordByObjectClass(administratorId,objectClass);
        modelMap.put("recordList",recordList);
        return modelMap;
    }

    /**
     * 通过administratorId和objectName得到记录对象
     * @param administratorId,objectName
     * @return @return Map<"recordList",List<Record>>
     */
    @RequestMapping(value = "/getListByObjectName", method = RequestMethod.GET)
    private Map<String,Object> getListByObjectName(Integer administratorId,String objectName){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Record> recordList = recordService.getRecordByObjectName(administratorId,objectName);
        modelMap.put("recordList",recordList);
        return modelMap;
    }
}
