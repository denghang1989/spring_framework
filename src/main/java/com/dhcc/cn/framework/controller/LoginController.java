package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.config.JwtConfig;
import com.dhcc.cn.framework.dao.mapper.UserMapper;
import com.dhcc.cn.framework.dto.LoginForm;
import com.dhcc.cn.framework.dto.result.ResponseResultBody;
import com.dhcc.cn.framework.dto.UserInfo;
import com.dhcc.cn.framework.pojo.User;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private JwtConfig jwtConfig;

    @Resource
    UserMapper mMapper;

    @PostMapping("/login")
    @ResponseResultBody
    public UserInfo login(@Validated LoginForm loginForm) {
        User user = mMapper.selectById(1);
        String token = jwtConfig.getToken(loginForm.getName() + loginForm.getPsw());
        UserInfo userInfo = new UserInfo() {{
            setUser(user);
            setToken(token);
        }};
        return userInfo;
    }
}
