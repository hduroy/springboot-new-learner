package com.example.springboot_test;

import com.example.springboot_test.star.BigStar;
import com.example.springboot_test.star.ProxyUtil;
import com.example.springboot_test.star.Star;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootTestApplication {
//springboot启动类
    public static void main(String[] args) {
        BigStar bigStar = new BigStar("蔡徐坤");
        Star proxy = ProxyUtil.createProxy(bigStar);
        String result = proxy.sing("快乐崇拜");
        System.out.println(result);
        String result2 = proxy.dance("爱我");
        System.out.println(result2);

//        SpringApplication.run(SpringbootTestApplication.class, args);

    }

}
