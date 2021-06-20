package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.EquipMaintenance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EquipMaintenanceMapper {
    int startRepairEquip(EquipMaintenance equipMaintenance);
    EquipMaintenance getEquipMaintenance(EquipMaintenance em);
    List getEquipMaintenanceInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllEquipMaintenanceInfo();
    List searchEquipMaintenanceInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") EquipMaintenance sk);
    List searchAllEquipMaintenanceInfo(@Param("sk") EquipMaintenance sk);
    int stopRepairEquip(EquipMaintenance equipMaintenance);
}
