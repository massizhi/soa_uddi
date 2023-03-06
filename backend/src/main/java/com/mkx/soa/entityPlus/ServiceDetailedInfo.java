package com.mkx.soa.entityPlus;

public class ServiceDetailedInfo {
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

    public ServiceDetailedInfo(Integer id, String name, Integer providerId, String wsdl,
                               String pictureUrl, String providerName, String providerLocation,
                               String providerBriefInfo, String providerUrl) {
        this.id = id;
        this.name = name;
        this.providerId = providerId;
        this.wsdl = wsdl;
        this.pictureUrl = pictureUrl;
        this.providerName = providerName;
        this.providerLocation = providerLocation;
        this.providerBriefInfo = providerBriefInfo;
        this.providerUrl = providerUrl;
    }

    public ServiceDetailedInfo() { }

    //服务提供者名称，唯一键，禁止重复！非空
    private String providerName;
    //服务提供者所在地，非空（需添加默认：中国）
    private String providerLocation;
    //简介
    private String providerBriefInfo;
    //官网链接（非必须）（也可以是别的介绍链接，都行）
    private String providerUrl;

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

    public String getWsdl() {
        return wsdl;
    }

    public void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderLocation() {
        return providerLocation;
    }

    public void setProviderLocation(String providerLocation) {
        this.providerLocation = providerLocation;
    }

    public String getProviderBriefInfo() {
        return providerBriefInfo;
    }

    public void setProviderBriefInfo(String providerBriefInfo) {
        this.providerBriefInfo = providerBriefInfo;
    }

    public String getProviderUrl() {
        return providerUrl;
    }

    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }
}
