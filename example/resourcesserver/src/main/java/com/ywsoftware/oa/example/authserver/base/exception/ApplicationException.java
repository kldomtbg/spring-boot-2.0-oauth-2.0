package com.ywsoftware.oa.authServer.base.exception;

/**
 * 定义应用异常, 自定义异常继承该类
 */
public class ApplicationException extends RuntimeException {
    public ApplicationException(String msg) {
        super(msg);
    }

    public ApplicationException() {
        super();
    }
}
