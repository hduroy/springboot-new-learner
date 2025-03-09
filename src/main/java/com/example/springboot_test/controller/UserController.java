package com.example.springboot_test.controller;

import com.example.springboot_test.pojo.dto.ResponseMessage;
import com.example.springboot_test.pojo.dto.UserDto;
import com.example.springboot_test.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.springboot_test.pojo.User;

@RestController //接口返回对象
@RequestMapping("/user") //localhost:8080/user/**
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    IUserService userService;

    //Restful风格 get post put delete
    //get:查询 post:新增 put:修改 delete:删除
    //增加
    @PostMapping
    public ResponseMessage<User> add(@Validated @RequestBody UserDto user){
        User usernew = userService.add(user);
        return ResponseMessage.success(usernew);
    }

    //查询
    @GetMapping("/{id}")
    public ResponseMessage<User> get(@PathVariable Integer id){
        User user = userService.get(id);
        return ResponseMessage.success(user);
    }

    //修改
    @PutMapping
    public ResponseMessage<User> update(@Validated @RequestBody UserDto user){
        User usernew = userService.update(user);
        return ResponseMessage.success(usernew);
    }

    //删除
    @DeleteMapping("/{id}")
    public ResponseMessage<User> delete(@PathVariable Integer id){
        userService.delete(id);
        return ResponseMessage.deletesuccess();
    }
}
