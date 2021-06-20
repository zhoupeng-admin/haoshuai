package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.SystemMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper {
    public List<SystemMenu> getSystemMenuByStatusAndSort();
}
