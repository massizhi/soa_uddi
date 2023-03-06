package com.mkx.soa.service.impl;

import com.mkx.soa.dao.*;
import com.mkx.soa.entity.Administrator;
import com.mkx.soa.entity.Record;
import com.mkx.soa.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    private AdministratorDao administratorDao;
    @Autowired
    private ServiceConsumerDao serviceConsumerDao;
    @Autowired
    private ServiceProviderDao serviceProviderDao;
    @Autowired
    private ServiceDao serviceDao;
    @Autowired
    private RecordDao recordDao;

    @Override
    @Transactional
    public int updateAdministrator(Administrator administrator) {
        if (administrator.getId() != null) {
            try {
                int effectedNum = administratorDao.updateAdministrator(administrator);
                if (effectedNum > 0) {
                    return effectedNum;
                } else {
                    throw new RuntimeException("管理员ID已得到，但更新失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("管理员信息更新出现如下异常:" + e.toString());
            }
        } else {
            throw new RuntimeException("管理员ID为空");
        }
    }

    @Override
    public Administrator getAdministratorById(Integer id) {
        return administratorDao.getAdministratorById(id);
    }

    @Override
    public Administrator getAdministratorByName(String name) {
        return administratorDao.getAdministratorByName(name);
    }

    @Override
    public String getPasswordByName(String name) {
        return administratorDao.getPasswordByName(name);
    }

    @Override
    @Transactional
    public int deleteService(Integer administratorId, Integer serviceId) {
        if (administratorId != 0 && serviceId != 0) {
            try {
                Record record = new Record(administratorId,
                        serviceDao.getServiceById(serviceId).getName(),
                        "服务","下架");
                int effectedNum = recordDao.insertRecord(record);
                effectedNum *= serviceDao.deleteService(serviceId);
                if (effectedNum > 0) {
                    return effectedNum;
                } else {
                    throw new RuntimeException("删除失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("下架服务出现如下异常:" + e.toString());
            }
        } else {
            throw new RuntimeException("管理员ID或者服务ID为0");
        }
    }

    @Override
    @Transactional
    public int deleteServiceConsumer(Integer administratorId, Integer serviceConsumerId) {
        if (administratorId != 0 && serviceConsumerId != 0) {
            try {
                Record record = new Record(administratorId,
                        serviceConsumerDao.getServiceConsumerById(serviceConsumerId).getName(),
                        "服务消费者","注销账号");
                int effectedNum = recordDao.insertRecord(record);
                effectedNum *= serviceConsumerDao.deleteServiceConsumer(serviceConsumerId);
                if (effectedNum > 0) {
                    return effectedNum;
                } else {
                    throw new RuntimeException("删除失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("注销服务消费者账号出现如下异常:" + e.toString());
            }
        } else {
            throw new RuntimeException("管理员ID或者服务消费者ID为0");
        }
    }

    @Override
    @Transactional
    public int deleteServiceProvider(Integer administratorId, Integer serviceProviderId) {
        if (administratorId != 0 && serviceProviderId != 0) {
            try {
                Record record = new Record(administratorId,
                        serviceProviderDao.getServiceProviderById(serviceProviderId).getName(),
                        "服务提供者","注销账号");
                int effectedNum = recordDao.insertRecord(record);
                effectedNum *= serviceProviderDao.deleteServiceProvider(serviceProviderId);
                if (effectedNum > 0) {
                    return effectedNum;
                } else {
                    throw new RuntimeException("删除失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("注销服务提供者账号出现如下异常:" + e.toString());
            }
        } else {
            throw new RuntimeException("管理员ID或者服务提供者ID为0");
        }
    }
}
