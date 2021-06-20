package com.haoshuai.app.entity;


import com.haoshuai.app.entity.SysUserRole;

public class SysUser {

  private long sUid;
  private String sUname;
  private String sUpwd;
  private String sCname;
  private long sUgender;
  private String sUphone;
  private long sUstatus;
  private long sWstatus;
  private long sSurid;
  private SysUserRole sysUserRole;

  public long getsUid() {
    return sUid;
  }

  public void setsUid(long sUid) {
    this.sUid = sUid;
  }

  public String getsUname() {
    return sUname;
  }

  public void setsUname(String sUname) {
    this.sUname = sUname;
  }

  public String getsUpwd() {
    return sUpwd;
  }

  public void setsUpwd(String sUpwd) {
    this.sUpwd = sUpwd;
  }

  public String getsCname() {
    return sCname;
  }

  public void setsCname(String sCname) {
    this.sCname = sCname;
  }

  public long getsUgender() {
    return sUgender;
  }

  public void setsUgender(long sUgender) {
    this.sUgender = sUgender;
  }

  public String getsUphone() {
    return sUphone;
  }

  public void setsUphone(String sUphone) {
    this.sUphone = sUphone;
  }

  public long getsUstatus() {
    return sUstatus;
  }

  public void setsUstatus(long sUstatus) {
    this.sUstatus = sUstatus;
  }

  public long getsWstatus() {
    return sWstatus;
  }

  public void setsWstatus(long sWstatus) {
    this.sWstatus = sWstatus;
  }

  public long getsSurid() {
    return sSurid;
  }

  public void setsSurid(long sSurid) {
    this.sSurid = sSurid;
  }

  public SysUserRole getSysUserRole() {
    return sysUserRole;
  }

  public void setSysUserRole(SysUserRole sysUserRole) {
    this.sysUserRole = sysUserRole;
  }

  @Override
  public String toString() {
    return "SysUser{" +
            "sUid=" + sUid +
            ", sUname='" + sUname + '\'' +
            ", sUpwd='" + sUpwd + '\'' +
            ", sCname='" + sCname + '\'' +
            ", sUgender=" + sUgender +
            ", sUphone='" + sUphone + '\'' +
            ", sUstatus=" + sUstatus +
            ", sWstatus=" + sWstatus +
            ", sSurid=" + sSurid +
            ", sysUserRole=" + sysUserRole +
            '}';
  }
}
