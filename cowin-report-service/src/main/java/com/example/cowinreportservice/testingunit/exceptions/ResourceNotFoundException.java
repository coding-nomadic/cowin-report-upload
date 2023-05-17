package com.example.cowinreportservice.testingunit.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String message;
    private String errorCode;

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String message, String errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}