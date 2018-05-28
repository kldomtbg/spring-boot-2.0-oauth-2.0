package com.ywsoftware.oa.authServer.exception;

/**
 * Created by userFly on 2018/5/28.
 * 定义应用异常, 自定义异常继承该类
 */
public class ApplicationException extends Exception {
    public ApplicationException(String msg) {
        super(msg);
    }

    public ApplicationException() {
        super();
    }
}
