package com.dhcc.cn.framework.config;

import com.dhcc.cn.framework.dto.result.Result;
import com.dhcc.cn.framework.exception.ResultException;
import com.dhcc.cn.framework.exception.TokenException;
import com.dhcc.cn.framework.exception.impl.DefaultExceptionHandler;
import com.dhcc.cn.framework.exception.impl.ResultExceptionHandler;
import com.dhcc.cn.framework.exception.impl.TokenExceptionHandler;
import com.dhcc.cn.framework.exception.impl.ValidationExceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import javax.servlet.http.HttpServletRequest;

@Component
@RestControllerAdvice
class GlobalExceptionAdvice {

    @Autowired
    ResultExceptionHandler mResultExceptionHandler;

    @Autowired
    TokenExceptionHandler mTokenExceptionHandler;

    @Autowired
    ValidationExceptionHandler mValidationExceptionHandler;

    @Autowired
    DefaultExceptionHandler mDefaultExceptionHandler;

    @ExceptionHandler(Exception.class)
    public Result handle(HttpServletRequest request, Exception ex){
        if (ex instanceof ResultException) {
            return mResultExceptionHandler.handle(request,ex);
        } else if (ex instanceof TokenException) {
            return mTokenExceptionHandler.handle(request,ex);
        } else if (ex instanceof BindException) {
            return mValidationExceptionHandler.handle(request, ex);
        } else {
            return mDefaultExceptionHandler.handle(request,ex);
        }
    }

}
