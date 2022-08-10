package com.hyfly.yui.spring;

import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

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
    void testToJsonField() {
        TestUserPo po = TestUserPo.builder().id("1").name("hyfly").password("123456").build();

        System.out.println(JSONObject.toJSONString(po));
    }

}
