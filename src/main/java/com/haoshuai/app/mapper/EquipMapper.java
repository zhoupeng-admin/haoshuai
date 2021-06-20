package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.Equip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EquipMapper {
    int addEquip(Equip equip);
    List getEquipInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllEquipInfo();
    List searchEquipInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") Equip sk);
    List searchAllEquipInfo(@Param("sk") Equip sk);
    Equip equipInfo(Equip equip);
    int modifyEquip(Equip equip);
    int startRepairEquip(Equip equip);
    int stopRepairEquip(Equip equip);
    int settleEquipFee(Equip equip);
    int recycleEquip(Equip equip);
}
