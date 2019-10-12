package com.dhcc.cn.framework.exception.impl;

import com.dhcc.cn.framework.dto.result.Result;
import com.dhcc.cn.framework.dto.result.ResultStatus;
import com.dhcc.cn.framework.exception.IExceptionHandle;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

@Component
public class ValidationExceptionHandler implements IExceptionHandle {

    @Override
    public Result handle(HttpServletRequest request, Exception e) {
        BindException exception = (BindException) e;
        List<FieldError> errors = exception.getFieldErrors();
        List<Map<String, String>> collect = errors.stream().map(fieldError -> {
            Map<String, String> map = new HashMap<>();
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            map.put("field",field);
            map.put("defaultMessage",defaultMessage);
            return map;
        }).collect(Collectors.toList());
        return Result.error(ResultStatus.BAD_REQUEST,collect);
    }
}
