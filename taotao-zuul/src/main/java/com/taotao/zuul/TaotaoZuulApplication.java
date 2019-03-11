package com.taotao.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableFeignClients
public class TaotaoZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaotaoZuulApplication.class, args);
    }

}
