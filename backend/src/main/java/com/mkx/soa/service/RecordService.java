package com.mkx.soa.service;

import com.mkx.soa.entity.Record;

import java.util.List;

public interface RecordService {

    /**
     * 返回全体操作记录
     * @param
     * @return List<Record>
     */
    List<Record> getRecordList();

    /**
     * 通过id得到记录对象
     * @param id
     * @return List<Record>
     */
    Record getRecordById(Integer id);

    /**
     * 通过administratorId得到记录对象
     * @param administratorId
     * @return List<Record>
     */
    List<Record> getRecordByAdministratorId(Integer administratorId);

    /**
     * 通过administratorId和objectClass得到记录对象
     * @param administratorId,objectClass
     * @return List<Record>
     */
    List<Record> getRecordByObjectClass(Integer administratorId,String objectClass);

    /**
     * 通过administratorId和objectName得到记录对象
     * @param administratorId,objectName
     * @return List<Record>
     */
    List<Record> getRecordByObjectName(Integer administratorId,String objectName);
}
