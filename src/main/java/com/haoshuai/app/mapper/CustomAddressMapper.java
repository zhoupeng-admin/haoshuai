package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.Custom;
import com.haoshuai.app.entity.CustomAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomAddressMapper {
    int addAddress(CustomAddress ca);
    List getAllAddress(Custom c);
    CustomAddress getAddressInfo(CustomAddress ca);
    int modifyAddress(CustomAddress ca);
    int deleteAddress(CustomAddress ca);
}
