package com.mkx.soa.service;

import com.mkx.soa.entity.Record;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordServiceTest {
    @Autowired
    private RecordService recordService;

    @Test
    public void recordTest() {
        Record record=new Record();
        record.setAdministratorId(1);
        record.setObjectClass("服务提供者");
        record.setObjectName("不合规定的账号");
        record.setChoice("注销账号");

        System.out.println(recordService.getRecordList().size());
        System.out.println(recordService.getRecordById(1).getObjectName());
        System.out.println(recordService.getRecordByAdministratorId(1).size());
        System.out.println(recordService.getRecordByObjectClass(1,"服务").size());
        System.out.println(recordService.getRecordByObjectName(1,"外卖").size());
    }
}
