package com.mkx.soa.dao;

import com.mkx.soa.entity.ServiceProvider;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceProviderDaoTest {
    @Autowired
    private ServiceProviderDao serviceProviderDao;

    @Test
    public void serviceProviderTest() {
        ServiceProvider serviceProvider=new ServiceProvider();
        serviceProvider.setName("test+");
        serviceProvider.setBriefInfo("Hello World!");
        serviceProvider.setPassword("test+");//不能为空
        serviceProvider.setLocation("中国");//不能为空

//        serviceProviderDao.insertServiceProvider(serviceProvider);

//        serviceProviderDao.deleteServiceProvider(4);

//        serviceProvider.setId(3);
//        serviceProvider.setName("hhaha");
//        serviceProvider.setBriefInfo("Hello World!!!");
//        serviceProvider.setPassword("new password");
//        serviceProviderDao.updateServiceProvider(serviceProvider);

        System.out.println(serviceProviderDao.getNumberByLocation("中国"));
        System.out.println(serviceProviderDao.queryServiceProvider().size());
        System.out.println(serviceProviderDao.getPasswordByName("美团"));
        System.out.println(serviceProviderDao.getServiceProviderById(1).getName());
        System.out.println(serviceProviderDao.getServiceProviderByName("京东").getId());
    }
}
