package com.mkx.soa.dao;

import com.mkx.soa.entity.ServiceConsumer;

import java.util.List;

public interface ServiceConsumerDao {
    //mybatis中的所有查询，都必须返回resultType或者resultMap的值

    /**
     * 增加新的服务消费者（注册）
     * @param serviceConsumer
     * @return 是否成功
     */
    int insertServiceConsumer(ServiceConsumer serviceConsumer);

    /**
     * 删除服务消费者（注销账号）
     * @param id
     * @return 是否成功
     */
    int deleteServiceConsumer(Integer id);

    /**
     * 更新服务消费者信息
     * @param serviceConsumer
     * @return 是否成功
     */
    int updateServiceConsumer(ServiceConsumer serviceConsumer);

    /**
     * 返回全体服务消费者列表
     * @param
     * @return List<serviceConsumer>
     */
    List<ServiceConsumer> queryServiceConsumer();

    /**
     * 通过id得到服务消费者对象
     * @param id
     * @return serviceConsumer
     */
    ServiceConsumer getServiceConsumerById(Integer id);

    /**
     * 通过name得到服务消费者对象
     * @param name
     * @return serviceConsumer
     */
    ServiceConsumer getServiceConsumerByName(String name);

    /**
     * 通过服务消费者name得到服务消费者password
     * @param name
     * @return password
     */
    String getPasswordByName(String name);
}
