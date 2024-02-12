package com.example.login.common.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ApiResponse<T> {

    private T data;

    private String code;

    private String message;
}
