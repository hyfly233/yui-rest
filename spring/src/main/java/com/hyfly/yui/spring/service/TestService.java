package com.hyfly.yui.spring.service;

import com.hyfly.yui.spring.annotation.CheckParam;

public interface TestService {
    @CheckParam("参数不能为空")
    String test2(String name, String age);

    String testGet();

    String testPost();
}
