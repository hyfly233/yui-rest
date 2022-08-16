package com.hyfly.yui.spring.domain.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class WithListPo {
    private String id;
    private List<String> strings;
    private WithListPo.InnerPo po;
    private List<WithListPo.InnerPo> pos;

    @Data
    static class InnerPo {
        private String id;
        private String name;
        private String password;
    }
}