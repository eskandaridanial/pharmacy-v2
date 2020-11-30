package com.pharmacy.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class CustomErrorDetails {

    private final Long id;
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;

    public CustomErrorDetails(Long id , String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        this.id = id;
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}