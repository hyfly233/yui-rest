package com.hyfly.yui.spring.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.hyfly.yui.spring.annotation.CheckParam;
import com.hyfly.yui.spring.domain.CheckParamPo;
import com.hyfly.yui.spring.domain.TestPo;
import com.hyfly.yui.spring.domain.response.WithListPo;
import com.hyfly.yui.spring.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

    @CheckParam
    @Override
    public String checkParam(@CheckParam CheckParamPo po) {
        return po.toString();
    }

    @Override
    public String testGet() {

        String s = testGetUri.replace("{userId}", "hyfly");

        String url = "http://" + host + ":" + port + s;

        log.info("url: {}", url);

        // 创建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        List<MediaType> accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON);
        headers.setAccept(accept);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String jsonString = rt.getForObject(url, String.class, entity);

        log.info("jsonString: {}", jsonString);

//        TestUserPo userPo = JSONObject.parseObject(jsonString, TestUserPo.class);
//
//        log.info("userPo: {}", userPo);
//
//        assert userPo != null;
//        return userPo.toString();

        WithListPo withListPo = JSONObject.parseObject(jsonString, WithListPo.class);

        log.info("withListPo: {}", withListPo);

        return "";
    }

    @Override
    public String testPost() {
        String s = testPostUri.replace("{userId}", "hyfly");

        String url = "http://" + host + ":" + port + s;

        log.info("url: {}", url);

        // 创建请求头
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);

        // 创建请求体
        TestPo po = new TestPo();
        po.setId("hyfly");
        po.setName("hyfly233");
        po.setPassword("111111111112222222222222");

        String jsonData = JSONObject.toJSONString(po);


        HttpEntity<String> entity = new HttpEntity<>(jsonData, headers);


        String jsonString = rt.postForObject(url, entity, String.class);

        log.info("jsonString: {}", jsonString);

        TestPo userPo = JSONObject.parseObject(jsonString, TestPo.class);

        return jsonString;
    }
}
