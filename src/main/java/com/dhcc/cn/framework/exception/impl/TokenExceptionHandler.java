package com.dhcc.cn.framework.exception.impl;

import com.dhcc.cn.framework.dto.result.Result;
import com.dhcc.cn.framework.dto.result.ResultStatus;
import com.dhcc.cn.framework.exception.IExceptionHandle;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenExceptionHandler implements IExceptionHandle {
    @Override
    public Result handle(HttpServletRequest request, Exception e) {
        return Result.error(ResultStatus.BAD_REQUEST,e.getMessage());
    }
}
