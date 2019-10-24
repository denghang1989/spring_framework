package com.dhcc.cn.framework.dto.emergency;

import java.util.Date;

import lombok.Data;

/**
 * 24小时院前出车人次
 */
@Data
public class HospitalCarData {
    /*
    本部派车
    23区派车
    病人直呼
    接病人
    送病人
    保健
    长途出车
    出车总数
    */
    private Date date;
    /**
     * 本部派车
     */
    private int  item1;
    /**
     * 23区派车
     */
    private int  item2;
    /**
     * 病人直呼
     */
    private int  item3;
    /**
     * 接病人
     */
    private int  item4;
    /**
     * 送病人
     */
    private int  item5;
    /**
     * 保健
     */
    private int  item6;
    /**
     * 长途出车
     */
    private int  item7;
    /**
     * 出车总数
     */
    private int  item8;

}
