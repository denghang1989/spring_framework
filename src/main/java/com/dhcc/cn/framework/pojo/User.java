package com.dhcc.cn.framework.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("user")
public class User {

    @TableId
    private int id;

    @TableField
    private String name;

    @TableField
    private String email;

    @TableField
    private String address;

}
