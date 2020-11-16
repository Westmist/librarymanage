package com.lcc.library.entity;


/**
 *  uid 用户ID 主键
 *  name 用户名 默认值 unknow
 *  password 密码 32位 MD5加密
 *  cid 卡号  唯一  不为空
 */
public class Student {
    private Integer uid;
    private String name;
    private String password;
    private Integer cid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
