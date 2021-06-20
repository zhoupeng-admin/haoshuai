package com.haoshuai.app.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class EquipMaintenance {

  private String emId;
  private String eId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp emBeginTime;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private java.sql.Timestamp emEndTime;
  private String emPhone;
  private String eName;
  private Equip equip;

  @Override
  public String toString() {
    return "EquipMaintenance{" +
            "emId='" + emId + '\'' +
            ", eId='" + eId + '\'' +
            ", emBeginTime=" + emBeginTime +
            ", emEndTime=" + emEndTime +
            ", emPhone='" + emPhone + '\'' +
            ", eName='" + eName + '\'' +
            ", equip=" + equip +
            '}';
  }

  public Equip getEquip() {
    return equip;
  }

  public void setEquip(Equip equip) {
    this.equip = equip;
  }

  public String geteName() {
    return eName;
  }

  public void seteName(String eName) {
    this.eName = eName;
  }

  public String getEmId() {
    return emId;
  }

  public void setEmId(String emId) {
    this.emId = emId;
  }

  public String geteId() {
    return eId;
  }

  public void seteId(String eId) {
    this.eId = eId;
  }

  public Timestamp getEmBeginTime() {
    return emBeginTime;
  }

  public void setEmBeginTime(Timestamp emBeginTime) {
    this.emBeginTime = emBeginTime;
  }

  public Timestamp getEmEndTime() {
    return emEndTime;
  }

  public void setEmEndTime(Timestamp emEndTime) {
    this.emEndTime = emEndTime;
  }

  public String getEmPhone() {
    return emPhone;
  }

  public void setEmPhone(String emPhone) {
    this.emPhone = emPhone;
  }
}
