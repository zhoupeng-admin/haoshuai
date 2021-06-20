package com.haoshuai.app.entity;


import org.springframework.format.annotation.NumberFormat;

public class Bed {

  private long bId;
  private String bType;
  private Double bPrice;


  public long getbId() {
    return bId;
  }

  public void setbId(long bId) {
    this.bId = bId;
  }

  public String getbType() {
    return bType;
  }

  public void setbType(String bType) {
    this.bType = bType;
  }

  public Double getbPrice() {
    return bPrice;
  }

  public void setbPrice(Double bPrice) {
    this.bPrice = bPrice;
  }

  @Override
  public String toString() {
    return "Bed{" +
            "bId=" + bId +
            ", bType='" + bType + '\'' +
            ", bPrice=" + bPrice +
            '}';
  }
}
