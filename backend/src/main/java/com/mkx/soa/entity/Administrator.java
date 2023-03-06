package com.mkx.soa.entity;

public class Administrator {
    //管理员id,主键，自增
    private Integer id;
    //管理员名称，唯一键，禁止重复！非空
    private String name;
    //管理员简介
    private String briefInfo;
    //头像链接（非必须）
    private String url;
    //管理员密码，非空
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
