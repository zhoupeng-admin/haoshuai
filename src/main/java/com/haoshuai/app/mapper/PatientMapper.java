package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PatientMapper {
    int addPatient(Patient patient);
    List allPatientInfo();
    List getPatientInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllPatientinfo();
    List searchPatientInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") Patient patient);
    List searchAllPatientInfo(@Param("sk") Patient sk);
    int deleteManyPatient(String[] pIds);
    Patient patientInfoBypId(Patient patient);
    Patient checkExistPatient(String pIc1,String pIc2);
    Patient patientInfoBypIc(Patient patient);
    int modifyPatient(Patient patient);
    int deletePatient(Patient patient);
}
