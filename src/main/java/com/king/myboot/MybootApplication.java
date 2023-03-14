package com.king.myboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// springboot 的启动类
@SpringBootApplication
//@MapperScan这个注解是扫描mapper包下的所有 @mapper 的注解的
@MapperScan("com.king.myboot.mapper")
public class MybootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybootApplication.class, args);
    }
}
