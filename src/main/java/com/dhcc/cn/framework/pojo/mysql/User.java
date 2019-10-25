package com.dhcc.cn.framework.pojo.mysql;

import lombok.Data;

@Data
public class User {

    private long   id;
    private String userName;
    private String email;
    private String address;
    private String loginName;
    private String password;
    private String mobile;

}
