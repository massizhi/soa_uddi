package com.mkx.soa.dao;

import com.mkx.soa.entity.Service;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceDaoTest {
    @Autowired
    private ServiceDao serviceDao;

    @Test
    @Ignore
    public void serviceTest() {
        Service service=new Service();
        service.setName("test+");
        service.setProviderId(1);

        serviceDao.insertService(service);

//        serviceDao.deleteService(3);

//        service.setProviderId(5);
//        service.setId(1);
//        service.setBriefInfo("Hello World!");
//        serviceDao.updateService(service);

//        System.out.println(serviceDao.getServiceById(1).getBriefInfo());
//        System.out.println(serviceDao.getServiceByName("st").size());
//        System.out.println(serviceDao.getServiceByProviderId(2).get(0).getName());
    }

}
