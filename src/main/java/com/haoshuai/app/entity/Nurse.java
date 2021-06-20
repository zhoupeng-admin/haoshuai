package com.haoshuai.app.entity;


public class Nurse {

  private long nId;
  private String nNo;
  private String nName;
  private long nGender;
  private String nPhone;
  private long nWstatus;

  @Override
  public String toString() {
    return "Nurse{" +
            "nId=" + nId +
            ", nNo='" + nNo + '\'' +
            ", nName='" + nName + '\'' +
            ", nGender=" + nGender +
            ", nPhone='" + nPhone + '\'' +
            ", nWstatus=" + nWstatus +
            '}';
  }

  public long getnId() {
    return nId;
  }

  public void setnId(long nId) {
    this.nId = nId;
  }

  public String getnNo() {
    return nNo;
  }

  public void setnNo(String nNo) {
    this.nNo = nNo;
  }

  public String getnName() {
    return nName;
  }

  public void setnName(String nName) {
    this.nName = nName;
  }

  public long getnGender() {
    return nGender;
  }

  public void setnGender(long nGender) {
    this.nGender = nGender;
  }

  public String getnPhone() {
    return nPhone;
  }

  public void setnPhone(String nPhone) {
    this.nPhone = nPhone;
  }

  public long getnWstatus() {
    return nWstatus;
  }

  public void setnWstatus(long nWstatus) {
    this.nWstatus = nWstatus;
  }
}
