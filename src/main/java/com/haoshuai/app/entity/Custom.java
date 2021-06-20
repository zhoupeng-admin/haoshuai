package com.haoshuai.app.entity;


public class Custom {

  private long cId;
  private String cName;
  private String cNickName;
  private String cPwd;
  private String cPhone;
  private String cEmail;

  public long getcId() {
    return cId;
  }

  public void setcId(long cId) {
    this.cId = cId;
  }

  public String getcName() {
    return cName;
  }

  public void setcName(String cName) {
    this.cName = cName;
  }

  public String getcNickName() {
    return cNickName;
  }

  public void setcNickName(String cNickName) {
    this.cNickName = cNickName;
  }

  public String getcPwd() {
    return cPwd;
  }

  public void setcPwd(String cPwd) {
    this.cPwd = cPwd;
  }

  public String getcPhone() {
    return cPhone;
  }

  public void setcPhone(String cPhone) {
    this.cPhone = cPhone;
  }

  public String getcEmail() {
    return cEmail;
  }

  public void setcEmail(String cEmail) {
    this.cEmail = cEmail;
  }

  @Override
  public String toString() {
    return "Custom{" +
            "cId=" + cId +
            ", cName='" + cName + '\'' +
            ", cNickName='" + cNickName + '\'' +
            ", cPwd='" + cPwd + '\'' +
            ", cPhone='" + cPhone + '\'' +
            ", cEmail='" + cEmail + '\'' +
            '}';
  }
}
