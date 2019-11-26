package com.dhcc.cn.framework.pojo.mysql;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("medical_rescue_detail")
public class MedicalRescueDetail implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private long id;

    @TableField("main_id")
    private long mainId;

    @TableField("paadm_id")
     private String paadmId;

    @TableField("pat_name")
    private String patName;

    @TableField("pat_sex")
    private String patSex;

    @TableField("pat_age")
    private String patAge;

    @TableField("pat_nation")
    private String patNation;

    @TableField("pat_occupation")
    private String patOccupation;

    @TableField("pat_diag")
    private String patDiag;

    @TableField("pat_admloc")
    private String patAdmloc;

    @TableField("pat_level")
    private String patLevel;

    @TableField("pat_return")
    private String patReturn;

    @TableField("pat_consult")
    private String patConsult;

    @TableField("pat_trans")
    private String patTrans;

    @TableField("pat_regNo")
    private String patRegNo;

}
