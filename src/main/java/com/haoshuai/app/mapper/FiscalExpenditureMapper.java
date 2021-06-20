package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.FiscalExpenditure;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FiscalExpenditureMapper {
    int addFiscalExpenditure(FiscalExpenditure fe);
    List getFEInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllFEInfo();
    List searchFEInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") FiscalExpenditure sk);
    List searchAllFEInfo(@Param("sk") FiscalExpenditure sk);
}
