package com.mkx.soa.service.impl;

import com.mkx.soa.dao.ServiceDao;
import com.mkx.soa.dao.ServiceProviderDao;
import com.mkx.soa.entity.Service;
import com.mkx.soa.entity.ServiceProvider;
import com.mkx.soa.entityPlus.ServiceDetailedInfo;
import com.mkx.soa.service.ServiceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceInfoServiceImpl implements ServiceInfoService {
    @Autowired
    private ServiceDao serviceDao;
    @Autowired
    private ServiceProviderDao serviceProviderDao;

    @Override
    public int insertService(Service service) {
        return serviceDao.insertService(service);
    }

    @Override
    public int deleteService(Integer id) {
        return serviceDao.deleteService(id);
    }

    @Transactional
    @Override
    public int updateService(Service service) {
        if (service.getId() != null) {
            try {
                int effectedNum = serviceDao.updateService(service);
                if (effectedNum > 0) {
                    return effectedNum;
                } else {
                    throw new RuntimeException("服务ID已得到，但更新失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("服务信息更新出现如下异常:" + e.toString());
            }
        } else {
            throw new RuntimeException("服务ID为空");
        }
    }

    @Override
    public List<ServiceDetailedInfo> getServiceDetailedInfoList() {
        List<ServiceDetailedInfo> serviceDetailedInfoList = new ArrayList<ServiceDetailedInfo>();
        List<Service> serviceList = serviceDao.queryService();
        for (int i = 0; i < serviceList.size(); i++) {
            Service service = serviceList.get(i);
            ServiceProvider serviceProvider = serviceProviderDao.getServiceProviderById(service.getProviderId());
            ServiceDetailedInfo serviceDetailedInfo = new ServiceDetailedInfo(service.getId(),
                    service.getName(),service.getProviderId(),service.getWsdl(),service.getPictureUrl(),
                    serviceProvider.getName(),serviceProvider.getLocation(),
                    serviceProvider.getBriefInfo(),serviceProvider.getUrl());
            serviceDetailedInfoList.add(serviceDetailedInfo);
        }
        return serviceDetailedInfoList;
    }

    @Override
    public ServiceDetailedInfo getServiceInfoById(Integer id) {
        Service service = serviceDao.getServiceById(id);
        ServiceProvider serviceProvider = serviceProviderDao.getServiceProviderById(service.getProviderId());
        ServiceDetailedInfo serviceDetailedInfo = new ServiceDetailedInfo(service.getId(),
                service.getName(),service.getProviderId(),service.getWsdl(),service.getPictureUrl(),
                serviceProvider.getName(),serviceProvider.getLocation(),
                serviceProvider.getBriefInfo(),serviceProvider.getUrl());
        return serviceDetailedInfo;
    }

    @Override
    public List<ServiceDetailedInfo> getServiceInfoByName(String name) {
        List<ServiceDetailedInfo> serviceDetailedInfoList = new ArrayList<ServiceDetailedInfo>();
        List<Service> serviceList = serviceDao.getServiceByName(name);
        for (int i = 0; i < serviceList.size(); i++) {
            Service service = serviceList.get(i);
            ServiceProvider serviceProvider = serviceProviderDao.getServiceProviderById(service.getProviderId());
            ServiceDetailedInfo serviceDetailedInfo = new ServiceDetailedInfo(service.getId(),
                    service.getName(),service.getProviderId(),service.getWsdl(),service.getPictureUrl(),
                    serviceProvider.getName(),serviceProvider.getLocation(),
                    serviceProvider.getBriefInfo(),serviceProvider.getUrl());
            serviceDetailedInfoList.add(serviceDetailedInfo);
        }
        return serviceDetailedInfoList;
    }

    @Override
    public List<ServiceDetailedInfo> getServiceInfoByProviderId(Integer providerId) {
        List<ServiceDetailedInfo> serviceDetailedInfoList = new ArrayList<ServiceDetailedInfo>();
        List<Service> serviceList = serviceDao.getServiceByProviderId(providerId);
        for (int i = 0; i < serviceList.size(); i++) {
            Service service = serviceList.get(i);
            ServiceProvider serviceProvider = serviceProviderDao.getServiceProviderById(providerId);
            ServiceDetailedInfo serviceDetailedInfo = new ServiceDetailedInfo(service.getId(),
                    service.getName(),service.getProviderId(),service.getWsdl(),service.getPictureUrl(),
                    serviceProvider.getName(),serviceProvider.getLocation(),
                    serviceProvider.getBriefInfo(),serviceProvider.getUrl());
            serviceDetailedInfoList.add(serviceDetailedInfo);
        }
        return serviceDetailedInfoList;
    }
}
