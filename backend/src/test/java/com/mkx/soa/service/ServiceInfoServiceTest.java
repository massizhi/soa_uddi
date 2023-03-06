package com.mkx.soa.service;

import com.mkx.soa.entity.Service;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceInfoServiceTest {
    @Autowired
    private ServiceInfoService serviceInfoService;

    @Test
    public void serviceInfoServiceTest() {
        Service service=new Service();
        service.setName("test");
        service.setProviderId(1);
        service.setId(4);

//        serviceInfoService.insertService(service);

//        serviceInfoService.deleteService(5);

//        serviceInfoService.updateService(service);

//        System.out.println(serviceInfoService.getServiceDetailedInfoList().get(0).getProviderName());
//        System.out.println(serviceInfoService.getServiceInfoById(1).getName());
//        System.out.println(serviceInfoService.getServiceInfoByName("外卖").get(0).getProviderName());
        System.out.println(serviceInfoService.getServiceInfoByProviderId(1).get(0).getProviderName());
    }
}
