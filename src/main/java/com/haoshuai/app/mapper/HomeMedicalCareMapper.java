package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.HomeMedicalCare;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomeMedicalCareMapper {
    int addHomeMeicalCare(HomeMedicalCare hmc);
    List getHomeMedicalCareInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllHomeMedicalCareInfo();
    List searchHomeMedicalCareInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") HomeMedicalCare sk);
    List searchAllHomeMedicalCareInfo(@Param("sk") HomeMedicalCare sk);
    int deleteManyHomeMedicalCare(String[] hmcIds);
    HomeMedicalCare homeMedicalCareInfoByhmcId(HomeMedicalCare hmc);
    int modifyHomeMedicalCare(HomeMedicalCare hmc);
    int deleteHomeMedicalCare(HomeMedicalCare hmc);
}
