package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StaffMapper {
    int addStaff(Staff staff);
    Staff checkIsExistStaffBysIc(Staff staff);
    List getStaffInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllStaffInfo();
    List searchStaffInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") Staff sk);
    List searchAllStaffInfo(@Param("sk") Staff sk);
    int deleteManyStaff(String[] sIds);
    Staff checkIsExistsIc(String sIc1,String sIc2);
    Staff staffInfoById(Staff staff);
    int modifyStaff(Staff staff);
    int deleteStaff(Staff staff);
}
