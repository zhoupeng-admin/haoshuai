package com.haoshuai.app.services;

import com.haoshuai.app.entity.ResultCode;
import com.haoshuai.app.entity.Staff;
import com.haoshuai.app.entity.StatusCode;
import com.haoshuai.app.mapper.StaffMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HrService {

    @Resource
    StaffMapper staffMapper;

    ResultCode rCode = new ResultCode();

    public StatusCode addStaff(Staff staff){
        Staff staff1 = staffMapper.checkIsExistStaffBysIc(staff);
        if(staff1==null){
            int i = staffMapper.addStaff(staff);
            if (i == 1) {
                return new StatusCode("操作成功",1);
            }else{
                return new StatusCode("操作失败",2);
            }
        }else{
            return new StatusCode("身份证重复",0);
        }
    }

    public ResultCode getStaff(int page, int limit){
        System.out.println(page+","+limit);
        List list = staffMapper.getStaffInfo((page-1)*limit,limit);
        List list1 = staffMapper.getAllStaffInfo();
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if(list1.size() == 0){
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchStaff(int page, int limit, Staff sk){
        List list = staffMapper.searchStaffInfo((page-1)*limit,limit,sk);
        List list1 = staffMapper.searchAllStaffInfo(sk);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if(list1.size() == 0){
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode deleteManyStaff(String[] sIds){
        int i = staffMapper.deleteManyStaff(sIds);
        if (i > 0) {
            return new StatusCode("操作成功",1);
        }else{
            return new StatusCode("操作失败",2);
        }
    }

    public Staff getStaffInfoById(Staff staff){
        return staffMapper.staffInfoById(staff);
    }

    public StatusCode modifyStaff(Staff staff){
        Staff staff1 = staffMapper.staffInfoById(staff);
        Staff staff2 = staffMapper.checkIsExistsIc(staff1.getSIc(), staff.getSIc());
        if(staff2 == null){
            int i = staffMapper.modifyStaff(staff);
            if (i == 1) {
                return new StatusCode("操作成功",1);
            }else{
                return new StatusCode("操作失败",2);
            }
        }else{
            return new StatusCode("身份证重复",0);
        }
    }

    public StatusCode deleteStaff(Staff staff){
        int i = staffMapper.deleteStaff(staff);
        if (i == 1) {
            return new StatusCode("操作成功",1);
        }else{
            return new StatusCode("操作失败",2);
        }
    }
}
