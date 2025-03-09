package com.example.springboot_test.exception;

import com.example.springboot_test.pojo.dto.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

  Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(CustomException.class)
  public ResponseMessage<Object> handleCustomException(CustomException ex) {
    log.error("CustomException: {}", ex.getMessage());
    return new ResponseMessage<>(ex.getCode(), ex.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseMessage<Object> handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
    log.error("Exception: {}", ex.getMessage());
    return new ResponseMessage<>(500, "Internal Server Error", null);
  }
}