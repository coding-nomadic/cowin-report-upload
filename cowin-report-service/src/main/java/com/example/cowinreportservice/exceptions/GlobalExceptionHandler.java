package com.example.cowinreportservice.exceptions;

import com.example.cowinreportservice.dtos.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.Date;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        log.info(exception.getLocalizedMessage());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getLocalizedMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllException(Exception exception, WebRequest webRequest) {
        log.info(exception.getLocalizedMessage());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getLocalizedMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ReportJsonException.class)
    public ResponseEntity<ErrorDetails> handleBlogException(ReportJsonException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getLocalizedMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<ErrorDetails> handleMethodNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        log.info(exception.getLocalizedMessage());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getLocalizedMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorDetails> handleMaxSizeException(MaxUploadSizeExceededException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "File too large!", webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.EXPECTATION_FAILED);
    }
}
