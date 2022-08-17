package com.hyfly.yui.spring.controller;

import com.hyfly.yui.spring.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test")
    public String test() {
        return testService.test2(null, "");
    }


}
