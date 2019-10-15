package com.dhcc.cn.framework.pojo.cache;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("CT_Loc")
public class CtLoc {

    //CTLOC_RowID, CTLOC_Code, CTLOC_Desc , CTLOC_Address, CTLOC_Type
    @TableField("CTLOC_RowID")
    @TableId
    private long ctlocRowId;

    private String ctlocCode;

    private String ctlocDesc;

    private String ctlocAddress;

    private String ctlocType;

}
