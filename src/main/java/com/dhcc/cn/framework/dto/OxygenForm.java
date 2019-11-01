package com.dhcc.cn.framework.dto;


import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class OxygenForm {

    private String user;

    private Date date;
    /**
     * 高压氧舱数
     */
    @Max(1000)
    @Min(0)
    private int item1;
    /**
     * 高压氧治疗
     */
    @Min(0)
    @Max(1000)
    private int item2;
    /**
     * 高压氧会诊
     */
    @Min(0)
    @Max(1000)
    private int item3;
    /**
     * 高压氧门诊
     */
    @Min(0)
    @Max(100)
    private int item4;

}
