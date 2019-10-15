package com.dhcc.cn.framework.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class HospitalCarForm {

    private String user;

    private String date;

    /**
     * 本部派车
     */
    @Max(1000)
    @Min(0)
    private int item1;
    /**
     * 23区派车
     */
    @Max(1000)
    @Min(value = 0,message = "23区派车不能小于0")
    private int item2;

    /**
     * 病人直呼
     */
    @Max(1000)
    @Min(value = 0,message = "病人直呼不能小于0")
    private int item3;
    /**
     * 接病人
     */
    @Max(1000)
    @Min(value = 0,message = "接病人不能小于0")
    private int item4;
    /**
     * 送病人
     */
    @Max(1000)
    @Min(value = 0,message = "送病人不能小于0")
    private int item5;
    /**
     * 保健
     */
    @Max(1000)
    @Min(value = 0,message ="保健不能小于0" )
    private int item6;
    /**
     * 长途出车
     */
    @Max(1000)
    @Min(value = 0,message = "长途出车不能小于0")
    private int item7;

}
