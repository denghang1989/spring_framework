package com.dhcc.cn.framework.pojo.cache;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("MRC_DiagnosType")
public class DiagnosType {

    //DTYP_Code, DTYP_Desc, DTYP_NoSendToCoding

    @TableId("DTYP_RowId")
    private long id;

    @TableField("DTYP_Code")
    private String code;

    @TableField("DTYP_Desc")
    private String name;

}
