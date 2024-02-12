package com.example.login.google.controller;

import com.example.login.common.dto.ApiResponse;
import com.example.login.google.dto.GoogleDetailResponse;
import com.example.login.google.service.GoogleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/google")
@RequiredArgsConstructor
public class GoogleController {

    private final GoogleService googleService;

    @GetMapping("/login-view")
    public ResponseEntity<ApiResponse<String>> getGoogleLoginView(){
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                             .body(googleService.getGoogleLoginView());
    }

    @GetMapping("/login")
    public ResponseEntity<ApiResponse<GoogleDetailResponse>> selectGoogleLoginInfo(@RequestParam(value = "code") String code){
        return ResponseEntity.status(HttpStatus.OK)
                .body(googleService.loginGoogle(code));
    }
}
