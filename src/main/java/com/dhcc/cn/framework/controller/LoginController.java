package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.dto.LoginForm;
import com.dhcc.cn.framework.dto.UserInfo;
import com.dhcc.cn.framework.dto.result.Result;
import com.dhcc.cn.framework.dto.result.ResultStatus;
import com.dhcc.cn.framework.service.mysql.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@ResponseResultBody
public class LoginController {


    @Autowired
    UserServiceImpl mService;

    @PostMapping("/login")
    public Result<UserInfo> login(@Validated LoginForm loginForm) {
        Result<UserInfo> result = null;
        Optional<UserInfo> optional = mService.getUser(loginForm.getName(),loginForm.getPsw());
        if (optional.isPresent()) {
            result = Result.success(optional.get());
        } else {
            result = Result.error(ResultStatus.LOGIN_ERROR);
        }
        return result;
    }
}
