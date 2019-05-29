package com.taotao.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableFeignClients
@MapperScan("com.taotao.order.mapper")
@EnableDiscoveryClient  //注册到nacos
@SpringBootApplication
public class TaotaoOrderApplication {


    public static void main(String[] args) {
        SpringApplication.run(TaotaoOrderApplication.class, args);
    }

    @RestController
    @RefreshScope
    class TestController {

        @Value("${hey}")
        private String name;

        @RequestMapping("/hey")
        public String hey() {
            return name;
        }
    }

}
