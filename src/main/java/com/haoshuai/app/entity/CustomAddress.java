package com.haoshuai.app.entity;


public class CustomAddress {

  private long caId;
  private String caName;
  private String caPhone;
  private String caAddress;
  private long cId;

  @Override
  public String toString() {
    return "CustomAddress{" +
            "caId=" + caId +
            ", caName='" + caName + '\'' +
            ", caPhone='" + caPhone + '\'' +
            ", caAddress='" + caAddress + '\'' +
            ", cId=" + cId +
            '}';
  }

  public long getcId() {
    return cId;
  }

  public void setcId(long cId) {
    this.cId = cId;
  }

  public long getCaId() {
    return caId;
  }

  public void setCaId(long caId) {
    this.caId = caId;
  }

  public String getCaName() {
    return caName;
  }

  public void setCaName(String caName) {
    this.caName = caName;
  }

  public String getCaPhone() {
    return caPhone;
  }

  public void setCaPhone(String caPhone) {
    this.caPhone = caPhone;
  }

  public String getCaAddress() {
    return caAddress;
  }

  public void setCaAddress(String caAddress) {
    this.caAddress = caAddress;
  }
}
