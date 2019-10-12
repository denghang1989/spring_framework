package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.dao.mapper.UserMapper;
import com.dhcc.cn.framework.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserMapper mUserMapper;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") String id){
        User user = mUserMapper.selectById(id);
        return user;
    }
}
