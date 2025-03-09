package com.example.springboot_test.repository;

import com.example.springboot_test.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {// 第一个变量是操作类型，第二个变量是主键的类型
}
