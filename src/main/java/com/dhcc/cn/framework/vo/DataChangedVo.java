package com.dhcc.cn.framework.vo;

import java.util.Date;

import lombok.Data;

@Data
public class DataChangedVo {

    private long id;

    private String organization;

    private Date reportDatetime;

    private String reporter;

    private String phone;

    private String approver;

    private String eventTypeName;

    private String eventLevelName;

    private Date occurrenceDatetime;

    private String occurrenceAddress;

    private Date paadmDatetime;

    private String eventDesc;

    private long totalNumber;

    private long mildNumber;

    private long severeNumber;

    private long critically_Number;

    private long deathNumber;

    private String eventTrend;

    private long eventEnlargement;

    private long ambulanceNumber;

    private long doctorNumber;

    private long nurserNumber;

    private long driverNumber;

    private String otherWays;

    private String consultation;

    private long reinforce;

    private String additionalResources;

    private long createUser;

    private String approverName;

    private String openId;

}
