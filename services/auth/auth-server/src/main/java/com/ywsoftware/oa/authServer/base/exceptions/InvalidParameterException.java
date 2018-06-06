package com.ywsoftware.oa.authServer.base.exceptions;

/**
 * 查询数据为空异常
 */
public class InvalidParameterException extends ApplicationException{

    public InvalidParameterException() {
        super("无效的参数");
    }

    public InvalidParameterException(String msg) {
        super(msg);
    }
}
