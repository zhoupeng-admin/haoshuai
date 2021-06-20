package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.Dependents;
import com.haoshuai.app.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DependentsMapper {
    int addDependent(Dependents dependents);
    int deleteManyPatientDependent(String[] pIds);
    int deletePatientDependent(Patient patient);
    List getDependentInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllDependentInfo();
    List searchDependentInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") Dependents sk);
    List searchAllDependentInfo(@Param("sk")Dependents sk);
    int deleteManydependent(String[] dIds);
    Dependents dependentInfo(Dependents dependents);
    int modifyDependent(Dependents dependents);
    int deleteDependent(Dependents dependents);
}
