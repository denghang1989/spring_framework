package com.dhcc.cn.framework.pojo.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@TableName("medical_rescue")
public class MedicalRescue implements Serializable {

  @TableId(value = "id",type = IdType.AUTO)
  private long id;
  
  @TableField("organization")
  private String organization;
  
  @TableField("report_datetime")
  private Date   reportDatetime;

  @TableField("reporter")
  private String reporter;

  @TableField("phone")
  private String phone;

  @TableField("approver")
  private String approver;

  @TableField("event_type")
  private long   eventType;

  @TableField("event_level")
  private long   eventLevel;

  @TableField("occurrence_datetime")
  private Date   occurrenceDatetime;

  @TableField("Occurrence_address")
  private String occurrenceAddress;

  @TableField("paadm_datetime")
  private Date   paadmDatetime;

  @TableField("event_desc")
  private String eventDesc;

  @TableField("total_number")
  private long   totalNumber;

  @TableField("mild_number")
  private long   mildNumber;

  @TableField("severe_number")
  private long   severeNumber;

  @TableField("critically_number")
  private long   critically_Number;

  @TableField("death_number")
  private long   deathNumber;

  @TableField("event_trend")
  private String eventTrend;

  @TableField("event_enlargement")
  private long   eventEnlargement;

  @TableField("ambulance_number")
  private long   ambulanceNumber;

  @TableField("doctor_number")
  private long doctorNumber;

  @TableField("nurser_number")
  private long nurserNumber;

  @TableField("driver_number")
  private long driverNumber;

  @TableField("other_ways")
  private String otherWays;

  @TableField("consultation")
  private long consultation;

  @TableField("reinforce")
  private long reinforce;

  @TableField("additional_resources")
  private String additionalResources;

  @TableField("create_datetime")
  private Date createDatetime;

  @TableField("create_user")
  private long createUser;
}
