package com.mkx.soa.service.impl;

import com.mkx.soa.dao.ServiceBindingDao;
import com.mkx.soa.entity.ServiceBinding;
import com.mkx.soa.service.ServiceBindingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceBindingServiceImpl implements ServiceBindingService {
    @Autowired
    private ServiceBindingDao serviceBindingDao;

    @Override
    public int insertServiceBinding(ServiceBinding serviceBinding) {
        return serviceBindingDao.insertServiceBinding(serviceBinding);
    }

    @Override
    public int deleteServiceBinding(Integer consumerId,Integer serviceId) {
        return serviceBindingDao.deleteServiceBinding(consumerId,serviceId);
    }

    @Override
    public List<ServiceBinding> getServiceBindingList() {
        return serviceBindingDao.queryServiceBinding();
    }

    @Override
    public ServiceBinding getServiceBindingById(Integer id) {
        return serviceBindingDao.getServiceBindingById(id);
    }

    @Override
    public List<Integer> getServiceBindingByConsumerId(Integer consumerId) {
        return serviceBindingDao.getServiceBindingByConsumerId(consumerId);
    }

    @Override
    public List<Integer> getServiceBindingByServiceId(Integer serviceId) {
        return serviceBindingDao.getServiceBindingByServiceId(serviceId);
    }

    @Override
    public int getConsumerNumber(Integer serviceId) {
        return serviceBindingDao.getConsumerNumber(serviceId);
    }
}
