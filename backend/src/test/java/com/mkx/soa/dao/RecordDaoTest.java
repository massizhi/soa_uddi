package com.mkx.soa.dao;

import com.mkx.soa.entity.Record;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordDaoTest {
    @Autowired
    private RecordDao recordDao;

    @Test
    public void recordTest() {
        Record record=new Record();
        record.setAdministratorId(1);
        record.setObjectClass("服务提供者");
        record.setObjectName("不合规定的账号");
        record.setChoice("注销账号");

//        recordDao.insertRecord(record);

        System.out.println(recordDao.queryRecord().size());
        System.out.println(recordDao.getRecordById(1).getObjectName());
        System.out.println(recordDao.getRecordByAdministratorId(1).size());
        System.out.println(recordDao.getRecordByObjectClass(1,"服务").size());
        System.out.println(recordDao.getRecordByObjectName(1,"外卖").size());
    }
}
