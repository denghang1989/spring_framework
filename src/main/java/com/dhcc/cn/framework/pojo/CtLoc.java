package com.dhcc.cn.framework.pojo;


public class CtLoc {

  //CTLOC_RowID, CTLOC_Code, CTLOC_Desc , CTLOC_Address, CTLOC_Type
  private long ctlocRowId;

  private String ctlocCode;

  private String ctlocDesc;

  private String ctlocAddress;

  private String ctlocType;


  public long getCtlocRowId() {
    return ctlocRowId;
  }

  public void setCtlocRowId(long ctlocRowId) {
    this.ctlocRowId = ctlocRowId;
  }

  public String getCtlocCode() {
    return ctlocCode;
  }

  public void setCtlocCode(String ctlocCode) {
    this.ctlocCode = ctlocCode;
  }

  public String getCtlocDesc() {
    return ctlocDesc;
  }

  public void setCtlocDesc(String ctlocDesc) {
    this.ctlocDesc = ctlocDesc;
  }

  public String getCtlocAddress() {
    return ctlocAddress;
  }

  public void setCtlocAddress(String ctlocAddress) {
    this.ctlocAddress = ctlocAddress;
  }

  public String getCtlocType() {
    return ctlocType;
  }

  public void setCtlocType(String ctlocType) {
    this.ctlocType = ctlocType;
  }
}
