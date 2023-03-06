package com.mkx.soa.service.impl;

import com.mkx.soa.dao.ServiceConsumerDao;
import com.mkx.soa.entity.ServiceConsumer;
import com.mkx.soa.service.ServiceConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceConsumerServiceImpl implements ServiceConsumerService {
    @Autowired
    private ServiceConsumerDao serviceConsumerDao;

    @Override
    public int insertServiceConsumer(ServiceConsumer serviceConsumer) {
        return serviceConsumerDao.insertServiceConsumer(serviceConsumer);
    }

    @Override
    public int deleteServiceConsumer(Integer id) {
        return serviceConsumerDao.deleteServiceConsumer(id);
    }

    @Override
    @Transactional
    public int updateServiceConsumer(ServiceConsumer serviceConsumer) {
        if (serviceConsumer.getId() != null) {
            try {
                int effectedNum = serviceConsumerDao.updateServiceConsumer(serviceConsumer);
                if (effectedNum > 0) {
                    return effectedNum;
                } else {
                    throw new RuntimeException("服务消费者ID已得到，但更新失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("服务消费者信息更新出现如下异常:" + e.toString());
            }
        } else {
            throw new RuntimeException("服务消费者ID为空");
        }
    }

    @Override
    public List<ServiceConsumer> getServiceConsumerList() {
        return serviceConsumerDao.queryServiceConsumer();
    }

    @Override
    public ServiceConsumer getServiceConsumerById(Integer id) {
        return serviceConsumerDao.getServiceConsumerById(id);
    }

    @Override
    public ServiceConsumer getServiceConsumerByName(String name) {
        return serviceConsumerDao.getServiceConsumerByName(name);
    }

    @Override
    public String getPasswordByName(String name) {
        return serviceConsumerDao.getPasswordByName(name);
    }
}
