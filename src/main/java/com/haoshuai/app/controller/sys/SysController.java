package com.haoshuai.app.controller.sys;

import com.alibaba.fastjson.JSONArray;
import com.haoshuai.app.entity.*;
import com.haoshuai.app.mapper.PatientMapper;
import com.haoshuai.app.services.SysUsrService;
import com.mysql.cj.xdevapi.JsonArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sys")
public class SysController {
    @Resource
    private SysUsrService sysUsrService;

    @PostMapping(value = "/modify_info.do")
    @ResponseBody
    public StatusCode modifyInfo(SysUser sysUser){
        return sysUsrService.modifyInfo(sysUser);
    }

    @PostMapping(value = "/modify_pwd.do")
    @ResponseBody
    public StatusCode modifyPwd(SysUser sysUser, @RequestParam("oldPwd") String oldPwd){
        System.out.println(oldPwd);
        return sysUsrService.modifyPwd(sysUser,oldPwd);
    }

    @PostMapping(value = "/add_user.do")
    @ResponseBody
    public StatusCode addUser(SysUser sysUser){
        return sysUsrService.addUser(sysUser);
    }

    @GetMapping(value = "/get_usrlist.do")
    @ResponseBody
    public ResultCode getUsrlist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                 @RequestParam(required = false,defaultValue = "15") Integer limit){
        return sysUsrService.getUsrList(page,limit);
    }

    @PostMapping(value = "search_usrlist.do")
    @ResponseBody
    public ResultCode searchUsrlist(@RequestParam(required = false, defaultValue = "1") Integer page,
                                    @RequestParam(required = false, defaultValue = "15") Integer limit,
                                    @Param("sysUser") SysUser sysUser){
        return sysUsrService.searchUsrList(page,limit,sysUser);
    }

    @PostMapping(value = "active_user.do")
    @ResponseBody
    public StatusCode activeUser(SysUser sysUser){
        return sysUsrService.activeUser(sysUser);
    }

    @PostMapping(value = "stop_user.do")
    @ResponseBody
    public StatusCode stopUser(SysUser sysUser){
        return sysUsrService.stopUser(sysUser);
    }

    @PostMapping(value = "delete_user.do")
    @ResponseBody
    public StatusCode deleteUser(SysUser sysUser){
        return sysUsrService.deleteUser(sysUser);
    }

    @PostMapping(value = "edit_user.do")
    @ResponseBody
    public StatusCode editUser(SysUser sysUser){
        return sysUsrService.editUserInfo(sysUser);
    }

    @GetMapping(value = "get_bedlist.do")
    @ResponseBody
    public ResultCode getBedlist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                 @RequestParam(required = false,defaultValue = "15") Integer limit){
        return sysUsrService.getBedInfo(page,limit);
    }

    @PostMapping(value = "delete_manyuser.do")
    @ResponseBody
    public StatusCode deleteManyuser(@RequestParam("ss[]") String[] ss){
        for (String e:
             ss) {
            System.out.println(e);
        }
        return sysUsrService.deleteManyUser(ss);
    }

    @PostMapping(value = "add_bedtype.do")
    @ResponseBody
    public StatusCode addBedtype(Bed bed){
        return sysUsrService.addBedType(bed);
    }

    @PostMapping(value = "search_bedlist.do")
    @ResponseBody
    public ResultCode searchBedlist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                    @RequestParam(required = false,defaultValue = "15") Integer limit,
                                    @Param("sk") Bed sk){

        return sysUsrService.searchBedInfo(page,limit,sk);
    }

    @PostMapping(value = "delete_bed.do")
    @ResponseBody
    public StatusCode deleteBed(Bed bed){
        return sysUsrService.deleteBed(bed);
    }

    @PostMapping(value = "delete_manybed.do")
    @ResponseBody
    public StatusCode deleteManybed(@RequestParam("ss[]") String[] ss){
        return sysUsrService.deleteManybed(ss);
    }

    @PostMapping(value = "modify_bed.do")
    @ResponseBody
    public StatusCode modifyBed(Bed bed){
        return sysUsrService.modifyBed(bed);
    }

    @PostMapping(value = "add_section.do")
    @ResponseBody
    public StatusCode addSection(Section section){
        return sysUsrService.addSection(section);
    }

    @GetMapping(value = "get_sectionlist.do")
    @ResponseBody
    public ResultCode getSectionlist(@RequestParam(required = false,defaultValue = "1") Integer page,
                                     @RequestParam(required = false,defaultValue = "15") Integer limit){
        return sysUsrService.getSectionInfo(page,limit);
    }

    @PostMapping(value = "search_sectionlist.do")
    @ResponseBody
    public ResultCode searchSectionlist(@RequestParam(required = false, defaultValue = "1") Integer page,
                                        @RequestParam(required = false, defaultValue = "15") Integer limit,
                                        @Param("sk") Section sk){
        return sysUsrService.searchSectionInfo(page,limit,sk);
    }

    @PostMapping(value = "delete_section.do")
    @ResponseBody
    public StatusCode deleteSection(Section section){
        return sysUsrService.deleteSection(section);
    }

    @PostMapping(value = "modify_section.do")
    @ResponseBody
    public StatusCode modifySection(Section section){
        return sysUsrService.modifySection(section);
    }

    @PostMapping(value = "delete_manysection.do")
    @ResponseBody
    public StatusCode deleteManysection(@RequestParam("ss[]") String[] ss){
        return sysUsrService.deleteManysection(ss);
    }

}
