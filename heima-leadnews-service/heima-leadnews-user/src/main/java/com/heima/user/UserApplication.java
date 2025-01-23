package com.heima.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//MyBatis 框架中的一个注解，用于指定包路径，扫描其中的Mapper接口并将其注册为Spring容器中的Bean。
//这样所有的mapper接口都可以使用@Autowire实现自动注入生成代理对象了
@MapperScan("com.heima.user.mapper")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}