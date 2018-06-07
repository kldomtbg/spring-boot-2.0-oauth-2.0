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
        if (ex instanceof ApplicationException) {
            //TODO 应用异常
            logger.warn(ex.getMessage(), ex);

        } else {
            //TODO 非应用异常
        }
        return ex.getMessage();
    }
}
