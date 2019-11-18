package com.dhcc.cn.framework.dto;

import lombok.Data;

@Data
public class MedicalRescueDetailForm {

  private long id;

  private long mainId;

  private String paadmId;

  private String patName;

  private String patSex;

  private long patAge;

  private String patNation;

  private String patOccupation;

  private String patDiag;

  private String patAdmloc;

  private String patLevel;

  private String patReturn;

  private String patConsult;

  private String patTrans;

}
