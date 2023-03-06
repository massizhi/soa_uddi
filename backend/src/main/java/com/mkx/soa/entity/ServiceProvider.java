package com.mkx.soa.entity;

public class ServiceProvider {
    //服务提供者id,主键，自增
    private Integer id;
    //服务提供者名称，唯一键，禁止重复！非空
    private String name;
    //服务提供者所在地，非空（需添加默认：中国）
    private String location;
    //简介
    private String briefInfo;
    //官网链接（非必须）（也可以是别的介绍链接，都行）
    private String url;
    //服务提供者密码，非空
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
