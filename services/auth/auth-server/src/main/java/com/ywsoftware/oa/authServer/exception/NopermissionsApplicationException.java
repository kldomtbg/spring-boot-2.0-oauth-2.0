package com.ywsoftware.oa.authServer.exception;

/**
 * Created by userFly on 2018/5/28.
 * 自定义异常, 无权限
 */
public class NopermissionsApplicationException extends ApplicationException {

    public NopermissionsApplicationException(){
        super("无权限");
    }

    public NopermissionsApplicationException(String msg){
        super(msg);
    }
}
