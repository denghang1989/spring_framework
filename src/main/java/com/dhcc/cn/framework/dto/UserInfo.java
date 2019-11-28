package com.dhcc.cn.framework.dto;

import lombok.Data;

@Data
public class UserInfo {

    private long   id;
    private String userName;
    private String email;
    private String mobile;
    private String token;
    private String userCode;
    private String openId;
    private long hospitalId;
}
