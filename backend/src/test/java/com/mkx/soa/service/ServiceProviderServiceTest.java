package com.mkx.soa.service;

import com.mkx.soa.entity.ServiceProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceProviderServiceTest {
    @Autowired
    private ServiceProviderService serviceProviderService;

    @Test
    public void serviceInfoServiceTest() {
        ServiceProvider serviceProvider=new ServiceProvider();
        serviceProvider.setName("test+");
        serviceProvider.setLocation("中国");
        serviceProvider.setPassword("pwd");


//        serviceProviderService.insertServiceProvider(serviceProvider);

//        serviceProviderService.deleteServiceProvider(5);

//        serviceProvider.setId(3);
//        serviceProviderService.updateServiceProvider(serviceProvider);

//        System.out.println(serviceProviderService.getServiceProviderList().size());
//        System.out.println(serviceProviderService.getNumberByLocation("中国"));
//        System.out.println(serviceProviderService.getPasswordByName("美团"));
//        System.out.println(serviceProviderService.getServiceProviderById(1).getName());
//        System.out.println(serviceProviderService.getServiceProviderByName("京东").getPassword());
    }
}