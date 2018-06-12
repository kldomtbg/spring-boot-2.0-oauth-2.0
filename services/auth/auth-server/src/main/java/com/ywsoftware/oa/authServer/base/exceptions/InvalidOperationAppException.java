package com.ywsoftware.oa.authserver.base.exceptions;

/**
 * 自定义异常, 无效的操作
 */
public class InvalidOperationAppException extends ApplicationException {

    public InvalidOperationAppException() {
        super("无效的操作");
    }

    public InvalidOperationAppException(String msg) {
        super(msg);
    }

    public InvalidOperationAppException(String msg, Exception ex) {
        super(msg, ex);
    }
}
