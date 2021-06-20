package com.haoshuai.app.controller.backstage;

import com.haoshuai.app.entity.*;
import com.haoshuai.app.services.*;
import com.haoshuai.app.utils.KaptchaCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/bs")
public class CommonController {

    private Model model = null;

    @Resource
    private SysMenuService sysMenuService;
    @Resource
    private SysUsrService sysUsrService;
    @Resource
    private GenUsrService genUsrService;
    @Resource
    private HrService hrService;
    @Resource
    private FinanceService financeService;

    //渲染图片验证码
    @RequestMapping(value = "/getCode", method = RequestMethod.GET)
    @ResponseBody
    public void getCode(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        KaptchaCode kaptchaCode = new KaptchaCode();
        kaptchaCode.getRandcode(request, response);
    }

    @RequestMapping("/logins")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/menu")
    @ResponseBody
    public Map<String,Object> menu(HttpServletRequest req){
        HttpSession session = req.getSession();
        Long sSurid = ((SysUser)(session.getAttribute("usrInfo"))).getsSurid();
        return sysMenuService.menu(sSurid);
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @PostMapping("/login.do")
    @ResponseBody
    public StatusCode loginAction(SysUser sysUser,HttpServletRequest req,String code){
        HttpSession session = req.getSession();
        return sysUsrService.login(sysUser,session,code);
    }

    @GetMapping(value = "user_setting")
    public String userSetting(HttpServletRequest req, Model model){
        SysUser sysUser = sysUsrService.userInfo(req);
        model.addAttribute("userInfo",sysUser);
        return "user_setting";
    }

    @GetMapping(value = "user_password")
    public String userPassword(){
        return "user_password";
    }

    @GetMapping(value = "exit")
    public String exit(HttpServletRequest req){
        HttpSession session = req.getSession();
        session.setAttribute("usrInfo",null);
        return "login";
    }

    @GetMapping(value = "/user_manage")
    public String userControl(){
        return "sys/user/user_manage";
    }

    @GetMapping(value = "/add_user")
    public String addUser(){
        return "sys/user/user_add";
    }

    @GetMapping(value = "/edit_user")
    public String editUser(SysUser sysUser, Model model){
        SysUser userInfo = sysUsrService.getUserInfo(sysUser);
        model.addAttribute("userInfo",userInfo);
        return "sys/user/user_edit";
    }

    @GetMapping(value = "/bed_manage")
    public String bedManage(){
        return "sys/bed/bed_manage";
    }

    @GetMapping(value = "/bed_add")
    public String bedAdd(){
        return "sys/bed/bed_add";
    }

    @GetMapping(value = "/edit_bed")
    public String editBed(Bed bed, Model model){
        Bed bed1 = sysUsrService.bedInfo(bed);
        model.addAttribute("bedInfo",bed1);
        return "sys/bed/bed_edit";
    }

    @GetMapping(value = "/section_manage")
    public String sectionManage(){
        return "sys/section/section_manage";
    }

    @GetMapping(value = "/section_add")
    public String sectionAdd(){
        return "sys/section/section_add";
    }

    @GetMapping(value = "/section_edit")
    public String sectionEdit(Section section, Model model){
        Section section1 = sysUsrService.sectionInfo(section);
        model.addAttribute("sectionInfo",section1);
        return "sys/section/section_edit";
    }

    @GetMapping(value = "/physician_manage")
    public String physicianManage(Model model){
        List list = sysUsrService.allSectionInfo();
        model.addAttribute("sectionInfo",list);
        return "hr/physican/physician_manage";
    }

    @GetMapping(value = "/physician_add")
    public String physicianAdd(Model model){
        List list = sysUsrService.allSectionInfo();
        model.addAttribute("sectionInfo",list);
        return "hr/physican/physician_add";
    }

    @GetMapping(value = "/physician_edit")
    public String physicianEdit(Model model, Physician physician){
        Physician physician1 = genUsrService.physicianInfo(physician);
        model.addAttribute("pInfo",physician1);
        return "hr/physican/physician_edit";
    }

    @GetMapping(value = "/nurse_manage")
    public String nurseManage(){
        return "hr/nurse/nurse_manage";
    }

    @GetMapping(value = "/nurse_add")
    public String nurseAdd(){
        return "hr/nurse/nurse_add";
    }

    @GetMapping(value = "/nurse_edit")
    public String nurseEdit(Nurse nurse, Model model){
        Nurse nurse1 = genUsrService.nurseInfo(nurse);
        model.addAttribute("nInfo",nurse1);
        return "hr/nurse/nurse_edit";
    }

    @GetMapping(value = "/patient_add")
    public String patientInfoManage(){
        return "gen/patient/patient_add";
    }

    @GetMapping(value = "/patient_manage")
    public String patientManage(){
        return "gen/patient/patient_manage";
    }

    @GetMapping(value = "/dependents_manage")
    public String dependentsManage(){
        return "gen/dependent/dependents_manage";
    }

    @GetMapping(value = "/dependent_add")
    public String dependentAdd(Model model){
        List list = genUsrService.patientInfo();
        model.addAttribute("pInfo",list);
        return "gen/dependent/dependent_add";
    }

    @GetMapping(value = "/patient_edit")
    public String patientEdit(Model model,Patient patient){
        List<String> list = new ArrayList<String>();
        Patient patient1 = genUsrService.patientInfo(patient);
        String[] pfh = {"高血压","糖尿病","高尿酸血症/痛风","心脏病","中风","肾病","胃炎/胃溃疡","癌症","哮喘","慢阻肺","抑郁症","肝炎"};
        String[] pmh = {"高血压","糖尿病","高脂血症","高尿酸血症/痛风","脑梗死","冠心病","心律失常","肾病","胃炎/胃溃疡","肝炎","癌症","哮喘","慢阻肺","甲亢/甲减","抑郁症","焦虑","失眠","骨质疏松"};
        List<String> pfhList = Arrays.asList(pfh);
        List<String> pmhList = Arrays.asList(pmh);
        List<String> list1 = patient1.getFamilyPastHistory().getpFamilyHistory()==null ? list : Arrays.asList((patient1.getFamilyPastHistory().getpFamilyHistory()).split(","));
        List<String> list2 = patient1.getFamilyPastHistory().getpPastMedicalHistory()==null ? list :Arrays.asList((patient1.getFamilyPastHistory().getpPastMedicalHistory()).split(","));
        model.addAttribute("pfhList",pfhList);
        model.addAttribute("pmhList",pmhList);
        model.addAttribute("pfhInfo",list1);
        model.addAttribute("pmhInfo",list2);
        model.addAttribute("pInfo",patient1);
        return "gen/patient/patient_edit";
    }

    @GetMapping(value = "/dependent_edit")
    public String dependentEdit(Model model,Dependents dependents){
        Dependents dependents1 = genUsrService.dependentInfo(dependents);
        List list = genUsrService.patientInfo();
        model.addAttribute("pInfo",list);
        model.addAttribute("dInfo",dependents1);
        return "gen/dependent/dependent_edit";
    }

    @GetMapping(value = "/equip_manage")
    public String equipManage(){
        return "gen/equip/equip_manage";
    }

    @GetMapping(value = "/equip_add")
    public String equipAdd(){
        return "gen/equip/equip_add";
    }

    @GetMapping(value = "/equip_edit")
    public String equipEdit(Model model,Equip equip){
        Equip equip1 = genUsrService.equipInfo(equip);
        model.addAttribute("eInfo",equip1);
        return "gen/equip/equip_edit";
    }

    @GetMapping(value = "/equip_maintenance")
    public String equipMaintenance(){
        return "gen/equip/equip_maintenance";
    }

    @GetMapping(value = "/equip_maintenance_add")
    public String equipMaintenanceAdd(Model model){
        List allEquipInfo = genUsrService.getAllEquipInfo();
        model.addAttribute("aEInfo",allEquipInfo);
        return "gen/equip/equip_maintenance_add";
    }

    @GetMapping(value = "/home_medical_care")
    public String homeMedicalCare(){
        return "gen/service/home_medical_care";
    }

    @GetMapping(value = "/home_medical_care_add")
    public String homeMedicalCareAdd(){
        return "gen/service/home_medical_care_add";
    }

    @GetMapping(value = "/home_medical_care_edit")
    public String homeMedicalCareEdit(Model model, HomeMedicalCare hmc){
        HomeMedicalCare homeMedicalCareInfo = genUsrService.getHomeMedicalCareInfo(hmc);
        model.addAttribute("hmcInfo",homeMedicalCareInfo);
        return "gen/service/home_medical_care_edit";
    }

    @GetMapping(value = "/service_aged")
    public String serviceAged(){
        return "gen/service/service_aged";
    }

    @GetMapping(value = "/service_aged_add")
    public String serviceAgedAdd(){
        return "gen/service/service_aged_add";
    }

    @GetMapping(value = "/service_aged_edit")
    public String serviceAgedEdit(Model model, ServiceAged sa){
        ServiceAged serviceAgedInfo = genUsrService.getServiceAgedInfo(sa);
        model.addAttribute("saInfo",serviceAgedInfo);
        return "gen/service/service_aged_edit";
    }

    @GetMapping(value = "/nut_child")
    public String nutChild(){
        return "gen/service/nut_child";
    }

    @GetMapping(value = "/nut_child_add")
    public String nutChildAdd(){
        return "gen/service/nut_child_add";
    }

    @GetMapping(value = "/nut_child_edit")
    public String nutChildEdit(Model model, NutChild nc){
        NutChild nutChildInfo = genUsrService.getNutChildInfo(nc);
        model.addAttribute("ncInfo",nutChildInfo);
        return "gen/service/nut_child_edit";
    }

    @GetMapping(value = "/equip_maintenance_fee_add")
    public String equipMaintenanceFeeAdd(Model model,EquipMaintenance em){
        model.addAttribute("emInfo",em);
        return "gen/equip/equip_maintenance_fee_add";
    }

    @GetMapping(value = "/equip_recycle_manage")
    public String equipRecycleManage(){
        return "gen/equip/equip_recycle_manage";
    }

    @GetMapping(value = "/equip_recycle_add")
    public String equipRecycleAdd(Model model){
        List allEquipInfo = genUsrService.getAllEquipInfo();
        model.addAttribute("allEInfo",allEquipInfo);
        return "gen/equip/equip_recycle_add";
    }

    @GetMapping(value = "/staff_manage")
    public String staffManage(){
        return "hr/staff/staff_manage";
    }

    @GetMapping(value = "/staff_add")
    public String staffAdd(){
        return "hr/staff/staff_add";
    }

    @GetMapping(value = "/staff_edit")
    public String staffEdit(Model model, Staff staff){
        Staff staffInfoById = hrService.getStaffInfoById(staff);
        model.addAttribute("sInfo",staffInfoById);
        return "hr/staff/staff_edit";
    }

    @GetMapping(value = "/income_expense_manage")
    public String incomeExpenseManage(){
        return "fc/finance/income_expense_manage";
    }

    @GetMapping(value = "/order_manage")
    public String orderManage(){
        return "fc/finance/order_manage";
    }


}
