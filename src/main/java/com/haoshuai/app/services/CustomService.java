package com.haoshuai.app.services;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoshuai.app.entity.*;
import com.haoshuai.app.mapper.*;
import com.haoshuai.app.utils.PasswordEncode;
import com.haoshuai.app.utils.SessionUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomService {

    @Resource
    private CustomMapper customMapper;
    @Resource
    private CustomAddressMapper customAddressMapper;
    @Resource
    private ProductMapper productMapper;
    @Resource
    private FiscalExpenditureMapper fiscalExpenditureMapper;
    @Resource
    private OrderMapper orderMapper;

    PasswordEncode md5 = new PasswordEncode();
    ResultCode rCode = new ResultCode();

    public StatusCode register(HttpServletRequest req, Custom custom) {
        String verifyCode = req.getParameter("verifyCode");
        String error = SessionUtil.validate(req.getSession(), custom.getcPhone(), verifyCode);
        if (!error.equals("")) {
            return new StatusCode(error, 0);
        } else {
            Custom c = customMapper.getCustomByPhone(custom);
            if (c == null) {
                custom.setcPwd(md5.encode(custom.getcPwd()));
                int i = customMapper.addCustom(custom);
                if (i == 1) {
                    return new StatusCode("注册成功", 1);
                } else {
                    return new StatusCode("注册失败", 2);
                }
            } else {
                return new StatusCode("手机号已被注册", 0);
            }
        }
    }

    public StatusCode login(Custom custom, HttpServletRequest req) {
        System.out.println(custom.toString());
        HttpSession session = req.getSession();
        Custom custom1 = customMapper.login(custom);
        if ((custom1 == null) || (!(md5.encode(custom.getcPwd())).equals(custom1.getcPwd()))) {
            session.setAttribute("cInfo", null);
            return new StatusCode("用户名或密码错误", 2);
        } else {
            session.setAttribute("cInfo", custom1);
            return new StatusCode("登陆成功", 1);
        }
    }

    public Custom getCusomInfo(Custom custom) {
        return customMapper.getCustomById(custom);
    }

    public StatusCode findPwd(Custom custom) {
        custom.setcPwd(md5.encode(custom.getcPwd()));
        int i = customMapper.findPwd(custom);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode modifyCustom(Custom custom) {
        int i = customMapper.modifyCustom(custom);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode modifyPwd(Custom custom, String cOldPwd) {
        Custom customById = customMapper.getCustomById(custom);
        if (customById.getcPwd().equals(md5.encode(cOldPwd))) {
            custom.setcPwd(md5.encode(custom.getcPwd()));
            int i = customMapper.modifyPwd(custom);
            if (i == 1) {
                return new StatusCode("操作成功", 1);
            } else {
                return new StatusCode("操作失败", 2);
            }
        } else {
            return new StatusCode("原密码错误", 0);
        }
    }

    public StatusCode addAddress(CustomAddress ca) {
        int i = customAddressMapper.addAddress(ca);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public ResultCode getAllAddress(Custom c) {
        List allAddress = customAddressMapper.getAllAddress(c);
        rCode.setCode(0);
        rCode.setData(allAddress);
        rCode.setCount(allAddress.size());
        rCode.setMsg("");
        if (allAddress.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public CustomAddress getAddressInfo(CustomAddress ca) {
        return customAddressMapper.getAddressInfo(ca);
    }

    public StatusCode modifyAddress(CustomAddress ca) {
        int i = customAddressMapper.modifyAddress(ca);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public StatusCode deleteAddress(CustomAddress ca) {
        int i = customAddressMapper.deleteAddress(ca);
        if (i == 1) {
            return new StatusCode("操作成功", 1);
        } else {
            return new StatusCode("操作失败", 2);
        }
    }

    public Map<String, Object> searchProduct(int page, int limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        List list = productMapper.getProductInfo((page - 1) * limit, limit);
        List list1 = productMapper.getAllProductInfo();
        map.put("data", list);
        map.put("count", list1.size());
        return map;
    }

    public Map<String, Object> searchNutChild(int page, int limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        List list = productMapper.getNutChildInfo((page - 1) * limit, limit);
        List list1 = productMapper.getAllNutChildInfo();
        map.put("data", list);
        map.put("count", list1.size());
        return map;
    }

    public Map<String, Object> searchHmc(int page, int limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        List list = productMapper.getHmcInfo((page - 1) * limit, limit);
        List list1 = productMapper.getAllHmcInfo();
        map.put("data", list);
        map.put("count", list1.size());
        return map;
    }

    public Map<String, Object> searchSa(int page, int limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        List list = productMapper.getSaInfo((page - 1) * limit, limit);
        List list1 = productMapper.getAllSaInfo();
        map.put("data", list);
        map.put("count", list1.size());
        return map;
    }

    public Product showProduct(Product product) {
        return productMapper.showProduct(product);
    }

    public StatusCode addOrder(Order o){
        int i = orderMapper.addOrder(o);
        if (i ==1) {
            return new StatusCode("操作成功",1);
        }else{
            return new StatusCode("操作失败",2);
        }
    }

    public ResultCode getOrderInfos(int page, int limit,HttpServletRequest req){
        HttpSession session = req.getSession();
        Custom cInfo = (Custom) session.getAttribute("cInfo");
        Order o = new Order();
        o.setoPid(cInfo.getcId());
        List list = orderMapper.getOrderInfoById((page-1)*limit,limit,o);
        List list1 = orderMapper.getAllOrderInfoById(o);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchOrderInfo(int page, int limit,Order sk){
        List list = orderMapper.searchOrderInfo((page-1)*limit,limit,sk);
        List list1 = orderMapper.searchAllOrderInfo(sk);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public Order getOrderInfo(Order order){
        return orderMapper.getOrder(order);
    }

    public StatusCode payOrder(HttpServletRequest req,Order order,FiscalExpenditure fe){
        HttpSession session = req.getSession();
        Custom cInfo = (Custom) session.getAttribute("cInfo");
        int i = orderMapper.payOrder(order);
        fe.setFeType(2);
        fe.setFeOperator(String.valueOf(cInfo.getcId()));
        fe.setFeIntoCount("123321");
        fe.setFeSpendType(1);
        int i1 = fiscalExpenditureMapper.addFiscalExpenditure(fe);
        if (i == 1 && i1 == 1) {
            return new StatusCode("支付成功",1);
        }else{
            return new StatusCode("支付失败",2);
        }
    }

    public StatusCode cancelOrder(Order o){
        int i = orderMapper.cancelOrder(o);
        if (i == 1) {
            return new StatusCode("操作成功",1);
        }else{
            return new StatusCode("操作失败",2);
        }
    }

    public StatusCode returnRequest(HttpServletRequest req,Order order,FiscalExpenditure fe){
        HttpSession session = req.getSession();
        Custom cInfo = (Custom) session.getAttribute("cInfo");
        int i = orderMapper.returnRequest(order);
        fe.setFeType(2);
        fe.setFeOperator(String.valueOf(cInfo.getcId()));
        fe.setFeIntoCount("123321");
        fe.setFeSpendType(0);
        int i1 = fiscalExpenditureMapper.addFiscalExpenditure(fe);
        if (i == 1 && i1 == 1) {
            return new StatusCode("操作成功",1);
        }else{
            return new StatusCode("操作成功",2);
        }
    }

    public StatusCode confirmRecepit(Order o){
        int i = orderMapper.confirmRecepit(o);
        if (i == 1) {
            return new StatusCode("操作成功",1);
        }else{
            return new StatusCode("操作失败",2);
        }
    }

}
