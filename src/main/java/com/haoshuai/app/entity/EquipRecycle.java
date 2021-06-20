package com.haoshuai.app.entity;


public class EquipRecycle {

  private long reId;
  private String eId;
  private String reName;
  private String rePhone;
  private Equip equip;

  @Override
  public String toString() {
    return "EquipRecycle{" +
            "reId=" + reId +
            ", eId='" + eId + '\'' +
            ", reName='" + reName + '\'' +
            ", rePhone='" + rePhone + '\'' +
            ", equip=" + equip +
            '}';
  }

  public Equip getEquip() {
    return equip;
  }

  public void setEquip(Equip equip) {
    this.equip = equip;
  }

  public long getReId() {
    return reId;
  }

  public void setReId(long reId) {
    this.reId = reId;
  }

  public String geteId() {
    return eId;
  }

  public void seteId(String eId) {
    this.eId = eId;
  }

  public String getReName() {
    return reName;
  }

  public void setReName(String reName) {
    this.reName = reName;
  }

  public String getRePhone() {
    return rePhone;
  }

  public void setRePhone(String rePhone) {
    this.rePhone = rePhone;
  }
}
