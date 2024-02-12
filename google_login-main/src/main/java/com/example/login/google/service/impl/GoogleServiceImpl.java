package com.example.login.google.service.impl;

import com.example.login.common.dto.ApiResponse;
import com.example.login.google.client.GoogleClient;
import com.example.login.google.dto.GoogleDetailRequest;
import com.example.login.google.dto.GoogleDetailResponse;
import com.example.login.google.dto.GoogleTokenRequest;
import com.example.login.google.dto.GoogleTokenResponse;
import com.example.login.google.service.GoogleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoogleServiceImpl implements GoogleService {

    @Value("${google.client.id}")
    private String googleClientId;

    @Value("${google.client.pw}")
    private String googleClientPassword;

    @Value("${google.login.url}")
    private String googleApiUrl;

    @Value("${google.redirect.url}")
    private String redirectUrl;

    private final GoogleClient googleClient;

    @Override
    public ApiResponse<String> getGoogleLoginView() {


        return ApiResponse.<String>builder()
                          .data(googleApiUrl + "client_id=" + googleClientId
                                        + "&redirect_uri=" + redirectUrl
                                        + "&response_type=code"
                                        + "&scope=email%20profile%20openid"
                                        + "&access_type=offline")
                          .message("google login view url입니다.")
                          .build();
    }

    @Override
    public ApiResponse<GoogleDetailResponse> loginGoogle(String code) {
        GoogleTokenResponse googleTokenResponse = googleClient.getGoogleToken(GoogleTokenRequest.builder()
                                                                                                .clientId(googleClientId)
                                                                                                .clientSecret(googleClientPassword)
                                                                                                .code(code)
                                                                                                .redirectUri("http://localhost:8080/api/v1/google/login")
                                                                                                .grantType("authorization_code")
                                                                                                .build());

        return ApiResponse.<GoogleDetailResponse>builder()
                          .data(googleClient.getGoogleDetailInfo(GoogleDetailRequest.builder()
                                                                                    .id_token(googleTokenResponse.getId_token())
                                                                                    .build()))
                          .message("google 계정 정보입니다.")
                          .build();
    }
}
