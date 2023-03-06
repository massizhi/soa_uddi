package com.mkx.soa.service.impl;

import com.mkx.soa.dao.RecordDao;
import com.mkx.soa.entity.Record;
import com.mkx.soa.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;

    @Override
    public List<Record> getRecordList() {
        return recordDao.queryRecord();
    }

    @Override
    public Record getRecordById(Integer id) {
        return recordDao.getRecordById(id);
    }

    @Override
    public List<Record> getRecordByAdministratorId(Integer administratorId) {
        return recordDao.getRecordByAdministratorId(administratorId);
    }

    @Override
    public List<Record> getRecordByObjectClass(Integer administratorId, String objectClass) {
        return recordDao.getRecordByObjectClass(administratorId,objectClass);
    }

    @Override
    public List<Record> getRecordByObjectName(Integer administratorId, String objectName) {
        return recordDao.getRecordByObjectName(administratorId,objectName);
    }
}
