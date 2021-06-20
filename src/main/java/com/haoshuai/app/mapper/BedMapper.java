package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.Bed;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BedMapper {
    //获取床位类型信息
    Bed bedInfo(Bed bed);
    //通过id获取床位类型信息
    Bed bedInfoById(Bed bed);
    //判断修改床位信息是否存在
    Bed checIsExistBed(String bType,String bType1);
    //获取所有床位信息并分页
    List getBedInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllBedInfo();
    //根据查询内容获取床位信息并分页
    List searchBedInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") Bed sk);
    List searchAllBedInfo(@Param("sk") Bed sk);
    //添加床位信息
    int addBed(Bed bed);
    //删除床位信息
    int deleteBed(Bed bed);
    //批量删除床位信息
    int deleteManyBed(String[] bedTypes);
    //编辑床位信息
    int modifyBed(Bed bed);
}
