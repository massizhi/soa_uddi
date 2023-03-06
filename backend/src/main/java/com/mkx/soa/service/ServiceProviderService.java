package com.mkx.soa.service;

import com.mkx.soa.entity.ServiceProvider;

import java.util.List;

public interface ServiceProviderService {
    /**
     * 增加新的服务提供者（注册）
     * @param serviceProvider
     * @return 是否成功
     */
    int insertServiceProvider(ServiceProvider serviceProvider);

    /**
     * 删除服务提供者（注销账号）
     * @param id
     * @return 是否成功
     */
    int deleteServiceProvider(Integer id);

    /**
     * 更新服务提供者信息
     * @param serviceProvider
     * @return 是否成功
     */
    int updateServiceProvider(ServiceProvider serviceProvider);

    /**
     * 返回全体服务提供者列表
     * @param
     * @return List<ServiceProvider>
     */
    List<ServiceProvider> getServiceProviderList();

    /**
     * 通过id得到服务提供者对象
     * @param id
     * @return ServiceProvider
     */
    ServiceProvider getServiceProviderById(Integer id);

    /**
     * 通过name得到服务提供者对象
     * @param name
     * @return ServiceProvider
     */
    ServiceProvider getServiceProviderByName(String name);

    /**
     * 通过服务提供者name得到服务提供者password
     * @param name
     * @return password
     */
    String getPasswordByName(String name);

    /**
     * 通过location得到该区域服务提供者的数量
     * @param location
     * @return providerNumberInThisLocation
     */
    int getNumberByLocation(String location);
}
