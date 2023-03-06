package com.mkx.soa.service;

import com.mkx.soa.entity.Administrator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministratorServiceTest {
    @Autowired
    private AdministratorService administratorService;

    @Test
    public void administratorTest() {
        Administrator administrator=new Administrator();
        administrator.setName("test");
        administrator.setBriefInfo("Hello World too!");
        administrator.setUrl("www.massizhi.com");
        administrator.setPassword("password");//不能为空
        administrator.setId(2);

//        administratorService.updateAdministrator(administrator);

//        System.out.println(administratorService.getPasswordByName("test"));
//        System.out.println(administratorService.getAdministratorById(1).getBriefInfo());
//        System.out.println(administratorService.getAdministratorByName("test").getUrl());

        administratorService.deleteService(1,9);
        administratorService.deleteServiceConsumer(1,7);
        administratorService.deleteServiceProvider(1,6);
    }
}
