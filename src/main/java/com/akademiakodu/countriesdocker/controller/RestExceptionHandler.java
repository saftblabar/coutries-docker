package com.akademiakodu.countriesdocker.controller;
import com.akademiakodu.countriesdocker.model.APIError;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointer(NullPointerException ex) {
        APIError apiError = new APIError(HttpStatus.INTERNAL_SERVER_ERROR, "INVALID COUNTRY CODE");
        return buildResponseEntity(apiError);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException e) {
        APIError apiError = new APIError(HttpStatus.INTERNAL_SERVER_ERROR);
        return buildResponseEntity(apiError);
    }
    @ExceptionHandler(JDBCConnectionException.class)
    public ResponseEntity<Object> handleJDBCNotFound(JDBCConnectionException e) {
        APIError apiError = new APIError(HttpStatus.INTERNAL_SERVER_ERROR);
        return buildResponseEntity(apiError);
    }
    private ResponseEntity<Object> buildResponseEntity(APIError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
