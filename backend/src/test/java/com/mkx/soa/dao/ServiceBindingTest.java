package com.mkx.soa.dao;

import com.mkx.soa.entity.ServiceBinding;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceBindingTest {
    @Autowired
    private ServiceBindingDao serviceBindingDao;

    @Test
    public void serviceBindingTest() {
        ServiceBinding serviceBinding=new ServiceBinding();
        serviceBinding.setConsumerId(2);
        serviceBinding.setServiceId(1);
//        serviceBindingDao.insertServiceBinding(serviceBinding);

//        serviceBindingDao.deleteServiceBinding(3);

//        System.out.println(serviceBindingDao.queryServiceBinding().size());
//        System.out.println(serviceBindingDao.getConsumerNumber(1));
//        System.out.println(serviceBindingDao.getServiceBindingById(1).getConsumerId());
//        System.out.println(serviceBindingDao.getServiceBindingByConsumerId(1).get(1));
//        System.out.println(serviceBindingDao.getServiceBindingByServiceId(1).get(1));
    }
}
