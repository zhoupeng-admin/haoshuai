package com.haoshuai.app.entity;


public class Section {

  private long sId;
  private String sNo;
  private String sName;
  private String sCategory;

  @Override
  public String toString() {
    return "Section{" +
            "sId=" + sId +
            ", sNo='" + sNo + '\'' +
            ", sName='" + sName + '\'' +
            ", sCategory='" + sCategory + '\'' +
            '}';
  }

  public long getsId() {
    return sId;
  }

  public void setsId(long sId) {
    this.sId = sId;
  }

  public String getsNo() {
    return sNo;
  }

  public void setsNo(String sNo) {
    this.sNo = sNo;
  }

  public String getsName() {
    return sName;
  }

  public void setsName(String sName) {
    this.sName = sName;
  }

  public String getsCategory() {
    return sCategory;
  }

  public void setsCategory(String sCategory) {
    this.sCategory = sCategory;
  }
}
