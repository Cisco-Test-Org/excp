package com.cisco.test.excp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<Object> handleInvalidNameException(InvalidNameException exp) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", exp.getMessage());
        body.put("time-stamp", LocalDateTime.now());
        body.put("status", 1);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
