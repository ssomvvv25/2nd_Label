package com.example.login.google.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GoogleDetailRequest {

    private String id_token;
}
