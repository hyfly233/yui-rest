package com.hyfly.yui.spring;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class TestUserPo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1582941630439552458L;

    @JSONField(name = "test_id")
    protected String id;

    @JSONField(name = "test_name")
    protected String name;

    @JSONField(name = "test_password")
    protected String password;
}