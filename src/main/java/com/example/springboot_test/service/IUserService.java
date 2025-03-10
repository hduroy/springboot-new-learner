package com.example.springboot_test.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.springboot_test.pojo.User;
import com.example.springboot_test.pojo.dto.UserDto;

public interface IUserService {
    /**
     * 添加用户
     * @param user 参数
     */
    User add(UserDto user);
    /**
     * 查询用户
     * @param id 用户id
     */
    User get(Integer id);
    /**
     * 更新用户
     * @param user 参数
     */
    User update(UserDto user);
    /**
     * 删除用户
     * @param id 用户id
     */
    void delete(Integer id);

    /*
     * find all
     * 
     */
    Iterable<User> findAll();
    /*
     * find all with page
     */
    Page<User> findAll(Pageable pageable);
}
