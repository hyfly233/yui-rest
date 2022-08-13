package com.hyfly.yui.okhttp;

import lombok.extern.slf4j.Slf4j;
import okhttp3.logging.HttpLoggingInterceptor;

@Slf4j
public class Slf4jLogger implements HttpLoggingInterceptor.Logger {

    public static final HttpLoggingInterceptor.Logger INSTANCE = new Slf4jLogger();

    public void log(String message) {
        log.info(message);
    }
}
