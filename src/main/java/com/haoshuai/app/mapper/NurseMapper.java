package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.Nurse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NurseMapper {
    Nurse nurseInfoBynNo(Nurse nurse);
    int addNurse(Nurse nurse);
    List getNurseInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllNurseInfo();
    List searchNurseInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") Nurse sk);
    List searchAllNurseInfo(@Param("sk") Nurse sk);
    int deleteManynurse(String[] nNos);
    int modifyNurse(Nurse nurse);
    int deleteNurse(Nurse nurse);
}
