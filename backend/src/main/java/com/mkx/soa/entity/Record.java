package com.mkx.soa.entity;

public class Record {
    //id,主键，自增
    private Integer id;
    //管理员id,必须
    private Integer administratorId;
    //操作对象名称，如：天气，testName
    private String objectName;
    //操作对象类别，含有：1.服务 2.服务消费者 3.服务提供者
    private String objectClass;
    //操作选择，含有：1.下架 2.注销账号
    private String choice;

    public Record(Integer administratorId, String objectName, String objectClass, String choice) {
        this.administratorId = administratorId;
        this.objectName = objectName;
        this.objectClass = objectClass;
        this.choice = choice;
    }

    public Record() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectClass() {
        return objectClass;
    }

    public void setObjectClass(String objectClass) {
        this.objectClass = objectClass;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}
