package com.dhcc.cn.framework.pojo.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("event_level")
public class EventLevel {

    @TableId(value = "id",type = IdType.AUTO)
    private long id;

    @TableField("name")
    private String name;

    @TableField("code")
    private String code;
}