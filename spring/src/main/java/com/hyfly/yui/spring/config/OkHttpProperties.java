package com.hyfly.yui.spring.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.TimeUnit;

/**
 * @author hyfly
 */
@Data
@ConfigurationProperties(prefix = "okhttp.config")
public class OkHttpProperties {
    /**
     * 最大空闲连接数
     */
    private Integer maxIdleConnections = 30;
    /**
     * 连接持续时间
     */
    private Long keepAliveDuration = 300L;
    /**
     * 复用时间单位
     */
    private TimeUnit keepAliveDurationTimeUnit = TimeUnit.MINUTES;
    /**
     * 连接超时时间
     */
    private Long connectTimeout = 10L;
    /**
     * 连接超时时间单位
     */
    private TimeUnit connectTimeoutTimeUnit = TimeUnit.SECONDS;
    /**
     * 写超时时间
     */
    private Long writeTimeout = 10L;
    /**
     * 写超时时间单位
     */
    private TimeUnit writeTimeoutTimeUnit = TimeUnit.SECONDS;
    /**
     * 读超时时间
     */
    private Long readTimeout = 10L;
    /**
     * 读超时时间单位
     */
    private TimeUnit readTimeoutTimeUnit = TimeUnit.SECONDS;
    /**
     * 线程配置
     */
    private int corePoolSize = Runtime.getRuntime().availableProcessors();
    /**
     * 最大线程数
     */
    private int maxPoolSize = Runtime.getRuntime().availableProcessors() * 4;

}