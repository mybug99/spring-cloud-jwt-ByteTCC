package com.taotao.commen.Enum;

public enum ResponseEnum {
    SYSTEM_ERROR(500,"系统异常"),
    USER_ERROR_TOKEN(500,"token失效"),
    USER_ERROR_USERNAME(400,"用户名不存在"),
    USER_ERROR_MONEY(200,"您当前余额不足"),
    USER_MONEY_FROZEN(200,"您当前资金在冻结状态"),
    USER_ERROR(400,"用户不存在"),
    UNKNOWN_ERROR(400,"用户不存在"),
    ORDER_PAY(500,"当前订单已支付"),
    ;

    private int code;
    private String message;

    ResponseEnum(int code, String message) {
        this.code=code;
        this.message=message;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
