package com.haoshuai.app.services;

import com.haoshuai.app.entity.MenuVo;
import com.haoshuai.app.entity.SystemMenu;
import com.haoshuai.app.mapper.SysMenuMapper;
import com.haoshuai.app.mapper.SysUserRoleMapper;
import com.haoshuai.app.utils.TreeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    public Map<String,Object> menu(Long sSurid){
        String s = sysUserRoleMapper.getsMid(sSurid);
        long[] mid = Arrays.stream(s.split(",")).mapToLong(Long::parseLong).toArray();
        System.out.println(mid.length);
        Map<String,Object> map = new HashMap<>(16);
        Map<String,Object> home = new HashMap<>(16);
        Map<String,Object> logo = new HashMap<>(16);
        List<SystemMenu> menuList = sysMenuMapper.getSystemMenuByStatusAndSort();
        List<MenuVo> menuInfo = new ArrayList<>();
        for(SystemMenu e : menuList){
            MenuVo menuVo = new MenuVo();
            menuVo.setId(e.getId());
            menuVo.setPid(e.getPid());
            menuVo.setHref(e.getHref());
            menuVo.setTitle(e.getTitle());
            menuVo.setIcon(e.getIcon());
            menuVo.setTarget(e.getTarget());
            menuInfo.add(menuVo);
        }
        map.put("menuInfo", TreeUtil.toTree(menuInfo,mid[0]));
        home.put("title","首页");
        home.put("href","/app/bs/welcome");//控制器路由,自行定义
        logo.put("title","后台管理平台");
        logo.put("image","../images/logo.png");//静态资源文件路径,可使用默认的logo.png
        logo.put("href","");
        map.put("homeInfo", home);
        map.put("logoInfo", logo);
        return map;
    }
}
