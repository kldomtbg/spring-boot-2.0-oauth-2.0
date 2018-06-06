package com.ywsoftware.oa.authServer.base.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public String processException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        // 输出信息进行持久化
        logger.error(ex.getMessage());
        for (StackTraceElement stack : ex.getStackTrace()) {
            logger.error("  " + stack.toString());
        }
        if (ex instanceof ApplicationException) {
            //TODO 应用异常

        } else {
            //TODO 应用异常
        }
        ex.printStackTrace();
        return ex.getMessage();
    }
}
