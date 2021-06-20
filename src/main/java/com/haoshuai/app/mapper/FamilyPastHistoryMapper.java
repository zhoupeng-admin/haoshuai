package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.FamilyPastHistory;
import com.haoshuai.app.entity.Patient;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FamilyPastHistoryMapper {
    int addPatientFamilyPastHistory(FamilyPastHistory familyPastHistory);
    int deleteManyPatientFamilyPastHistory(String[] pIds);
    FamilyPastHistory familyPastHistoryInfoBypId(Patient patient);
    int modifyPatientFamilyPastHistory(FamilyPastHistory familyPastHistory);
    int deletePatientFamilyPastHistory(Patient patient);
}
