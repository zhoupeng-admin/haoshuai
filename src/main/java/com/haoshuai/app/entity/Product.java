package com.haoshuai.app.entity;


public class Product {

  private String pId;
  private String pName;
  private double pPrice;
  private String pRemark;

  @Override
  public String toString() {
    return "Product{" +
            "pId='" + pId + '\'' +
            ", pName='" + pName + '\'' +
            ", pPrice=" + pPrice +
            ", pRemark='" + pRemark + '\'' +
            '}';
  }

  public String getpId() {
    return pId;
  }

  public void setpId(String pId) {
    this.pId = pId;
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }

  public double getpPrice() {
    return pPrice;
  }

  public void setpPrice(double pPrice) {
    this.pPrice = pPrice;
  }

  public String getpRemark() {
    return pRemark;
  }

  public void setpRemark(String pRemark) {
    this.pRemark = pRemark;
  }
}
