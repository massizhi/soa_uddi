package com.mkx.soa.service;

import com.mkx.soa.entity.Administrator;

public interface AdministratorService {
    /**
     * 更新管理员信息
     * @param administrator
     * @return 是否成功
     */
    int updateAdministrator(Administrator administrator);

    /**
     * 通过id得到管理员对象
     * @param id
     * @return administrator
     */
    Administrator getAdministratorById(Integer id);

    /**
     * 通过name得到管理员对象
     * @param name
     * @return administrator
     */
    Administrator getAdministratorByName(String name);

    /**
     * 通过管理员name得到管理员password
     * @param name
     * @return password
     */
    String getPasswordByName(String name);

    /**
     * 下架服务
     * @param administratorId
     * @param serviceId
     * @return 是否成功
     */
    int deleteService(Integer administratorId,Integer serviceId);

    /**
     * 注销服务消费者账号
     * @param administratorId
     * @param serviceConsumerId
     * @return 是否成功
     */
    int deleteServiceConsumer(Integer administratorId,Integer serviceConsumerId);

    /**
     * 注销服务提供者账号
     * @param administratorId
     * @param serviceProviderId
     * @return 是否成功
     */
    int deleteServiceProvider(Integer administratorId,Integer serviceProviderId);
}
