package com.hyfly.yui.spring.service;

import com.hyfly.yui.spring.domain.CheckParamPo;
import com.hyfly.yui.spring.domain.SpringValidationPo;
import org.springframework.validation.annotation.Validated;

public interface TestService {

    String checkParam(CheckParamPo po);

    String testGet();

    String testPost();

}
