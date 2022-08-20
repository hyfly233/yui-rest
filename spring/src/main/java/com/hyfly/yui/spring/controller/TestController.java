package com.hyfly.yui.spring.controller;

import com.hyfly.yui.spring.domain.SpringValidationPo;
import com.hyfly.yui.spring.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping("/springValidation")
    public void springValidation(@Validated SpringValidationPo po) {
        
    }
}
