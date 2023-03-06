package com.mkx.soa.service.impl;

import com.mkx.soa.dao.ServiceProviderDao;
import com.mkx.soa.entity.ServiceProvider;
import com.mkx.soa.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceProviderServiceImpl implements ServiceProviderService {
    @Autowired
    private ServiceProviderDao serviceProviderDao;

    @Override
    public int insertServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderDao.insertServiceProvider(serviceProvider);
    }

    @Override
    public int deleteServiceProvider(Integer id) {
        return serviceProviderDao.deleteServiceProvider(id);
    }

    @Override
    @Transactional
    public int updateServiceProvider(ServiceProvider serviceProvider) {
        if (serviceProvider.getId() != null) {
            try {
                int effectedNum = serviceProviderDao.updateServiceProvider(serviceProvider);
                if (effectedNum > 0) {
                    return effectedNum;
                } else {
                    throw new RuntimeException("服务提供者ID已得到，但更新失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("服务提供者信息更新出现如下异常:" + e.toString());
            }
        } else {
            throw new RuntimeException("服务提供者ID为空");
        }
    }

    @Override
    public List<ServiceProvider> getServiceProviderList() {
        return serviceProviderDao.queryServiceProvider();
    }

    @Override
    public ServiceProvider getServiceProviderById(Integer id) {
        return serviceProviderDao.getServiceProviderById(id);
    }

    @Override
    public ServiceProvider getServiceProviderByName(String name) {
        return serviceProviderDao.getServiceProviderByName(name);
    }

    @Override
    public String getPasswordByName(String name) {
        return serviceProviderDao.getPasswordByName(name);
    }

    @Override
    public int getNumberByLocation(String location) {
        return serviceProviderDao.getNumberByLocation(location);
    }
}
