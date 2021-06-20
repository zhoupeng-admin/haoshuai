package com.haoshuai.app.entity;


public class ServiceAged {

  private long saId;
  private String saName;
  private double saPrice;
  private String saRemark;

  @Override
  public String toString() {
    return "ServiceAged{" +
            "saId=" + saId +
            ", saName='" + saName + '\'' +
            ", saPrice=" + saPrice +
            ", saRemark='" + saRemark + '\'' +
            '}';
  }

  public long getSaId() {
    return saId;
  }

  public void setSaId(long saId) {
    this.saId = saId;
  }

  public String getSaName() {
    return saName;
  }

  public void setSaName(String saName) {
    this.saName = saName;
  }

  public double getSaPrice() {
    return saPrice;
  }

  public void setSaPrice(double saPrice) {
    this.saPrice = saPrice;
  }

  public String getSaRemark() {
    return saRemark;
  }

  public void setSaRemark(String saRemark) {
    this.saRemark = saRemark;
  }
}
