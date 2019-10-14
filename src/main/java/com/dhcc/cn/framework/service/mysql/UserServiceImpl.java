package com.dhcc.cn.framework.service.mysql;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dhcc.cn.framework.mapper.UserMapper;
import com.dhcc.cn.framework.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> {

    @Autowired
    UserMapper mUserMapper;

    public User getUser(String name , String psw){
        User user = mUserMapper.selectById(1);
        return user;
    }

}
