package com.hyfly.yui.spring.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@ToString
public class CheckParamPo {

    @NotBlank
    String name;

    @Size(min = 1, max = 100)
    Integer age;
}
