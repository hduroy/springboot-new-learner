package com.example.springboot_test.pojo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseMessage<T> {
    private static final Logger log = LoggerFactory.getLogger(ResponseMessage.class);
    private int code;
    private String message;
    private T data;

    public ResponseMessage() {
    }

    public ResponseMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseMessage(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public ResponseMessage<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseMessage<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseMessage<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage<>(200, "success", data);
    }
    public static <T> ResponseMessage<T> deletesuccess() {
        return new ResponseMessage<>(201, "delete success");
    }


}
