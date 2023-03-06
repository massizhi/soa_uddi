package com.mkx.soa.dao;

import com.mkx.soa.entity.ServiceBinding;

import java.util.List;

public interface ServiceBindingDao {
    //mybatis中的所有查询，都必须返回resultType或者resultMap的值

    /**
     * 增加新的服务绑定
     * @param serviceBinding
     * @return 是否成功
     */
    int insertServiceBinding(ServiceBinding serviceBinding);

    /**
     * 删除服务绑定
     * @param id
     * @return 是否成功
     */
    int deleteServiceBinding(Integer consumerId,Integer serviceId);

    /**
     * 返回全体服务绑定信息
     * @param
     * @return List<ServiceBinding>
     */
    List<ServiceBinding> queryServiceBinding();

    /**
     * 通过id得到服务绑定信息
     * @param id
     * @return ServiceBinding
     */
    ServiceBinding getServiceBindingById(Integer id);

    /**
     * 根据consumerId得到服务消费者绑定的服务的id的列表
     * @param consumerId
     * @return List<Integer>
     */
    List<Integer> getServiceBindingByConsumerId(Integer consumerId);

    /**
     * 根据serviceId得到使用该服务的消费者的id的列表
     * @param serviceId
     * @return List<Integer>
     */
    List<Integer> getServiceBindingByServiceId(Integer serviceId);

    /**
     * 根据serviceId得到使用该服务的消费者的数量
     * @param serviceId
     * @return int
     */
    int getConsumerNumber(Integer serviceId);
}
