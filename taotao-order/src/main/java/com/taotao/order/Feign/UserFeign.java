package com.taotao.order.Feign;

import com.taotao.commen.exception.BusinessException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("nacos-user")
public interface UserFeign {


    @RequestMapping("/ReduceMoney")
    public int ReduceMoney(@RequestParam("uid") int uid, @RequestParam("money")int money) throws BusinessException;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("hello")String hello);
}
