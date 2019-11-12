package com.dhcc.cn.framework.service.mysql;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dhcc.cn.framework.config.JwtConfig;
import com.dhcc.cn.framework.dto.UserInfo;
import com.dhcc.cn.framework.mapper.UserMapper;
import com.dhcc.cn.framework.pojo.mysql.User;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl {
    @Resource
    private JwtConfig jwtConfig;

    @Autowired
    UserMapper mUserMapper;

    public Optional<UserInfo> getUser(String name, String psw) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getLoginName, name).eq(User::getPassword, psw);
        User user = mUserMapper.selectOne(queryWrapper);
        if (user != null) {
            String token = jwtConfig.getToken(user.getLoginName() + user.getPassword());
            UserInfo userInfo = new UserInfo() {{
                setToken(token);
            }};
            BeanUtils.copyProperties(user, userInfo);
            return Optional.of(userInfo);
        } else {
            return Optional.empty();
        }

    }

}
