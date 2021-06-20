package com.haoshuai.app.entity;


public class Physician {

  private long pId;
  private String pNo;
  private String pName;
  private long pGender;
  private String pPhone;
  private long pWstatus;
  private String pSno;
  private Section section;

  public long getpId() {
    return pId;
  }

  public void setpId(long pId) {
    this.pId = pId;
  }

  public String getpNo() {
    return pNo;
  }

  public void setpNo(String pNo) {
    this.pNo = pNo;
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }

  public long getpGender() {
    return pGender;
  }

  public void setpGender(long pGender) {
    this.pGender = pGender;
  }

  public String getpPhone() {
    return pPhone;
  }

  public void setpPhone(String pPhone) {
    this.pPhone = pPhone;
  }

  public long getpWstatus() {
    return pWstatus;
  }

  public void setpWstatus(long pWstatus) {
    this.pWstatus = pWstatus;
  }

  public String getpSno() {
    return pSno;
  }

  public void setpSno(String pSno) {
    this.pSno = pSno;
  }

  public Section getSection() {
    return section;
  }

  public void setSection(Section section) {
    this.section = section;
  }

  @Override
  public String toString() {
    return "Physician{" +
            "pId=" + pId +
            ", pNo='" + pNo + '\'' +
            ", pName='" + pName + '\'' +
            ", pGender=" + pGender +
            ", pPhone='" + pPhone + '\'' +
            ", pWstatus=" + pWstatus +
            ", pSno='" + pSno + '\'' +
            ", section=" + section +
            '}';
  }
}
