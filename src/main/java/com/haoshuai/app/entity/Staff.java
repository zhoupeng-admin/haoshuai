package com.haoshuai.app.entity;


public class Staff {

  private long sId;
  private String sName;
  private long sGender;
  private String sPhone;
  private long sIdentity;
  private long sWstatus;
  private String sIc;

  @Override
  public String toString() {
    return "Staff{" +
            "sId=" + sId +
            ", sName='" + sName + '\'' +
            ", sGender=" + sGender +
            ", sPhone='" + sPhone + '\'' +
            ", sIdentity=" + sIdentity +
            ", sWstatus=" + sWstatus +
            ", sIc='" + sIc + '\'' +
            '}';
  }

  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }


  public String getSName() {
    return sName;
  }

  public void setSName(String sName) {
    this.sName = sName;
  }


  public long getSGender() {
    return sGender;
  }

  public void setSGender(long sGender) {
    this.sGender = sGender;
  }


  public String getSPhone() {
    return sPhone;
  }

  public void setSPhone(String sPhone) {
    this.sPhone = sPhone;
  }


  public long getSIdentity() {
    return sIdentity;
  }

  public void setSIdentity(long sIdentity) {
    this.sIdentity = sIdentity;
  }


  public long getSWstatus() {
    return sWstatus;
  }

  public void setSWstatus(long sWstatus) {
    this.sWstatus = sWstatus;
  }


  public String getSIc() {
    return sIc;
  }

  public void setSIc(String sIc) {
    this.sIc = sIc;
  }

  public long getsId() {
    return sId;
  }

  public void setsId(long sId) {
    this.sId = sId;
  }

  public String getsName() {
    return sName;
  }

  public void setsName(String sName) {
    this.sName = sName;
  }

  public long getsGender() {
    return sGender;
  }

  public void setsGender(long sGender) {
    this.sGender = sGender;
  }

  public String getsPhone() {
    return sPhone;
  }

  public void setsPhone(String sPhone) {
    this.sPhone = sPhone;
  }

  public long getsIdentity() {
    return sIdentity;
  }

  public void setsIdentity(long sIdentity) {
    this.sIdentity = sIdentity;
  }

  public long getsWstatus() {
    return sWstatus;
  }

  public void setsWstatus(long sWstatus) {
    this.sWstatus = sWstatus;
  }

  public String getsIc() {
    return sIc;
  }

  public void setsIc(String sIc) {
    this.sIc = sIc;
  }
}
