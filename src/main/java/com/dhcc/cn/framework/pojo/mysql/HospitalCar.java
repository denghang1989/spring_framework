package com.dhcc.cn.framework.pojo.mysql;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import lombok.Data;

@Data
@TableName("hospital_car")
public class HospitalCar {

    @TableId
    private long   rowId;

    private String user;

    private Date   date;
    /**
     * 本部派车
     */
    private int item1;
    /**
     * 23区派车
     */
    private int item2;
    /**
     * 病人直呼
     */
    private int item3;
    /**
     * 接病人
     */
    private int item4;
    /**
     * 送病人
     */
    private int item5;
    /**
     * 保健
     */
    private int item6;
    /**
     * 长途出车
     */
    private int item7;

    private Date   createDate;


}
