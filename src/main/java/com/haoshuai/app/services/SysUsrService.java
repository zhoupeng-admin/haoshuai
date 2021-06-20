package com.haoshuai.app.services;

import com.haoshuai.app.entity.*;
import com.haoshuai.app.mapper.*;
import com.haoshuai.app.utils.PasswordEncode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class SysUsrService {

    public static final String RANDOMCODEKEY = "randomcode_key";

    @Resource
    SysUsrMapper sysUsrMapper;
    @Resource
    BedMapper bedMapper;
    @Resource
    SectionMapper sectionMapper;

    PasswordEncode md5 = new PasswordEncode();
    ResultCode rCode = new ResultCode();

    public StatusCode login(SysUser sys, HttpSession session, String code) {
        SysUser sys1 = sysUsrMapper.login(sys);

        if (!(code.equalsIgnoreCase((String) session.getAttribute(RANDOMCODEKEY)))) {
            return new StatusCode("验证码错误!", 0);
        } else if ((sys1 == null) || (!(md5.encode(sys.getsUpwd())).equals(sys1.getsUpwd()))) {
            return new StatusCode("用户名或密码错误!", 2);
        } else if (sys1.getsUstatus() == 1) {
            return new StatusCode("用户已停用!", 2);
        } else {
            session.setAttribute("usrInfo", sys1);
            return new StatusCode("登陆成功!", 1);
        }
    }

    public SysUser userInfo(HttpServletRequest req) {
        HttpSession session = req.getSession();
        SysUser usrInfo = (SysUser) (session.getAttribute("usrInfo"));
        return sysUsrMapper.userInfo(usrInfo);
    }

    public StatusCode modifyInfo(SysUser sysUser) {
        int i = sysUsrMapper.modifyInfo(sysUser);
        if (i == 1) {
            return new StatusCode("操作成功!", 1);
        } else {
            return new StatusCode("操作失败!", 2);
        }
    }

    public StatusCode modifyPwd(SysUser sysUser, String old_pwd) {
        SysUser sysUser1 = sysUsrMapper.userInfo(sysUser);
        sysUser.setsUpwd(md5.encode(sysUser.getsUpwd()));
        if ((md5.encode(old_pwd)).equals(sysUser1.getsUpwd())) {
            int i = sysUsrMapper.modifyPwd(sysUser);
            if (i == 1) {
                return new StatusCode("操作成功", 1);
            } else {
                return new StatusCode("操作失败", 2);
            }
        } else {
            return new StatusCode("旧密码错误", 0);
        }
    }

    public StatusCode addUser(SysUser sysUser) {
        SysUser sysUser1 = sysUsrMapper.userInfo(sysUser);
        if (sysUser1 == null) {
            sysUser.setsUstatus(1);
            sysUser.setsUpwd(md5.encode("123456"));
            System.out.println(sysUser.toString());
            int i = sysUsrMapper.addUser(sysUser);
            if (i == 1) {
                return new StatusCode("操作成功", 1);
            } else {
                return new StatusCode("操作失败", 2);
            }
        } else {
            return new StatusCode("用户已存在", 0);
        }
    }

    public ResultCode getUsrList(Integer page, Integer limit) {
        List list1 = sysUsrMapper.getUsrInfo((page - 1) * limit, limit);
        List list2 = sysUsrMapper.getAllUsrInfo();
        rCode.setCode(0);
        rCode.setData(list1);
        rCode.setCount(list2.size());
        rCode.setMsg("");
        if (list2.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchUsrList(Integer page, Integer limit, SysUser sysUser) {
        List list1 = sysUsrMapper.searchUsrInfo((page - 1) * limit, limit, sysUser);
        List list2 = sysUsrMapper.searchAllUsrInfo(sysUser);
        rCode.setCount(0);
        rCode.setData(list1);
        rCode.setCount(list2.size());
        rCode.setMsg("");
        if (list2.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode activeUser(SysUser sysUser) {
        int i = sysUsrMapper.activeUser(sysUser);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode stopUser(SysUser sysUser) {
        int i = sysUsrMapper.stopUser(sysUser);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode deleteUser(SysUser sysUser) {
        int i = sysUsrMapper.deleteUser(sysUser);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public SysUser getUserInfo(SysUser sysUser) {
        return sysUsrMapper.userInfo(sysUser);
    }

    public StatusCode editUserInfo(SysUser sysUser) {
        int i = sysUsrMapper.editUser(sysUser);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public ResultCode getBedInfo(Integer page, Integer limit) {
        List list1 = bedMapper.getBedInfo((page - 1) * limit, limit);
        List list2 = bedMapper.getAllBedInfo();
        rCode.setCode(0);
        rCode.setData(list1);
        rCode.setMsg("");
        rCode.setCount(list2.size());
        if (list2.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode deleteManyUser(String[] uNames) {
        int i = sysUsrMapper.deleteManyUser(uNames);
        if (i > 0) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode addBedType(Bed bed) {
        Bed bed1 = bedMapper.bedInfo(bed);
        if (bed1 == null) {
            int i = bedMapper.addBed(bed);
            if (i == 1) {
                return new StatusCode("操作成功", 1);
            } else {
                return new StatusCode("操作失败", 2);
            }
        } else {
            return new StatusCode("床位类别已存在", 0);
        }
    }

    public ResultCode searchBedInfo(int page, int limit, Bed sk) {
        List list = bedMapper.searchBedInfo((page - 1) * limit, limit, sk);
        List list1 = bedMapper.searchAllBedInfo(sk);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setMsg("");
        rCode.setData(list);
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode deleteBed(Bed bed) {
        int i = bedMapper.deleteBed(bed);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode deleteManybed(String[] bedTypes) {
        int i = bedMapper.deleteManyBed(bedTypes);
        if (i > 0) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public Bed bedInfo(Bed bed) {
        return bedMapper.bedInfo(bed);
    }

    public StatusCode modifyBed(Bed bed) {
        Bed bed2 = bedMapper.bedInfoById(bed);
        Bed bed1 = bedMapper.checIsExistBed(bed.getbType(), bed2.getbType());
        if (bed1 == null) {
            int i = bedMapper.modifyBed(bed);
            if (i == 1) {
                return new StatusCode("操作成功", 1);
            } else {
                return new StatusCode("操作失败", 2);
            }
        } else {
            return new StatusCode("床位类型已存在", 0);
        }
    }

    public StatusCode addSection(Section section) {
        Section section1 = sectionMapper.sectionInfo(section);
        Section section2 = sectionMapper.sectionInfoByNo(section);
        if (section1 == null && section2 == null) {
            int i = sectionMapper.addSection(section);
            if (i == 1) {
                return new StatusCode("操作成功", 1);
            } else {
                return new StatusCode("操作失败", 2);
            }
        } else {
            return new StatusCode("部门信息已存在", 0);
        }
    }

    public ResultCode getSectionInfo(int page, int limit) {
        List list = sectionMapper.getSectionInfo((page - 1) * limit, limit);
        List list1 = sectionMapper.getAllSectionInfo();
        rCode.setCode(0);
        rCode.setData(list);
        rCode.setMsg("");
        rCode.setCount(list1.size());
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchSectionInfo(int page, int limit, Section sk) {
        List list = sectionMapper.searchSectionInfo((page - 1) * limit, limit, sk);
        List list1 = sectionMapper.searchAllSectionInfo(sk);
        rCode.setCode(0);
        rCode.setData(list);
        rCode.setMsg("");
        rCode.setCount(list1.size());
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode deleteSection(Section section) {
        int i = sectionMapper.deleteSection(section);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode modifySection(Section section) {
        Section section1 = sectionMapper.sectionInfoByNo(section);
        Section section2 = sectionMapper.checkExistSection(section.getsName(), section1.getsName());
        if (section2 == null) {
            int i = sectionMapper.modifySection(section);
            if (i == 1) {
                return new StatusCode("操作成功", 1);
            } else {
                return new StatusCode("操纵失败", 2);
            }
        } else {
            return new StatusCode("部门信息已存在", 0);
        }
    }

    public List allSectionInfo() {
        return sectionMapper.getAllSectionInfo();
    }

    public Section sectionInfo(Section section) {
        return sectionMapper.sectionInfoByNo(section);
    }

    public StatusCode deleteManysection(String[] sNos) {
        int i = sectionMapper.deleteManysection(sNos);
        if (i > 0) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

}
