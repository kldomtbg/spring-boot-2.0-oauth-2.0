package com.ywsoftware.oa.authserver.base.exceptions;

/**
 * 无效的参数
 */
public class InvalidParameterException extends ApplicationException {

    public InvalidParameterException() {
        super("无效的参数");
    }

    public InvalidParameterException(String msg) {
        super(msg);
    }

    public InvalidParameterException(String msg, Exception ex) {
        super(msg, ex);
    }
}
