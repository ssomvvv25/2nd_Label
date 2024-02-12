package com.example.login.google.service;

import com.example.login.common.dto.ApiResponse;
import com.example.login.google.dto.GoogleDetailResponse;

public interface GoogleService {

    ApiResponse<String> getGoogleLoginView();

    ApiResponse<GoogleDetailResponse> loginGoogle(String code);
}
