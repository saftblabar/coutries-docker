package com.akademiakodu.countriesdocker.model;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class APIError {
    private HttpStatus status;
    private LocalDateTime localDateTime;
    private String message;

    public APIError() {

    }

    public APIError(HttpStatus status) {
        this.localDateTime = LocalDateTime.now();
        this.status = status;
    }
    public APIError(HttpStatus status, String message) {
        this.localDateTime = LocalDateTime.now();
        this.status = status;
        this.message = message;
    }
    public APIError(HttpStatus status, Throwable ex) {
        this.localDateTime = LocalDateTime.now();
        this.status = status;
        this.message = "Unexpected Error";
    }
    public HttpStatus getStatus() {
        return status;
    }
}
