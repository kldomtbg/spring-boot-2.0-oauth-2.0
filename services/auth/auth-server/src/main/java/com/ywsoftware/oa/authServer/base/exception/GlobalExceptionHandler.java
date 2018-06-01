package com.ywsoftware.oa.authServer.base.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
@CrossOrigin
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Value("${mail.enable}")
    private String port;

    @ExceptionHandler
    public String processException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        // 输出信息进行持久化
        LOGGER.error(ex.getMessage());
        for (StackTraceElement stack: ex.getStackTrace()) {
            LOGGER.error("  " + stack.toString());
        }
        if (ex instanceof ApplicationException) {
            // 应用异常

        }  else {
        }
        ex.printStackTrace();
        return ex.getMessage();
    }
}
