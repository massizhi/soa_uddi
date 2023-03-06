package com.mkx.soa.dao;

import com.mkx.soa.entity.ServiceConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceConsumerTest {
    @Autowired
    private ServiceConsumerDao serviceConsumerDao;

    @Test
    public void serviceConsumerTest() {
        ServiceConsumer serviceConsumer=new ServiceConsumer();
        serviceConsumer.setName("test+");
        serviceConsumer.setBriefInfo("Hello World!");
        serviceConsumer.setUrl("www.massizhi.com");
        serviceConsumer.setPassword("test");//不能为空

//        serviceConsumerDao.insertServiceConsumer(serviceConsumer);

//        serviceConsumerDao.deleteServiceConsumer(4);

//        serviceConsumer.setId(2);
//        serviceConsumer.setName("hhaha");
//        serviceConsumer.setBriefInfo("Hello World!!!");
//        serviceConsumer.setPassword("new password");
//        serviceConsumerDao.updateServiceConsumer(serviceConsumer);

//        System.out.println(serviceConsumerDao.queryServiceConsumer().size());
//        System.out.println(serviceConsumerDao.getPasswordByName("test"));
//        System.out.println(serviceConsumerDao.getServiceConsumerById(2).getBriefInfo());
//        System.out.println(serviceConsumerDao.getServiceConsumerByName("test").getUrl());
    }
}
