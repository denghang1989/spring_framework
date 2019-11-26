package com.dhcc.cn.framework.pojo.cache;

import lombok.Data;

/**
 * 病人基本信息
 */

@Data
public class PatientInfo {

    private String patId;                           // 患者Id

    private String patRegNo;                           // 登记号

    private String patName;                         // 姓名

    private String medCareNo;                       // 病案号

    private String patAge;                          // 年龄

    private String patSex;                          // 性别

    private String patPhone;                        // 联系电话

    private String birthDate;                       // 出生日期

    private String patAddr;                         // 联系地址

    private String patIDNo;                         // 身份证号

    private String patNation;                       // 民族

    private String patOccupation;                   // 职业

}
