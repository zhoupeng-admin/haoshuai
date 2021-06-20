package com.haoshuai.app.entity;


public class NutChild {

  private long ncId;
  private String ncName;
  private double ncPrice;
  private String ncRemark;

  @Override
  public String toString() {
    return "NutChild{" +
            "ncId=" + ncId +
            ", ncName='" + ncName + '\'' +
            ", ncPrice=" + ncPrice +
            ", ncRemark='" + ncRemark + '\'' +
            '}';
  }

  public long getNcId() {
    return ncId;
  }

  public void setNcId(long ncId) {
    this.ncId = ncId;
  }

  public String getNcName() {
    return ncName;
  }

  public void setNcName(String ncName) {
    this.ncName = ncName;
  }

  public double getNcPrice() {
    return ncPrice;
  }

  public void setNcPrice(double ncPrice) {
    this.ncPrice = ncPrice;
  }

  public String getNcRemark() {
    return ncRemark;
  }

  public void setNcRemark(String ncRemark) {
    this.ncRemark = ncRemark;
  }
}
