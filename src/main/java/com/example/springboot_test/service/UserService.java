package com.example.springboot_test.service;

import com.example.springboot_test.pojo.User;
import com.example.springboot_test.pojo.dto.UserDto;
import com.example.springboot_test.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 标注为服务类 配置成spring的bean
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(UserDto user) {

        User user_tmp = new User();
        BeanUtils.copyProperties(user, user_tmp);
        return userRepository.save(user_tmp);

    }

    @Override
    public User get(Integer id) {
//        return userRepository.findById(id).orElse(null);
        return userRepository.findById(id).orElseThrow(() -> {
            try {
                throw new IllegalAccessException("用户不存在");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

    }

    @Override
    public User update(UserDto user) {
        User user_tmp = new User();
        BeanUtils.copyProperties(user, user_tmp);
        return userRepository.save(user_tmp);
    }

    @Override
    public void delete(Integer id) {
        try{
            userRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("删除失败");
        }


    }

}
