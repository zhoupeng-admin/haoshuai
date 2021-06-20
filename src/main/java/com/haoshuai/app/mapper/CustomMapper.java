package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.Custom;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomMapper {
    Custom getCustomByPhone(Custom custom);
    Custom getCustomById(Custom custom);
    int addCustom(Custom custom);
    Custom login(Custom custom);
    int findPwd(Custom custom);
    int modifyCustom(Custom custom);
    int modifyPwd(Custom custom);
}
