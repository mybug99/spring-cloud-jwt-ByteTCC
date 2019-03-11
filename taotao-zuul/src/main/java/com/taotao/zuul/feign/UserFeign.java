package com.taotao.zuul.feign;

import com.taotao.commen.pojo.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("SPRING-CLOUD-USER")
public interface UserFeign {

    @RequestMapping("/inToken/{token}")
    public User authToken(@PathVariable("token") String token);
}
