package com.haoshuai.app.entity;


public class Dependents {

  private long dId;
  private String dName;
  private long dGender;
  private String dPhone;
  private long pId;
  private String pName;

  @Override
  public String toString() {
    return "Dependents{" +
            "dId=" + dId +
            ", dName='" + dName + '\'' +
            ", dGender=" + dGender +
            ", dPhone='" + dPhone + '\'' +
            ", pId=" + pId +
            ", pName='" + pName + '\'' +
            '}';
  }

  public long getdId() {
    return dId;
  }

  public void setdId(long dId) {
    this.dId = dId;
  }

  public String getdName() {
    return dName;
  }

  public void setdName(String dName) {
    this.dName = dName;
  }

  public long getdGender() {
    return dGender;
  }

  public void setdGender(long dGender) {
    this.dGender = dGender;
  }

  public String getdPhone() {
    return dPhone;
  }

  public void setdPhone(String dPhone) {
    this.dPhone = dPhone;
  }

  public long getpId() {
    return pId;
  }

  public void setpId(long pId) {
    this.pId = pId;
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }
}
