package com.haoshuai.app.entity;


public class FamilyPastHistory {

  private long pId;
  private String pFamilyHistory;
  private String pPastMedicalHistory;
  private String pAllergicHistory;

  @Override
  public String toString() {
    return "FamilyPastHistory{" +
            "pId=" + pId +
            ", pFamilyHistory='" + pFamilyHistory + '\'' +
            ", pPastMedicalHistory='" + pPastMedicalHistory + '\'' +
            ", pAllergicHistory='" + pAllergicHistory + '\'' +
            '}';
  }

  public long getpId() {
    return pId;
  }

  public void setpId(long pId) {
    this.pId = pId;
  }

  public String getpFamilyHistory() {
    return pFamilyHistory;
  }

  public void setpFamilyHistory(String pFamilyHistory) {
    this.pFamilyHistory = pFamilyHistory;
  }

  public String getpPastMedicalHistory() {
    return pPastMedicalHistory;
  }

  public void setpPastMedicalHistory(String pPastMedicalHistory) {
    this.pPastMedicalHistory = pPastMedicalHistory;
  }

  public String getpAllergicHistory() {
    return pAllergicHistory;
  }

  public void setpAllergicHistory(String pAllergicHistory) {
    this.pAllergicHistory = pAllergicHistory;
  }
}
