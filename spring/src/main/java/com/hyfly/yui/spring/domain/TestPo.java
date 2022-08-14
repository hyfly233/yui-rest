package com.hyfly.yui.spring.domain;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class TestPo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1582941630439552458L;

    protected String id;

    protected String name;

    protected String password;
}
