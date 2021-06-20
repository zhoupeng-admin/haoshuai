package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.NutChild;
import com.haoshuai.app.entity.ServiceAged;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NutChildMapper {
    int addNutChild(NutChild nc);
    NutChild getNutChild(NutChild nc);
    int modifyNutChild(NutChild nc);
    List getNutChildInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllNutChildInfo();
    List searchNutChildInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") NutChild sk);
    List searchAllNutChildInfo(@Param("sk") NutChild sk);
    int deleteManyNutChild(String[] ncIds);
    int deleteNutChild(NutChild nc);
}
