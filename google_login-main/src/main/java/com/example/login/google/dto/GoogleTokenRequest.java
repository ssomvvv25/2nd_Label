package com.example.login.google.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GoogleTokenRequest {

    private String clientId;

    private String redirectUri;

    private String clientSecret;

    private String responseType;

    private String scope;

    private String code;

    private String accessType;

    private String grantType;

    private String state;

    private String includeGrantedScopes;

    private String loginHint;

    private String prompt;
}
