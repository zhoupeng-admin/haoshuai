package com.haoshuai.app.entity;


public class SystemMenu {

  private long id;
  private long pid;
  private String title;
  private String icon;
  private String href;
  private String target;
  private long sort;
  private long status;
  private String remark;
  private java.sql.Timestamp createAt;
  private java.sql.Timestamp updateAt;
  private java.sql.Timestamp deleteAt;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }


  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }


  public long getSort() {
    return sort;
  }

  public void setSort(long sort) {
    this.sort = sort;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public java.sql.Timestamp getCreateAt() {
    return createAt;
  }

  public void setCreateAt(java.sql.Timestamp createAt) {
    this.createAt = createAt;
  }


  public java.sql.Timestamp getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(java.sql.Timestamp updateAt) {
    this.updateAt = updateAt;
  }


  public java.sql.Timestamp getDeleteAt() {
    return deleteAt;
  }

  public void setDeleteAt(java.sql.Timestamp deleteAt) {
    this.deleteAt = deleteAt;
  }

  @Override
  public String toString() {
    return "SystemMenu{" +
            "id=" + id +
            ", pid=" + pid +
            ", title='" + title + '\'' +
            ", icon='" + icon + '\'' +
            ", href='" + href + '\'' +
            ", target='" + target + '\'' +
            ", sort=" + sort +
            ", status=" + status +
            ", remark='" + remark + '\'' +
            ", createAt=" + createAt +
            ", updateAt=" + updateAt +
            ", deleteAt=" + deleteAt +
            '}';
  }
}
