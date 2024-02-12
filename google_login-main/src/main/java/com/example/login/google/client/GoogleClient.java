package com.example.login.google.client;

import com.example.login.google.dto.GoogleDetailRequest;
import com.example.login.google.dto.GoogleDetailResponse;
import com.example.login.google.dto.GoogleTokenRequest;
import com.example.login.google.dto.GoogleTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "google", url = "${google.auth.url}")
public interface GoogleClient {

    @PostMapping("/token")
    GoogleTokenResponse getGoogleToken(GoogleTokenRequest googleTokenRequest);

    @PostMapping("/tokeninfo")
    GoogleDetailResponse getGoogleDetailInfo(GoogleDetailRequest googleDetailRequest);
}
