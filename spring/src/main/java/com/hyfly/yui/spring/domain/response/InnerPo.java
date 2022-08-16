package com.hyfly.yui.spring.domain.response;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString
public class InnerPo {
    private String id;
    private String name;
    private String password;
}