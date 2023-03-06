package com.mkx.soa.entity;

public class Service {
    //服务id,主键，自增
    private Integer id;
    //服务名，非空
    private String name;
    //服务提供者id，非空
    private Integer providerId;
    //简介
    private String wsdl;
    //图片url
    private String pictureUrl;

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

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getWsdl() {
        return wsdl;
    }

    public void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
