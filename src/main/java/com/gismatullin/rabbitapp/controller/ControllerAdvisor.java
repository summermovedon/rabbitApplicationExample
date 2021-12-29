package com.gismatullin.rabbitapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice(basePackages = "com.gismatullin.rabbitapp")
public class ControllerAdvisor {

    private final Logger LOGGER = LogManager.getLogger();
    
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(Exception e, WebRequest request) {
        LOGGER.error(String.format("%s is happened : %s, webrequest : %s", 
            e.getClass().getCanonicalName(), e.getMessage(), request));
        return ResponseEntity.badRequest().build();
    }
    
}
