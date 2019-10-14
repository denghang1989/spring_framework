package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.config.JwtConfig;
import com.dhcc.cn.framework.dto.LoginForm;
import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.dto.UserInfo;
import com.dhcc.cn.framework.pojo.User;
import com.dhcc.cn.framework.service.mysql.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private JwtConfig jwtConfig;

    @Autowired
    UserServiceImpl mService;

    @PostMapping("/login")
    @ResponseResultBody
    public UserInfo login(@Validated LoginForm loginForm) {
        User user = mService.getUser(loginForm.getName(),loginForm.getPsw());
        String token = jwtConfig.getToken(loginForm.getName() + loginForm.getPsw());
        UserInfo userInfo = new UserInfo() {{
            setUser(user);
            setToken(token);
        }};
        return userInfo;
    }
}
