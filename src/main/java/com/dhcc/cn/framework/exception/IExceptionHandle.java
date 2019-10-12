package com.dhcc.cn.framework.exception;

import com.dhcc.cn.framework.dto.result.Result;

import javax.servlet.http.HttpServletRequest;

public interface IExceptionHandle {
    Result handle(HttpServletRequest request,Exception e);
}
