package com.haoshuai.app.entity;


import java.sql.Timestamp;

public class FiscalExpenditure {

  private String feId;
  private long feType;
  private String feOperator;
  private java.sql.Timestamp feOperateTime;
  private double fePrice;
  private String feIntoCount;
  private String feOutCount;
  private String feRemark;
  private long feSpendType;

  public String getFeId() {
    return feId;
  }

  public void setFeId(String feId) {
    this.feId = feId;
  }

  public long getFeType() {
    return feType;
  }

  public void setFeType(long feType) {
    this.feType = feType;
  }

  public String getFeOperator() {
    return feOperator;
  }

  public void setFeOperator(String feOperator) {
    this.feOperator = feOperator;
  }

  public Timestamp getFeOperateTime() {
    return feOperateTime;
  }

  public void setFeOperateTime(Timestamp feOperateTime) {
    this.feOperateTime = feOperateTime;
  }

  public double getFePrice() {
    return fePrice;
  }

  public void setFePrice(double fePrice) {
    this.fePrice = fePrice;
  }

  public String getFeIntoCount() {
    return feIntoCount;
  }

  public void setFeIntoCount(String feIntoCount) {
    this.feIntoCount = feIntoCount;
  }

  public String getFeOutCount() {
    return feOutCount;
  }

  public void setFeOutCount(String feOutCount) {
    this.feOutCount = feOutCount;
  }

  public String getFeRemark() {
    return feRemark;
  }

  public void setFeRemark(String feRemark) {
    this.feRemark = feRemark;
  }

  public long getFeSpendType() {
    return feSpendType;
  }

  public void setFeSpendType(long feSpendType) {
    this.feSpendType = feSpendType;
  }

  @Override
  public String toString() {
    return "FiscalExpenditure{" +
            "feId='" + feId + '\'' +
            ", feType=" + feType +
            ", feOperator='" + feOperator + '\'' +
            ", feOperateTime=" + feOperateTime +
            ", fePrice=" + fePrice +
            ", feIntoCount='" + feIntoCount + '\'' +
            ", feOutCount='" + feOutCount + '\'' +
            ", feRemark='" + feRemark + '\'' +
            ", feSpendType=" + feSpendType +
            '}';
  }
}
