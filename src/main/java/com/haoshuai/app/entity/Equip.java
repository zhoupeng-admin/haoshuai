package com.haoshuai.app.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class Equip {

  private String eId;
  private String eName;
  private long eNumber;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private java.sql.Date eFactoryDate;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private java.sql.Date ePurchaseDate;
  private String eFactory;
  private double eUnitPrice;
  private long eStatus;
  private long eMaintenance;
  private long eWhetherSpend;

  @Override
  public String toString() {
    return "Equip{" +
            "eId='" + eId + '\'' +
            ", eName='" + eName + '\'' +
            ", eNumber=" + eNumber +
            ", eFactoryDate=" + eFactoryDate +
            ", ePurchaseDate=" + ePurchaseDate +
            ", eFactory='" + eFactory + '\'' +
            ", eUnitPrice=" + eUnitPrice +
            ", eStatus=" + eStatus +
            ", eMaintenance=" + eMaintenance +
            ", eWhetherSpend=" + eWhetherSpend +
            '}';
  }

  public long geteWhetherSpend() {
    return eWhetherSpend;
  }

  public void seteWhetherSpend(long eWhetherSpend) {
    this.eWhetherSpend = eWhetherSpend;
  }

  public String geteId() {
    return eId;
  }

  public void seteId(String eId) {
    this.eId = eId;
  }

  public String geteName() {
    return eName;
  }

  public void seteName(String eName) {
    this.eName = eName;
  }

  public long geteNumber() {
    return eNumber;
  }

  public void seteNumber(long eNumber) {
    this.eNumber = eNumber;
  }

  public Date geteFactoryDate() {
    return eFactoryDate;
  }

  public void seteFactoryDate(Date eFactoryDate) {
    this.eFactoryDate = eFactoryDate;
  }

  public Date getePurchaseDate() {
    return ePurchaseDate;
  }

  public void setePurchaseDate(Date ePurchaseDate) {
    this.ePurchaseDate = ePurchaseDate;
  }

  public String geteFactory() {
    return eFactory;
  }

  public void seteFactory(String eFactory) {
    this.eFactory = eFactory;
  }

  public double geteUnitPrice() {
    return eUnitPrice;
  }

  public void seteUnitPrice(double eUnitPrice) {
    this.eUnitPrice = eUnitPrice;
  }

  public long geteStatus() {
    return eStatus;
  }

  public void seteStatus(long eStatus) {
    this.eStatus = eStatus;
  }

  public long geteMaintenance() {
    return eMaintenance;
  }

  public void seteMaintenance(long eMaintenance) {
    this.eMaintenance = eMaintenance;
  }
}
