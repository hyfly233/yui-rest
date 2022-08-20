package com.hyfly.yui.spring.service;

import com.hyfly.yui.spring.domain.CheckParamPo;

public interface TestService {

    String checkParam(String name, String age);

    String checkParam(CheckParamPo po);

    String testGet();

    String testPost();

}
