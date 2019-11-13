package com.dhcc.cn.framework.pojo.cache;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("SS_User")
@Data
public class CacheUser {

    @TableId("SSUSR_RowId")
    private long id;

    @TableField("SSUSR_Initials")
    private String code;

    @TableField(condition = SqlCondition.LIKE, value = "SSUSR_Name")
    private String name;

}
