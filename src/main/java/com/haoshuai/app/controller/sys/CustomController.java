package com.haoshuai.app.controller.sys;

import com.haoshuai.app.entity.*;
import com.haoshuai.app.services.CustomService;
import com.mysql.cj.jdbc.SuspendableXAConnection;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.OnMessage;

@Controller
@RequestMapping(value = "/Custom")
public class CustomController {

    @Resource
    private CustomService customService;

    @PostMapping(value = "/register.do")
    @ResponseBody
    public StatusCode register(HttpServletRequest req, Custom custom){
        return customService.register(req,custom);
    }

    @PostMapping(value = "/login.do")
    @ResponseBody
    public StatusCode login(Custom custom,HttpServletRequest req){
        return customService.login(custom,req);
    }

    @PostMapping(value = "/find_pwd.do")
    @ResponseBody
    public StatusCode findPwd(Custom custom){
        return customService.findPwd(custom);
    }

    @PostMapping(value = "/modify_custom.do")
    @ResponseBody
    public StatusCode modifyCustom(Custom custom){
        return customService.modifyCustom(custom);
    }

    @PostMapping(value = "/modify_pwd.do")
    @ResponseBody
    public StatusCode modifyPwd(Custom custom, String cOldPwd){
        System.out.println(cOldPwd);
        return customService.modifyPwd(custom,cOldPwd);
    }

    @GetMapping(value = "/get_address.do")
    @ResponseBody
    public ResultCode getAddress(HttpServletRequest req,
                                 @RequestParam(required = false,defaultValue = "1") Integer page,
                                 @RequestParam(required = false,defaultValue = "15") Integer limit){
        HttpSession session = req.getSession();
        Custom cInfo = (Custom) session.getAttribute("cInfo");
        System.out.println(cInfo.getcId());
        return customService.getAllAddress(cInfo);
    }

    @PostMapping(value = "/add_address.do")
    @ResponseBody
    public StatusCode addAddress(CustomAddress ca){
        return customService.addAddress(ca);
    }

    @PostMapping(value = "/modify_address.do")
    @ResponseBody
    public StatusCode modifyAddress(CustomAddress ca){
        return customService.modifyAddress(ca);
    }

    @PostMapping(value = "/delete_address.do")
    @ResponseBody
    public StatusCode deleteAddress(CustomAddress ca){
        return customService.deleteAddress(ca);
    }

    @PostMapping(value = "/add_order.do")
    @ResponseBody
    public StatusCode addOrder(Order order){
        System.out.println(order.toString());
        return customService.addOrder(order);
    }

    @GetMapping(value = "/get_order_list.do")
    @ResponseBody
    public ResultCode getOrderList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                    @RequestParam(required = false,defaultValue = "15") Integer limit,
                                   HttpServletRequest req){
        return customService.getOrderInfos(page,limit,req);
    }

    @PostMapping(value = "/search_order_list.do")
    @ResponseBody
    public ResultCode searchOrderList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                      @RequestParam(required = false,defaultValue = "15") Integer limit,
                                      Order order){
        return customService.searchOrderInfo(page,limit,order);
    }

    @PostMapping(value = "/pay_order.do")
    @ResponseBody
    public StatusCode payOrder(HttpServletRequest req,Order order,FiscalExpenditure fe){
        return customService.payOrder(req,order,fe);
    }

    @PostMapping(value = "/cancel_order.do")
    @ResponseBody
    public StatusCode cancelOrder(Order order){
        return customService.cancelOrder(order);
    }

    @PostMapping(value = "/return_request.do")
    @ResponseBody
    public StatusCode returnRequest(HttpServletRequest req,Order order,FiscalExpenditure fe){
        return customService.returnRequest(req,order,fe);
    }

    @PostMapping(value = "/confirm_recepit.do")
    @ResponseBody
    public StatusCode confirmRecepit(Order order){
        return customService.confirmRecepit(order);
    }
}
