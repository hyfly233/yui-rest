package com.hyfly.yui.spring.domain;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@ToString
public class WithListPo {
    private String id;
    private List<String> strings;
    private InnerPo po;
    private List<InnerPo> pos;
}