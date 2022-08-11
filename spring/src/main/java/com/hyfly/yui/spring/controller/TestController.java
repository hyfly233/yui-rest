package com.hyfly.yui.spring.controller;

import com.alibaba.fastjson2.JSON;
import com.hyfly.yui.spring.domain.TestUserPo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TestController {

    @PostMapping("/json")
    public void test(@RequestBody String jsonParam) {

        TestUserPo po = JSON.parseObject(jsonParam, TestUserPo.class);
        System.out.println(po);
        System.out.println("123123");
    }
}
