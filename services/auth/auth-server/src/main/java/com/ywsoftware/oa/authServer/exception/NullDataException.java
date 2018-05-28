package com.ywsoftware.oa.authServer.exception;

/**
 * Created by userFly on 2018/5/28.
 * 查询数据为空异常
 */
public class NullDataException extends ApplicationException{

    public NullDataException() {
        super("查询数据为空");
    }

    public NullDataException(String msg) {
        super(msg);
    }
}
