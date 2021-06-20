package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUsrMapper {
    SysUser login(SysUser sysUser);
    SysUser userInfo(SysUser sysUser);
    int modifyInfo(SysUser sysUser);
    int modifyPwd(SysUser sysUser);
    int addUser(SysUser sysUser);
    List getUsrInfo(@Param("page") Integer page, @Param("limit") Integer limit);
    List getAllUsrInfo();
    List searchUsrInfo(@Param("page") Integer page, @Param("limit") Integer limit, @Param("sk") SysUser sk);
    List searchAllUsrInfo(@Param("sk") SysUser sk);
    int activeUser(SysUser sysUser);
    int stopUser(SysUser sysUser);
    int deleteUser(SysUser sysUser);
    int editUser(SysUser sysUser);
    int deleteManyUser(String[] uNames);
}
