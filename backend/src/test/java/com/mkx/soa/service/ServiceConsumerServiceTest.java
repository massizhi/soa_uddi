package com.mkx.soa.service;

import com.mkx.soa.entity.ServiceConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceConsumerServiceTest {
    @Autowired
    private ServiceConsumerService serviceConsumerService;

    @Test
    public void serviceConsumerTest() {
        ServiceConsumer serviceConsumer=new ServiceConsumer();
        serviceConsumer.setName("test+");
        serviceConsumer.setBriefInfo("Hello World!");
        serviceConsumer.setUrl("www.massizhi.com");
        serviceConsumer.setPassword("test");//不能为空

//        serviceConsumerService.insertServiceConsumer(serviceConsumer);

//        serviceConsumerService.deleteServiceConsumer(5);

//        serviceConsumer.setId(2);
//        serviceConsumer.setName("hhaha");
//        serviceConsumer.setBriefInfo("Hello!");
//        serviceConsumer.setPassword("test");
//        serviceConsumerService.updateServiceConsumer(serviceConsumer);

        System.out.println(serviceConsumerService.getServiceConsumerList().size());
        System.out.println(serviceConsumerService.getPasswordByName("test"));
        System.out.println(serviceConsumerService.getServiceConsumerById(2).getBriefInfo());
        System.out.println(serviceConsumerService.getServiceConsumerByName("test").getUrl());
    }
}
