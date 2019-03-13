package com.taotao.order;

import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudSecondaryConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@MapperScan("com.taotao.order.mapper")
@ComponentScan("com.taotao.commen.exception")
@ComponentScan("com.taotao.order")
@Import(SpringCloudSecondaryConfiguration.class)
public class TaotaoOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaotaoOrderApplication.class, args);
    }

}
