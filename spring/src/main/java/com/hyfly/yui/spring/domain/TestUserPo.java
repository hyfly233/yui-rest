package com.hyfly.yui.spring.domain;

import com.alibaba.fastjson2.annotation.JSONField;

import java.io.Serial;
import java.io.Serializable;

public class TestUserPo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1582941630439552458L;

    @JSONField(name = "test_id")
    protected String id;

    @JSONField(name = "test_name")
    protected String name;

    @JSONField(name = "test_password")
    protected String password;

    public String getId() {
        return id;
    }

//    @JSONField(name = "test_id")
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

//    @JSONField(name = "test_name")
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

//    @JSONField(name = "test_password")
    public void setPassword(String password) {
        this.password = password;
    }
}
