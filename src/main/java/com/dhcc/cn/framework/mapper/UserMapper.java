package com.dhcc.cn.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dhcc.cn.framework.pojo.mysql.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

}
