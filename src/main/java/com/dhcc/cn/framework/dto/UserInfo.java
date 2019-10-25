package com.dhcc.cn.framework.dto;

import com.dhcc.cn.framework.pojo.mysql.User;

import lombok.Data;

@Data
public class UserInfo {

    private User user;

    private String token;

}
