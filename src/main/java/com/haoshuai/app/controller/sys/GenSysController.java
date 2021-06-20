package com.haoshuai.app.controller.sys;

import com.haoshuai.app.entity.*;
import com.haoshuai.app.services.GenUsrService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/GenSys")
public class GenSysController {
    @Resource
    private GenUsrService genUsrService;

    @PostMapping(value = "add_physician.do")
    @ResponseBody
    public StatusCode addPhysician(Physician physician){
        return genUsrService.addPhysician(physician);
    }

    @GetMapping(value = "get_physicianlist.do")
    @ResponseBody
    public ResultCode getPhysicianlist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                       @RequestParam(required = false,defaultValue = "15") Integer limit){
        return genUsrService.getPhysicianInfo(page,limit);
    }

    @PostMapping(value = "search_physicanlist.do")
    @ResponseBody
    public ResultCode searchPhysicianlist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                          @RequestParam(required = false,defaultValue = "15") Integer limit,
                                          @Param("sk") Physician sk){
        return genUsrService.searchPhysicianInfo(page,limit,sk);
    }

    @PostMapping(value = "delete_physician.do")
    @ResponseBody
    public StatusCode deletePhysician(Physician physician){
        return genUsrService.deletePhysician(physician);
    }

    @PostMapping(value = "modify_physician.do")
    @ResponseBody
    public StatusCode modifyPhysican(Physician physician){
        return genUsrService.modifyPhysicianInfo(physician);
    }

    @PostMapping(value = "delete_manyphysician.do")
    @ResponseBody
    public StatusCode deleteManyphysician(@RequestParam("ss[]") String[] ss){
        return genUsrService.deleteManyphysician(ss);
    }

    @PostMapping(value = "add_nurse.do")
    @ResponseBody
    public StatusCode addNurse(Nurse nurse){
        return genUsrService.addNurse(nurse);
    }

    @GetMapping(value = "get_nurselist.do")
    @ResponseBody
    public ResultCode getNurselist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                   @RequestParam(required = false,defaultValue = "15") Integer limit){
        return genUsrService.getNurseInfo(page,limit);
    }

    @PostMapping(value = "search_nurselist.do")
    @ResponseBody
    public ResultCode searchNurselist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                      @RequestParam(required = false,defaultValue = "15") Integer limit,
                                      @Param("sk") Nurse sk){
        return genUsrService.searchNurseInfo(page,limit,sk);
    }

    @PostMapping(value = "delete_manynurse.do")
    @ResponseBody
    public StatusCode deleteManynurse(@RequestParam("ss[]") String[] ss){
        return genUsrService.deleteManynurse(ss);
    }

    @PostMapping(value = "modify_nurse.do")
    @ResponseBody
    public StatusCode modifyNurse(Nurse nurse){
        return genUsrService.modifyNurse(nurse);
    }

    @PostMapping(value = "delete_nurse.do")
    @ResponseBody
    public StatusCode deleteNurse(Nurse nurse){
        return genUsrService.deleteNurse(nurse);
    }

    @PostMapping(value = "add_patient.do")
    @ResponseBody
    public StatusCode addPatient(Patient patient, FamilyPastHistory familyPastHistory){
        return genUsrService.addPatient(patient,familyPastHistory);
    }

    @PostMapping(value = "add_dependents.do")
    @ResponseBody
    public StatusCode addDependents(Dependents dependents){
        return genUsrService.addDependent(dependents);
    }

    @GetMapping(value = "get_patientlist.do")
    @ResponseBody
    public ResultCode getPatientlist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                     @RequestParam(required = false,defaultValue = "15") Integer limit){
        System.out.println(page+","+limit);
        return genUsrService.getPatientInfo(page,limit);
    }

    @PostMapping(value = "search_patientlist.do")
    @ResponseBody
    public ResultCode searchPatientlist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                        @RequestParam(required = false,defaultValue = "15") Integer limit,
                                        Patient patient){
        System.out.println(patient.toString());
        return genUsrService.searchPatientInfo(page,limit,patient);
    }

    @PostMapping(value = "delete_manypatient.do")
    @ResponseBody
    public StatusCode deleteManypatient(@RequestParam("ss[]") String[] ss){
        return genUsrService.deleteManyPatient(ss);
    }

    @PostMapping(value = "modify_patient.do")
    @ResponseBody
    public StatusCode modifyPatient(Patient patient,FamilyPastHistory familyPastHistory){
        System.out.println(patient.toString());
        return genUsrService.modifyPatient(patient,familyPastHistory);
    }

    @PostMapping(value = "delete_patient.do")
    @ResponseBody
    public StatusCode deletePatient(Patient patient){
        return genUsrService.deletePatient(patient);
    }

    @GetMapping(value = "get_dependentlist.do")
    @ResponseBody
    public ResultCode getDependentlist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                       @RequestParam(required = false,defaultValue = "15") Integer limit){
        return genUsrService.getDependentInfo(page,limit);
    }

    @PostMapping(value = "search_dependentlist.do")
    @ResponseBody
    public ResultCode searchDependentlist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                          @RequestParam(required = false,defaultValue = "15") Integer limit,
                                          @Param("sk") Dependents sk){
        return genUsrService.searchDependentInfo(page,limit,sk);
    }

    @PostMapping(value = "delete_manydependent.do")
    @ResponseBody
    public StatusCode deleteManydependent(@RequestParam("ss[]") String[] ss){
        return genUsrService.deleteManydependent(ss);
    }

    @PostMapping(value = "modify_dependent.do")
    @ResponseBody
    public StatusCode modifyDependent(Dependents dependents){
        return genUsrService.modifyDependent(dependents);
    }

    @PostMapping(value = "delete_dependent.do")
    @ResponseBody
    public StatusCode deleteDependent(Dependents dependents){
        return genUsrService.deleteDependent(dependents);
    }

    @PostMapping(value = "add_equip.do")
    @ResponseBody
    public StatusCode addEquip(Equip equip,FiscalExpenditure fe){
        return genUsrService.addEquip(equip,fe);
    }

    @GetMapping(value = "get_equiplist.do")
    @ResponseBody
    public ResultCode getEquiplsit(@RequestParam(required = false,defaultValue = "1") Integer page,
                                   @RequestParam(required = false,defaultValue = "15") Integer limit){
        return genUsrService.getEquipInfo(page,limit);
    }

    @PostMapping(value = "search_equiplist.do")
    @ResponseBody
    public ResultCode searchEquiplist(@RequestParam(required = false, defaultValue = "1") Integer page,
                                      @RequestParam(required = false,defaultValue = "15") Integer limit,
                                      @Param("sk") Equip sk){
        return genUsrService.searchEquipInfo(page,limit,sk);
    }

    @PostMapping(value = "modify_equip.do")
    @ResponseBody
    public StatusCode modifyEquip(Equip equip){
        return genUsrService.modifyEquip(equip);
    }

    @PostMapping(value = "add_equip_maintenance.do")
    @ResponseBody
    public StatusCode addEquipMaintenance(EquipMaintenance equipMaintenance){
        return genUsrService.repairEquip(equipMaintenance);
    }

    @GetMapping(value = "get_equip_maintenancelist.do")
    @ResponseBody
    public ResultCode getEquipMaintenancelist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                         @RequestParam(required = false,defaultValue = "15") Integer limit){
        return genUsrService.getEquipMaintenanceInfo(page,limit);
    }

    @PostMapping(value = "search_equip_maintenancelist.do")
    @ResponseBody
    public ResultCode searchEquipMaintenancelist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                              @RequestParam(required = false,defaultValue = "15") Integer limit,
                                              @Param("sk") EquipMaintenance sk){
        return genUsrService.searchEquipMaintenanceInfo(page,limit,sk);
    }

    @PostMapping(value = "stop_repair_equip.do")
    @ResponseBody
    public StatusCode stopRepairEquip(EquipMaintenance equipMaintenance){
        return genUsrService.stopRepairEquip(equipMaintenance);
    }

    @PostMapping(value = "recycle_equip.do")
    @ResponseBody
    public StatusCode recycleEquip(EquipRecycle er){
        return genUsrService.recycleEquip(er);
    }

    @GetMapping(value = "get_recycle_equip_list.do")
    @ResponseBody
    public ResultCode getRecycleEquipList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                              @RequestParam(required = false,defaultValue = "15") Integer limit){
        return genUsrService.getRecycleEquip(page,limit);
    }

    @PostMapping(value = "search_recycle_equip_list.do")
    @ResponseBody
    public ResultCode searchRecycleEquipList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                                 @RequestParam(required = false,defaultValue = "15") Integer limit,
                                                 @Param("sk") EquipRecycle sk,
                                             @Param("ss") Equip sk1){
        sk.setEquip(sk1);
        return genUsrService.searchRecycleEquip(page,limit,sk);
    }

    @PostMapping(value = "add_home_medical_care.do")
    @ResponseBody
    public StatusCode addHomeMedicalCare(HomeMedicalCare hmc){
        return genUsrService.addHomeMedicalCare(hmc);
    }

    @GetMapping(value = "get_home_medical_care_list.do")
    @ResponseBody
    public ResultCode getHomeMedicalCareList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                             @RequestParam(required = false,defaultValue = "15") Integer limit){
        return genUsrService.getHomeMedicalCare(page,limit);
    }

    @PostMapping(value = "search_home_medical_care_list.do")
    @ResponseBody
    public ResultCode searchHomeMedicalCareList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                                @RequestParam(required = false,defaultValue = "15") Integer limit,
                                                @Param("sk") HomeMedicalCare sk){
        return genUsrService.searchHomeMedicalCare(page,limit,sk);
    }

    @PostMapping(value = "delete_many_home_medical_care.do")
    @ResponseBody
    public StatusCode deleteManyHomeMedicalCare(@RequestParam("ss[]") String[] ss){
        return genUsrService.deleteManyHomeMedicalCare(ss);
    }

    @PostMapping(value = "modify_home_medical_care.do")
    @ResponseBody
    public StatusCode modifyHomeMedicalCare(HomeMedicalCare hmc){
        return genUsrService.modifyHomeMedicalCare(hmc);
    }

    @PostMapping(value = "delete_home_medical_care.do")
    @ResponseBody
    public StatusCode deleteHomeMedicalCare(HomeMedicalCare hmc){
        return genUsrService.deleteHomeMedicalCare(hmc);
    }

    @PostMapping(value = "add_service_aged.do")
    @ResponseBody
    public StatusCode addServiceAged(ServiceAged sa){
        return genUsrService.addServiceAged(sa);
    }

    @GetMapping(value = "get_service_aged_list.do")
    @ResponseBody
    public ResultCode getServiceAgedList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                             @RequestParam(required = false,defaultValue = "15") Integer limit){
        return genUsrService.getServiceAged(page,limit);
    }

    @PostMapping(value = "search_service_aged_list.do")
    @ResponseBody
    public ResultCode searchServiceAgedList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                                @RequestParam(required = false,defaultValue = "15") Integer limit,
                                                @Param("sk") ServiceAged sk){
        return genUsrService.searchServiceAged(page,limit,sk);
    }

    @PostMapping(value = "modify_service_aged.do")
    @ResponseBody
    public StatusCode modifyServiceAged(ServiceAged sa){
        return genUsrService.modifyServiceAged(sa);
    }

    @PostMapping(value = "delete_many_service_aged.do")
    @ResponseBody
    public StatusCode deleteManyServiceAged(@RequestParam("ss[]") String[] ss){
        return genUsrService.deleteManyServiceAged(ss);
    }

    @PostMapping(value = "delete_service_aged.do")
    @ResponseBody
    public StatusCode deleteServiceAged(ServiceAged sa){
        return genUsrService.deleteServiceAged(sa);
    }

    @PostMapping(value = "add_nut_child.do")
    @ResponseBody
    public StatusCode addNutChild(NutChild nc){
        return genUsrService.addNutChild(nc);
    }

    @PostMapping(value = "modify_nut_child.do")
    @ResponseBody
    public StatusCode modifyNutChild(NutChild nc){
        return genUsrService.modifyNutChild(nc);
    }

    @GetMapping(value = "get_nut_child_list.do")
    @ResponseBody
    public ResultCode getNutChildList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                         @RequestParam(required = false,defaultValue = "15") Integer limit){
        return genUsrService.getNutChild(page,limit);
    }

    @PostMapping(value = "search_nut_child_list.do")
    @ResponseBody
    public ResultCode searchNutChildList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                            @RequestParam(required = false,defaultValue = "15") Integer limit,
                                            @Param("sk") NutChild sk){
        return genUsrService.searchNutChild(page,limit,sk);
    }

    @PostMapping(value = "delete_many_nut_child.do")
    @ResponseBody
    public StatusCode deleteMany(@RequestParam("ss[]") String[] ss){
        return genUsrService.deleteManyNutChild(ss);
    }

    @PostMapping(value = "delete_nut_child.do")
    @ResponseBody
    public StatusCode deleteNutChild(NutChild nc){
        return genUsrService.deleteNutChild(nc);
    }

    @PostMapping(value = "add_equip_maintenance_fee.do")
    @ResponseBody
    public StatusCode addEquipMaintenanceFee(FiscalExpenditure fe, Equip e){
        System.out.println(fe.toString());
        return genUsrService.addFiscalExpenditure(fe,e);
    }


}
