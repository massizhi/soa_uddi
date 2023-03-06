package com.mkx.soa.dao;

import com.mkx.soa.entity.Service;

import java.util.List;

public interface ServiceDao {
    //mybatis中的所有查询，都必须返回resultType或者resultMap的值

    /**
     * 增加新的服务
     * @param service
     * @return 是否成功
     */
    int insertService(Service service);

    /**
     * 删除具体服务
     * @param id
     * @return 是否成功
     */
    int deleteService(Integer id);

    /**
     * 更新具体服务
     * @param service
     * @return 是否成功
     */
    int updateService(Service service);

    /**
     * 返回全体服务列表
     * @param
     * @return List<Service>
     */
    List<Service> queryService();

    /**
     * 通过id得到服务对象
     * @param id
     * @return service
     */
    Service getServiceById(Integer id);

    /**
     * 通过名称得到服务对象列表（like）
     * @param name
     * @return List<Service>
     */
    List<Service> getServiceByName(String name);

    /**
     * 通过服务提供者id得到服务对象列表
     * @param providerId
     * @return List<Service>
     */
    List<Service> getServiceByProviderId(Integer providerId);
}
