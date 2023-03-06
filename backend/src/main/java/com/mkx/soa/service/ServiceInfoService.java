package com.mkx.soa.service;

import com.mkx.soa.entity.Service;
import com.mkx.soa.entityPlus.ServiceDetailedInfo;

import java.util.List;

public interface ServiceInfoService {
    /**
     * 增加新的服务
     * @param service
     * @return 是否成功(可以用不同数字反映不同的错误原因)
     */
    int insertService(Service service);

    /**
     * 删除具体服务
     * @param id
     * @return 是否成功(可以用不同数字反映不同的错误原因)
     */
    int deleteService(Integer id);

    /**
     * 更新具体服务
     * @param service
     * @return 是否成功(可以用不同数字反映不同的错误原因)
     */
    int updateService(Service service);

    /**
     * 返回全体服务详细信息（包括服务提供商信息）的列表
     * @param
     * @return List<ServiceDetailedInfo>
     */
    List<ServiceDetailedInfo> getServiceDetailedInfoList();

    /**
     * 通过id得到服务对象详细信息（包括服务提供商信息）
     * @param id
     * @return ServiceDetailedInfo
     */
    ServiceDetailedInfo getServiceInfoById(Integer id);

    /**
     * 通过名称得到服务对象详细信息（包括服务提供商信息）的列表（like）
     * @param name
     * @return List<ServiceDetailedInfo>
     */
    List<ServiceDetailedInfo> getServiceInfoByName(String name);

    /**
     * 通过服务提供者id得到服务对象详细信息（包括服务提供商信息）的列表
     * @param providerId
     * @return List<ServiceDetailedInfo>
     */
    List<ServiceDetailedInfo> getServiceInfoByProviderId(Integer providerId);
}
