package com.taotao.commen.exception;

import com.taotao.commen.Enum.ResponseEnum;
import com.taotao.commen.pojo.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AllException {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse jsonErrorHandler(HttpServletRequest request, Exception e) throws Exception{
        BaseResponse response = new BaseResponse();
        System.out.println(e.getMessage());
        if(e instanceof BusinessException ){
            response.setCode(((BusinessException)e).getCode());
            response.setMessage(e.getMessage());
        }else{
            response.setCode(ResponseEnum.SYSTEM_ERROR.getCode());
            response.setMessage(ResponseEnum.SYSTEM_ERROR.getMessage());
        }
        return response;
    }
}
