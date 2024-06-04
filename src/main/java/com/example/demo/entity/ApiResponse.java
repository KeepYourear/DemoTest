package com.example.demo.entity;

import lombok.Data;

@Data
public class ApiResponse {
    private Integer code;
    private String message;
    private Object data;
    public ApiResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public ApiResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

}
