package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.EquipRecycle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EquipRecycleMapper {
    int addEquipRecycle(EquipRecycle er);
    List getRecycleEquipInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllRecycleEquipInfo();
    List searchRecycleEquipInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") EquipRecycle sk);
    List searchAllRecycleEquipInfo(@Param("sk") EquipRecycle sk);
}
