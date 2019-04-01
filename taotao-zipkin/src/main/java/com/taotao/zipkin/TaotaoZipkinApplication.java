package com.taotao.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.internal.EnableZipkinServer;


@EnableZipkinServer
@EnableDiscoveryClient
@SpringBootApplication
public class TaotaoZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaotaoZipkinApplication.class, args);
    }

}
