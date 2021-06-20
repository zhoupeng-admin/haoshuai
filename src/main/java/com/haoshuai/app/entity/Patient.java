package com.haoshuai.app.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.util.List;

public class Patient {

  private long pId;
  private String pName;
  private long pGender;
  private String pPhone;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private java.sql.Date pBirth;
  private long pMariage;
  private String pHome;
  private String pDayPhysican;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private java.sql.Date pHealthExamTime;
  private FamilyPastHistory familyPastHistory;
  private List dependents;
  private String dName;
  private String pIc;

  @Override
  public String toString() {
    return "Patient{" +
            "pId=" + pId +
            ", pName='" + pName + '\'' +
            ", pGender=" + pGender +
            ", pPhone='" + pPhone + '\'' +
            ", pBirth=" + pBirth +
            ", pMariage=" + pMariage +
            ", pHome='" + pHome + '\'' +
            ", pDayPhysican='" + pDayPhysican + '\'' +
            ", pHealthExamTime=" + pHealthExamTime +
            ", familyPastHistory=" + familyPastHistory +
            ", dependents=" + dependents +
            ", dName='" + dName + '\'' +
            ", pIc='" + pIc + '\'' +
            '}';
  }

  public long getpId() {
    return pId;
  }

  public void setpId(long pId) {
    this.pId = pId;
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }

  public long getpGender() {
    return pGender;
  }

  public void setpGender(long pGender) {
    this.pGender = pGender;
  }

  public String getpPhone() {
    return pPhone;
  }

  public void setpPhone(String pPhone) {
    this.pPhone = pPhone;
  }

  public Date getpBirth() {
    return pBirth;
  }

  public void setpBirth(Date pBirth) {
    this.pBirth = pBirth;
  }

  public long getpMariage() {
    return pMariage;
  }

  public void setpMariage(long pMariage) {
    this.pMariage = pMariage;
  }

  public String getpHome() {
    return pHome;
  }

  public void setpHome(String pHome) {
    this.pHome = pHome;
  }

  public String getpDayPhysican() {
    return pDayPhysican;
  }

  public void setpDayPhysican(String pDayPhysican) {
    this.pDayPhysican = pDayPhysican;
  }

  public Date getpHealthExamTime() {
    return pHealthExamTime;
  }

  public void setpHealthExamTime(Date pHealthExamTime) {
    this.pHealthExamTime = pHealthExamTime;
  }

  public FamilyPastHistory getFamilyPastHistory() {
    return familyPastHistory;
  }

  public void setFamilyPastHistory(FamilyPastHistory familyPastHistory) {
    this.familyPastHistory = familyPastHistory;
  }

  public List getDependents() {
    return dependents;
  }

  public void setDependents(List dependents) {
    this.dependents = dependents;
  }

  public String getdName() {
    return dName;
  }

  public void setdName(String dName) {
    this.dName = dName;
  }

  public String getpIc() {
    return pIc;
  }

  public void setpIc(String pIc) {
    this.pIc = pIc;
  }
}
