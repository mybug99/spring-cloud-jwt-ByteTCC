package com.taotao.order.Feign;

import com.taotao.commen.exception.BusinessException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("SPRING-CLOUD-USER")
public interface UserFeign {


    @RequestMapping("/ReduceMoney")
    public int ReduceMoney(@RequestParam("uid") int uid, @RequestParam("money")int money) throws BusinessException;
}
