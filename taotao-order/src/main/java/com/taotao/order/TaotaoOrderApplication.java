package com.taotao.order;

import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudSecondaryConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@EnableFeignClients
@EnableHystrix
@MapperScan("com.taotao.order.mapper")
@ComponentScan("com.taotao.commen.exception")
@ComponentScan("com.taotao.order")
@EnableDiscoveryClient  //注册到nacos
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
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
                new Thread().notify();
            return name;
        }
    }

}
