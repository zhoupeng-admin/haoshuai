package com.haoshuai.app.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Order {

  private long oId;
  private String oNo;
  private String oPackageId;
  private long oStatus;
  private long oPackageNumbers;
  private double oTotalPrice;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp oTime;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp oPayTime;
  private String oTradeNo;
  private long oPid;
  private String oRemark;
  private Product p;

  @Override
  public String toString() {
    return "Order{" +
            "oId=" + oId +
            ", oNo='" + oNo + '\'' +
            ", oPackageId='" + oPackageId + '\'' +
            ", oStatus=" + oStatus +
            ", oPackageNumbers=" + oPackageNumbers +
            ", oTotalPrice=" + oTotalPrice +
            ", oTime=" + oTime +
            ", oPayTime=" + oPayTime +
            ", oTradeNo='" + oTradeNo + '\'' +
            ", oPid=" + oPid +
            ", oRemark='" + oRemark + '\'' +
            ", p=" + p +
            '}';
  }

  public Product getP() {
    return p;
  }

  public void setP(Product p) {
    this.p = p;
  }

  public long getoId() {
    return oId;
  }

  public void setoId(long oId) {
    this.oId = oId;
  }

  public String getoNo() {
    return oNo;
  }

  public void setoNo(String oNo) {
    this.oNo = oNo;
  }

  public String getoPackageId() {
    return oPackageId;
  }

  public void setoPackageId(String oPackageId) {
    this.oPackageId = oPackageId;
  }

  public long getoStatus() {
    return oStatus;
  }

  public void setoStatus(long oStatus) {
    this.oStatus = oStatus;
  }

  public long getoPackageNumbers() {
    return oPackageNumbers;
  }

  public void setoPackageNumbers(long oPackageNumbers) {
    this.oPackageNumbers = oPackageNumbers;
  }

  public double getoTotalPrice() {
    return oTotalPrice;
  }

  public void setoTotalPrice(double oTotalPrice) {
    this.oTotalPrice = oTotalPrice;
  }

  public Timestamp getoTime() {
    return oTime;
  }

  public void setoTime(Timestamp oTime) {
    this.oTime = oTime;
  }

  public Timestamp getoPayTime() {
    return oPayTime;
  }

  public void setoPayTime(Timestamp oPayTime) {
    this.oPayTime = oPayTime;
  }

  public String getoTradeNo() {
    return oTradeNo;
  }

  public void setoTradeNo(String oTradeNo) {
    this.oTradeNo = oTradeNo;
  }

  public long getoPid() {
    return oPid;
  }

  public void setoPid(long oPid) {
    this.oPid = oPid;
  }

  public String getoRemark() {
    return oRemark;
  }

  public void setoRemark(String oRemark) {
    this.oRemark = oRemark;
  }
}
