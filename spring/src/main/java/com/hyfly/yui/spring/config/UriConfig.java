package com.hyfly.yui.spring.config;

import lombok.Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author hyfly
 */
@Data
@Component
@PropertySource(value = {"classpath:uri.yml"}, factory = YamlPropertySourceFactory.class)
public class UriConfig {
    private String name;
}