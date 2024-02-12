package com.example.login.google.dto;

import lombok.Getter;

@Getter
public class GoogleTokenResponse {

    private String access_token;

    private String expires_in;

    private String refresh_token;

    private String scope;

    private String token_type;

    private String id_token;
}
