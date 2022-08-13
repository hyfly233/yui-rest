package com.hyfly.yui.okhttp;

import lombok.RequiredArgsConstructor;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * BaseAuth
 *
 * @author hyfly
 */
@RequiredArgsConstructor
public class BaseAuthenticator implements Authenticator {
    private final String userName;
    private final String password;

    @Override
    public Request authenticate(Route route, Response response) {
        String credential = Credentials.basic(userName, password, StandardCharsets.UTF_8);
        return response.request().newBuilder()
                .header("Authorization", credential)
                .build();
    }
}
