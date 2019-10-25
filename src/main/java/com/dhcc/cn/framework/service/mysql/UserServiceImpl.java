package com.dhcc.cn.framework.service.mysql;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dhcc.cn.framework.mapper.UserMapper;
import com.dhcc.cn.framework.pojo.mysql.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> {

    @Autowired
    UserMapper mUserMapper;

    public Optional<User> getUser(String name , String psw){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserName,name).eq(User::getPassword,psw);
        User user = mUserMapper.selectOne(queryWrapper);
        return Optional.ofNullable(user);
    }

}
