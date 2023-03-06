package com.mkx.soa.dao;

import com.mkx.soa.entity.Administrator;

public interface AdministratorDao {
    //mybatis中的所有查询，都必须返回resultType或者resultMap的值

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
}
