package com.hyfly.yui.spring.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.hyfly.yui.spring.domain.TestUserPo;
import com.hyfly.yui.spring.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestServiceImpl implements TestService {

    @Value("${test.host}")
    private String host;

    @Value("${test.port}")
    private int port;

    @Value("${uri.test.get}")
    private String testGetUri;

    @Value("${uri.test.post}")
    private String testPostUri;

    @Autowired
    private RestTemplate rt;

    @Override
    public String testGet() {

        String s = testGetUri.replace("{userId}", "hyfly");

        String url = "http://" + host + ":" + port + s;

        String jsonString = rt.getForObject(url, String.class);

        TestUserPo userPo = JSONObject.parseObject(jsonString, TestUserPo.class);

        assert userPo != null;
        return userPo.toString();
    }

    @Override
    public String testPost() {
        return null;
    }
}
