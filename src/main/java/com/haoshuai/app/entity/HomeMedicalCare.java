package com.haoshuai.app.entity;


public class HomeMedicalCare {

  private long hmcId;
  private String hmcName;
  private double hmcPrice;
  private String hmcRemark;

  @Override
  public String toString() {
    return "HomeMedicalCare{" +
            "hmcId=" + hmcId +
            ", hmcName='" + hmcName + '\'' +
            ", hmcPrice=" + hmcPrice +
            ", hmcRemark='" + hmcRemark + '\'' +
            '}';
  }

  public long getHmcId() {
    return hmcId;
  }

  public void setHmcId(long hmcId) {
    this.hmcId = hmcId;
  }

  public String getHmcName() {
    return hmcName;
  }

  public void setHmcName(String hmcName) {
    this.hmcName = hmcName;
  }

  public double getHmcPrice() {
    return hmcPrice;
  }

  public void setHmcPrice(double hmcPrice) {
    this.hmcPrice = hmcPrice;
  }

  public String getHmcRemark() {
    return hmcRemark;
  }

  public void setHmcRemark(String hmcRemark) {
    this.hmcRemark = hmcRemark;
  }
}
