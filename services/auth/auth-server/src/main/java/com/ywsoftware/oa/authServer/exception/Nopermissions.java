package com.ywsoftware.oa.authServer.exception;

/**
 * Created by userFly on 2018/5/28.
 * 自定义异常, 无权限
 */
public class Nopermissions extends ApplicationException {

    public Nopermissions(){
        super("无权限");
    }

    public Nopermissions(String msg){
        super(msg);
    }
}
