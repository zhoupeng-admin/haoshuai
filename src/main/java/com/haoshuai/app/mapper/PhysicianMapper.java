package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.Physician;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PhysicianMapper {
    Physician physicianInfo(Physician physician);
    Physician physicianInfo1(Physician physician);
    int addPhysician(Physician physician);
    List getPhysicianInfo(@Param("page") Integer page, @Param("limit") Integer limit);
    List getAllPhysicianInfo();
    List searchPhysicianInfo(@Param("page") Integer page, @Param("limit") Integer limit,@Param("sk") Physician sk);
    List searchAllPhysicianInfo(@Param("sk") Physician sk);
    int deletePhysician(Physician physician);
    int modifyPhysician(Physician physician);
    int deletemanyPhysician(String[] pNos);
}
