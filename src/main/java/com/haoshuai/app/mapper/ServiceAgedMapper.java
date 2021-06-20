package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.ServiceAged;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ServiceAgedMapper {
    int addServiceAged(ServiceAged sa);
    List getServiceAgedInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllServiceAgedInfo();
    List searchServiceAgedInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") ServiceAged sk);
    List searchAllServiceAgedInfo(@Param("sk") ServiceAged sk);
    ServiceAged getServiceAgedInfoBysaId(ServiceAged sa);
    int modifyServiceAgedInfo(ServiceAged sa);
    int deleteManyServiceAged(String[] saIds);
    int deleteServiceAged(ServiceAged sa);
}
