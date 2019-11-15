package com.dhcc.cn.framework.pojo.mysql;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("event-lever")
public class EventLever {

    @TableId("id")
    private long id;
}
