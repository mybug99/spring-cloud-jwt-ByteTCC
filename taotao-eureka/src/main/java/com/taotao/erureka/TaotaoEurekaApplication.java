package com.taotao.erureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TaotaoEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaotaoEurekaApplication.class, args);
    }

}
