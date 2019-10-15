package com.dhcc.cn.framework.pojo.mysql;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

import lombok.Data;

@Data
@TableName("oxygen")
public class Oxygen {

    @TableId
    private long id;

    private String user;

    private Date date;
    /**
     * 高压氧舱数
     */
    private int item1;
    /**
     * 高压氧治疗
     */
    private int item2;
    /**
     * 高压氧会诊
     */
    private int item3;
    /**
     * 高压氧门诊
     */
    private int item4;

    private Date createDate;

}
