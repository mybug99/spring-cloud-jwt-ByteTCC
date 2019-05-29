package com.taotao.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.taotao.user.mapper")
public class TaotaoUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaotaoUserApplication.class, args);
    }

}
