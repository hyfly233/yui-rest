package com.hyfly.yui.spring.controller;

import com.hyfly.yui.spring.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/testGet")
    public String testGet() {
        return testService.testGet();
    }

    @PostMapping("/testPost")
    public String testPost() {
        return testService.testPost();
    }
}
