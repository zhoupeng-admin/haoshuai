package com.haoshuai.app.controller.sys;

import com.haoshuai.app.entity.ResultCode;
import com.haoshuai.app.entity.Staff;
import com.haoshuai.app.entity.StatusCode;
import com.haoshuai.app.services.HrService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/Hr")
public class HrController {
    @Resource
    HrService hrService;

    @PostMapping(value = "add_staff.do")
    @ResponseBody
    public StatusCode addStaff(Staff staff){
        return hrService.addStaff(staff);
    }

    @GetMapping(value = "get_staff_list.do")
    @ResponseBody
    public ResultCode getStaffList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                   @RequestParam(required = false,defaultValue = "15") Integer limit){
        System.out.println(page+" "+limit);
        return hrService.getStaff(page,limit);
    }

    @PostMapping(value = "search_staff_list.do")
    @ResponseBody
    public ResultCode searchStaffList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                      @RequestParam(required = false,defaultValue = "15") Integer limit,
                                      @Param("sk") Staff sk){
        return hrService.searchStaff(page,limit,sk);
    }

    @PostMapping(value = "delete_many_staff.do")
    @ResponseBody
    public StatusCode deleteManyStaff(@RequestParam("ss[]") String[] ss){
        return hrService.deleteManyStaff(ss);
    }

    @PostMapping(value = "modify_staff.do")
    @ResponseBody
    public StatusCode modifyStaff(Staff staff){
        return hrService.modifyStaff(staff);
    }

    @PostMapping(value = "delete_staff.do")
    @ResponseBody
    public StatusCode deleteStaff(Staff staff){
        return hrService.deleteStaff(staff);
    }

}
