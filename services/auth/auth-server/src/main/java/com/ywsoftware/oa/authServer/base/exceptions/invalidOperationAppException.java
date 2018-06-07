package com.ywsoftware.oa.authServer.base.exceptions;

/**
 * 自定义异常, 无权限
 */
public class invalidOperationAppException extends ApplicationException {

    public invalidOperationAppException(){
        super("无效的操作");
    }

    public invalidOperationAppException(String msg){
        super(msg);
    }
    public invalidOperationAppException(String msg, Exception ex){
        super(msg, ex);
    }
}
