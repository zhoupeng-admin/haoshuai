package com.haoshuai.app.controller.config;

import com.haoshuai.app.entity.Custom;
import com.haoshuai.app.entity.SysUser;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SysInterceptor extends HandlerInterceptorAdapter {
    /**
     * 进入拦截器后首先进入此方法
     * false 停止执行
     * true 继续执行
     */
    public boolean preHandle(HttpServletRequest req, HttpServletResponse rep,Object handler) throws Exception{
        System.out.println("拦截器--start");
        HttpSession session = req.getSession();
        SysUser usrInfo = (SysUser) session.getAttribute("usrInfo");
        Custom customInfo = (Custom) session.getAttribute("cInfo");
        if(usrInfo == null && customInfo==null){
            System.out.println("无登陆");
            System.out.println(req.getContextPath());
            rep.sendRedirect(req.getContextPath()+"/store");
            return false;
        }
        System.out.println("已登陆");
        return true;
    }
}
