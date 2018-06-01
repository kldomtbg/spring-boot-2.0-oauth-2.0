package com.ywsoftware.oa.authServer.base.exception;

/**
 * 查询数据为空异常
 */
public class NullDataException extends ApplicationException {

    public NullDataException() {
        super("查询数据为空");
    }

    public NullDataException(String msg) {
        super(msg);
    }
}
