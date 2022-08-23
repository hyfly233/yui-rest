package com.hyfly.yui.spring.config;

import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * @author hyfly
 */
@Configuration
@EnableConfigurationProperties(OkHttpProperties.class)
@Slf4j
public class RestTemplateConfig {

    @Autowired
    private OkHttpProperties okHttpProperties;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(okHttpClientHttpRequestFactory());
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        messageConverters.add(new GsonHttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }

    private ClientHttpRequestFactory okHttpClientHttpRequestFactory() {
        return new OkHttp3ClientHttpRequestFactory(okHttpConfigClient());
    }

    private OkHttpClient okHttpConfigClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .connectionPool(okHttpClientPool())
                .connectTimeout(okHttpProperties.getConnectTimeout(), okHttpProperties.getConnectTimeoutTimeUnit())
                .readTimeout(okHttpProperties.getReadTimeout(), okHttpProperties.getReadTimeoutTimeUnit())
                .writeTimeout(okHttpProperties.getWriteTimeout(), okHttpProperties.getWriteTimeoutTimeUnit())
                .hostnameVerifier((hostname, session) -> true);

        // https
        X509TrustManager trustManager;
        SSLContext sslContext;

        try {
            trustManager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());

            return builder.sslSocketFactory(sslContext.getSocketFactory(), trustManager)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return builder.build();
    }

    private ConnectionPool okHttpClientPool() {
        return new ConnectionPool(okHttpProperties.getMaxIdleConnections(), okHttpProperties.getKeepAliveDuration(), okHttpProperties.getKeepAliveDurationTimeUnit());
    }
}
