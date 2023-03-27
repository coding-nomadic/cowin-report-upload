package com.example.cowinreportservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class ReportJsonException extends RuntimeException {
    private String message;
    private String errorCode;

    public ReportJsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReportJsonException(String message, String errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}