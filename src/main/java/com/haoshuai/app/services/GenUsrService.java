package com.haoshuai.app.services;

import com.haoshuai.app.entity.*;
import com.haoshuai.app.mapper.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GenUsrService {
    @Resource
    PhysicianMapper physicianMapper;
    @Resource
    NurseMapper nurseMapper;
    @Resource
    PatientMapper patientMapper;
    @Resource
    FamilyPastHistoryMapper familyPastHistoryMapper;
    @Resource
    DependentsMapper dependentsMapper;
    @Resource
    EquipMapper equipMapper;
    @Resource
    EquipMaintenanceMapper equipMaintenanceMapper;
    @Resource
    HomeMedicalCareMapper homeMedicalCareMapper;
    @Resource
    ServiceAgedMapper serviceAgedMapper;
    @Resource
    NutChildMapper nutChildMapper;
    @Resource
    FiscalExpenditureMapper fiscalExpenditureMapper;
    @Resource
    EquipRecycleMapper equipRecycleMapper;

    ResultCode rCode = new ResultCode();

    public StatusCode addPhysician(Physician physician) {
        Physician physician1 = physicianMapper.physicianInfo(physician);
        if (physician1 == null) {
            int i = physicianMapper.addPhysician(physician);
            if (i == 1) {
                return new StatusCode("操作成功", 1);
            } else {
                return new StatusCode("操作失败", 2);
            }
        } else {
            return new StatusCode("医生信息已存在", 0);
        }
    }

    public ResultCode getPhysicianInfo(int page, int limit) {
        List list = physicianMapper.getPhysicianInfo((page - 1) * limit, limit);
        List list1 = physicianMapper.getAllPhysicianInfo();
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setMsg("");
        rCode.setData(list);
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchPhysicianInfo(int page, int limit, Physician physician) {
        List list = physicianMapper.searchPhysicianInfo((page - 1) * limit, limit, physician);
        List list1 = physicianMapper.searchAllPhysicianInfo(physician);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setMsg("");
        rCode.setData(list);
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode deletePhysician(Physician physician) {
        int i = physicianMapper.deletePhysician(physician);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public Physician physicianInfo(Physician physician) {
        return physicianMapper.physicianInfo1(physician);
    }

    public StatusCode modifyPhysicianInfo(Physician physician) {
        int i = physicianMapper.modifyPhysician(physician);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode deleteManyphysician(String[] pNos) {
        int i = physicianMapper.deletemanyPhysician(pNos);
        if (i > 0) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode addNurse(Nurse nurse) {
        Nurse nurse1 = nurseMapper.nurseInfoBynNo(nurse);
        if (nurse1 == null) {
            int i = nurseMapper.addNurse(nurse);
            if (i == 1) {
                return new StatusCode("操作成功", 1);
            } else {
                return new StatusCode("操作失败", 2);
            }
        } else {
            return new StatusCode("护士信息已存在", 0);
        }
    }

    public ResultCode getNurseInfo(int page, int limit) {
        List list = nurseMapper.getNurseInfo((page - 1) * limit, limit);
        List list1 = nurseMapper.getAllNurseInfo();
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchNurseInfo(int page, int limit, Nurse sk) {
        List list = nurseMapper.searchNurseInfo((page - 1) * limit, limit, sk);
        List list1 = nurseMapper.searchAllNurseInfo(sk);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode deleteManynurse(String[] nNos) {
        int i = nurseMapper.deleteManynurse(nNos);
        if (i > 0) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public Nurse nurseInfo(Nurse nurse) {
        return nurseMapper.nurseInfoBynNo(nurse);
    }

    public StatusCode modifyNurse(Nurse nurse) {
        int i = nurseMapper.modifyNurse(nurse);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode deleteNurse(Nurse nurse) {
        int i = nurseMapper.deleteNurse(nurse);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode addPatient(Patient patient, FamilyPastHistory familyPastHistory) {
        Patient patient1 = patientMapper.patientInfoBypIc(patient);
        if (patient1 == null) {
            int i = patientMapper.addPatient(patient);
            familyPastHistory.setpId(patient.getpId());
            int i1 = familyPastHistoryMapper.addPatientFamilyPastHistory(familyPastHistory);
            if (i != 1 && i1 != 1) {
                return new StatusCode("操作失败", 2);
            } else {
                return new StatusCode("操作成功", 1);
            }
        } else {
            return new StatusCode("患者身份证信息已存在", 0);
        }
    }

    public List patientInfo() {
        return patientMapper.allPatientInfo();
    }

    public StatusCode addDependent(Dependents dependents) {
        int i = dependentsMapper.addDependent(dependents);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public ResultCode getPatientInfo(int page, int limit) {
        List list = patientMapper.getPatientInfo((page - 1) * limit, limit);
        System.out.println("list = " + list);
        List list1 = patientMapper.getAllPatientinfo();
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchPatientInfo(int page, int limit, Patient patient) {
        List list = patientMapper.searchPatientInfo((page - 1) * limit, limit, patient);
        List list1 = patientMapper.searchAllPatientInfo(patient);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode deleteManyPatient(String[] pIds) {
        int i = patientMapper.deleteManyPatient(pIds);
        int i1 = dependentsMapper.deleteManyPatientDependent(pIds);
        int i2 = familyPastHistoryMapper.deleteManyPatientFamilyPastHistory(pIds);
        if (i > 0 && i1 > 0 && i2 > 0) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public Patient patientInfo(Patient patient) {
        Patient patient1 = patientMapper.patientInfoBypId(patient);
        FamilyPastHistory familyPastHistory = familyPastHistoryMapper.familyPastHistoryInfoBypId(patient);
        patient1.setFamilyPastHistory(familyPastHistory);
        return patient1;
    }

    public StatusCode modifyPatient(Patient patient, FamilyPastHistory familyPastHistory) {
        Patient patient1 = patientMapper.patientInfoBypId(patient);
        familyPastHistory.setpId(patient.getpId());
        Patient patient2 = patientMapper.checkExistPatient(patient.getpIc(), patient1.getpIc());
        if (patient2 == null) {
            int i = patientMapper.modifyPatient(patient);
            int i1 = familyPastHistoryMapper.modifyPatientFamilyPastHistory(familyPastHistory);
            if (i == 1 && i1 == 1) {
                return new StatusCode("操作成功", 1);
            } else {
                return new StatusCode("操作失败", 2);
            }
        } else {
            return new StatusCode("身份证信息已存在", 0);
        }
    }

    public StatusCode deletePatient(Patient patient) {
        int i = patientMapper.deletePatient(patient);
        int i1 = familyPastHistoryMapper.deletePatientFamilyPastHistory(patient);
        int i2 = dependentsMapper.deletePatientDependent(patient);
        if (i == 1 && i1 == 1 && i2 > 0) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public ResultCode getDependentInfo(int page, int limit) {
        List list = dependentsMapper.getDependentInfo((page - 1) * limit, limit);
        List list1 = dependentsMapper.getAllDependentInfo();
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchDependentInfo(int page, int limit, Dependents dependents) {
        List list = dependentsMapper.searchDependentInfo((page - 1) * limit, limit, dependents);
        List list1 = dependentsMapper.searchAllDependentInfo(dependents);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode deleteManydependent(String[] dIds) {
        int i = dependentsMapper.deleteManydependent(dIds);
        if (i > 0) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public Dependents dependentInfo(Dependents dependents) {
        return dependentsMapper.dependentInfo(dependents);
    }

    public StatusCode modifyDependent(Dependents dependents) {
        int i = dependentsMapper.modifyDependent(dependents);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode deleteDependent(Dependents dependents) {
        int i = dependentsMapper.deleteDependent(dependents);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode addEquip(Equip equip, FiscalExpenditure fe) {
        equip.seteStatus(0);
        equip.seteMaintenance(0);
        equip.seteWhetherSpend(0);
        int i1 = equipMapper.addEquip(equip);
        fe.setFeId(equip.geteId());
        int i = fiscalExpenditureMapper.addFiscalExpenditure(fe);
        if (i1 == 1 && i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public ResultCode getEquipInfo(int page, int limit) {
        List list = equipMapper.getEquipInfo((page - 1) * limit, limit);
        List list1 = equipMapper.getAllEquipInfo();
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setMsg("");
        rCode.setData(list);
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchEquipInfo(int page, int limit, Equip equip) {
        List list = equipMapper.searchEquipInfo((page - 1) * limit, limit, equip);
        List list1 = equipMapper.searchAllEquipInfo(equip);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public Equip equipInfo(Equip equip) {
        return equipMapper.equipInfo(equip);
    }

    public StatusCode modifyEquip(Equip equip) {
        int i = equipMapper.modifyEquip(equip);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public List getAllEquipInfo() {
        return equipMapper.getAllEquipInfo();
    }

    public StatusCode repairEquip(EquipMaintenance equipMaintenance) {
        Equip e = new Equip();
        e.seteId(equipMaintenance.geteId());
        int i = equipMapper.startRepairEquip(e);
        int i1 = equipMaintenanceMapper.startRepairEquip(equipMaintenance);
        if (i == 1 && i1 == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode stopRepairEquip(EquipMaintenance equipMaintenance) {
        Equip e = new Equip();
        e.seteId(equipMaintenance.geteId());
        int i = equipMapper.stopRepairEquip(e);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public ResultCode getEquipMaintenanceInfo(int page, int limit) {
        List list = equipMaintenanceMapper.getEquipMaintenanceInfo((page - 1) * limit, limit);
        List list1 = equipMaintenanceMapper.getAllEquipMaintenanceInfo();
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setMsg("");
        rCode.setData(list);
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchEquipMaintenanceInfo(int page, int limit, EquipMaintenance sk) {
        List list = equipMaintenanceMapper.searchEquipMaintenanceInfo((page - 1) * limit, limit, sk);
        List list1 = equipMaintenanceMapper.searchAllEquipMaintenanceInfo(sk);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode recycleEquip(EquipRecycle er) {
        Equip e = new Equip();
        e.seteId(er.geteId());
        int i = equipMapper.recycleEquip(e);
        int i1 = equipRecycleMapper.addEquipRecycle(er);
        if (i == 1 && i1 == 1) {
            return new StatusCode("操作成功",1);
        }else{
            return new StatusCode("操作失败",2);
        }
    }

    public ResultCode getRecycleEquip(int page, int limit){
        List list = equipRecycleMapper.getRecycleEquipInfo((page-1)*limit,limit);
        List list1 = equipRecycleMapper.getAllRecycleEquipInfo();
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchRecycleEquip(int page, int limit,EquipRecycle sk){
        List list = equipRecycleMapper.searchRecycleEquipInfo((page-1)*limit,limit,sk);
        List list1 = equipRecycleMapper.searchAllRecycleEquipInfo(sk);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode addHomeMedicalCare(HomeMedicalCare hmc) {
        int i = homeMedicalCareMapper.addHomeMeicalCare(hmc);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public ResultCode getHomeMedicalCare(int page, int limit) {
        List list = homeMedicalCareMapper.getHomeMedicalCareInfo((page - 1) * limit, limit);
        List list1 = homeMedicalCareMapper.getAllHomeMedicalCareInfo();
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchHomeMedicalCare(int page, int limit, HomeMedicalCare sk) {
        List list = homeMedicalCareMapper.searchHomeMedicalCareInfo((page - 1) * limit, limit, sk);
        List list1 = homeMedicalCareMapper.searchAllHomeMedicalCareInfo(sk);
        rCode.setCode(0);
        rCode.setData(list);
        rCode.setCount(list1.size());
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode deleteManyHomeMedicalCare(String[] hmcIds) {
        int i = homeMedicalCareMapper.deleteManyHomeMedicalCare(hmcIds);
        if (i > 0) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public HomeMedicalCare getHomeMedicalCareInfo(HomeMedicalCare hmc) {
        return homeMedicalCareMapper.homeMedicalCareInfoByhmcId(hmc);
    }

    public StatusCode modifyHomeMedicalCare(HomeMedicalCare hmc) {
        int i = homeMedicalCareMapper.modifyHomeMedicalCare(hmc);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode deleteHomeMedicalCare(HomeMedicalCare hmc) {
        int i = homeMedicalCareMapper.deleteHomeMedicalCare(hmc);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode addServiceAged(ServiceAged sa) {
        int i = serviceAgedMapper.addServiceAged(sa);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public ResultCode getServiceAged(int page, int limit) {
        List list = serviceAgedMapper.getServiceAgedInfo((page - 1) * limit, limit);
        List list1 = serviceAgedMapper.getAllServiceAgedInfo();
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchServiceAged(int page, int limit, ServiceAged sa) {
        List list = serviceAgedMapper.searchServiceAgedInfo((page - 1) * limit, limit, sa);
        List list1 = serviceAgedMapper.searchAllServiceAgedInfo(sa);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ServiceAged getServiceAgedInfo(ServiceAged sa) {
        return serviceAgedMapper.getServiceAgedInfoBysaId(sa);
    }

    public StatusCode modifyServiceAged(ServiceAged sa) {
        int i = serviceAgedMapper.modifyServiceAgedInfo(sa);
        System.out.println("a" + i);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode deleteManyServiceAged(String[] saIds) {
        int i = serviceAgedMapper.deleteManyServiceAged(saIds);
        if (i > 0) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode deleteServiceAged(ServiceAged sa) {
        int i = serviceAgedMapper.deleteServiceAged(sa);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode addNutChild(NutChild nc) {
        int i = nutChildMapper.addNutChild(nc);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public NutChild getNutChildInfo(NutChild nc) {
        return nutChildMapper.getNutChild(nc);
    }

    public StatusCode modifyNutChild(NutChild nc) {
        int i = nutChildMapper.modifyNutChild(nc);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public ResultCode getNutChild(int page, int limit) {
        List list = nutChildMapper.getNutChildInfo((page - 1) * limit, limit);
        List list1 = nutChildMapper.getAllNutChildInfo();
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchNutChild(int page, int limit, NutChild nc) {
        List list = nutChildMapper.searchNutChildInfo((page - 1) * limit, limit, nc);
        List list1 = nutChildMapper.searchAllNutChildInfo(nc);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode deleteManyNutChild(String[] ncIds) {
        int i = nutChildMapper.deleteManyNutChild(ncIds);
        if (i > 0) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode deleteNutChild(NutChild nc) {
        int i = nutChildMapper.deleteNutChild(nc);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode addFiscalExpenditure(FiscalExpenditure fe, Equip e) {
        System.out.println("aa" + fe.toString());
        int i = fiscalExpenditureMapper.addFiscalExpenditure(fe);
        int i1 = equipMapper.settleEquipFee(e);
        if (i == 1 && i1 == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }
}
