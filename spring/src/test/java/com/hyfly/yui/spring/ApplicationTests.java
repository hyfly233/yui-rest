package com.hyfly.yui.spring;

import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testRestTemplate() {
        String url = "https://www.baidu.com";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
    }

    @Test
    void testLocalhost() {
        String url = "http://192.168.0.102:8080";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
    }


    @Test
    void testToJsonField() {
        TestUserPo po = TestUserPo.builder().id("1").name("hyfly").password("123456").build();

        String jsonData = JSONObject.toJSONString(po);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(jsonData, httpHeaders);

        String s = restTemplate.postForObject("http://192.168.0.102:8080/json", entity, String.class);
        System.out.println(s);
    }

}
