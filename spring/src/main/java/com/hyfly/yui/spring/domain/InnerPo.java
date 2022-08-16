package com.hyfly.yui.spring.domain;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@ToString
public class InnerPo {
    private String id;
    private String name;
    private String password;
}