package com.dhcc.cn.framework.pojo.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("user")
public class User {

    @TableId(value = "id",type = IdType.AUTO)
    private long   id;

    @TableField("user_name")
    private String userName;

    @TableField("email")
    private String email;

    @TableField("password")
    private String password;

    @TableField("mobile")
    private String mobile;

    @TableField("openId")
    private String openId;

    @TableField("user_code")
    private String userCode;

    @TableField("hospital_id")
    private long hospitalId;

}
