package com.haoshuai.app.controller.custom;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoshuai.app.entity.*;
import com.haoshuai.app.services.CustomService;
import com.haoshuai.app.utils.Config;
import com.haoshuai.app.utils.SessionUtil;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    private CustomService customService;

    //发送验证码
    @PostMapping(value = "/send_sms")
    @ResponseBody
    public StatusCode sendSms(Custom custom, HttpServletRequest req) throws Exception {
        System.out.println(req.getMethod());
        JSONObject json = null;
        //生成6位验证码
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        System.out.print("验证码: " + verifyCode);
        //发送短信
        ZhenziSmsClient client = new ZhenziSmsClient(Config.apiUrl, Config.appId, Config.appSecret);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("number", custom.getcPhone());
        params.put("templateId", 5759);
        String[] templateParams = {verifyCode, "5分钟内有效"};
        params.put("templateParams", templateParams);
        String result = client.send(params);
        json = JSONObject.parseObject(result);
        if (json.getIntValue("code") != 0) {//发送短信失败
            return new StatusCode("发送失败", 2);
        }
        //将验证码存到session中,同时存入创建时间
        HttpSession session = req.getSession();
        SessionUtil.save(session, custom.getcPhone(), verifyCode, 5 * 60);
        return new StatusCode("发送成功", 1);
    }

    @GetMapping(value = "/store")
    public String store(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        model.addAttribute("cInfo", (Custom) session.getAttribute("cInfo"));
        return "custom/index";
    }

    @GetMapping(value = "/old")
    public String nc(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        model.addAttribute("cInfo", (Custom) session.getAttribute("cInfo"));
        return "custom/old";
    }

    @GetMapping(value = "/hmc")
    public String hmc(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        model.addAttribute("cInfo", (Custom) session.getAttribute("cInfo"));
        return "custom/hmc";
    }

    @GetMapping(value = "/nc")
    public String sa(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        model.addAttribute("cInfo", (Custom) session.getAttribute("cInfo"));
        return "custom/nc";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "custom/login";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "custom/register";
    }

    @GetMapping(value = "/exit")
    public String exit(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.setAttribute("cInfo", null);
        return "custom/index";
    }

    @GetMapping(value = "/find_pwd")
    public String findPwd() {
        return "custom/find_pwd";
    }

    @GetMapping(value = "/user")
    public String user(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        Custom cInfo = (Custom) session.getAttribute("cInfo");
        model.addAttribute("cInfo", cInfo);
        return cInfo == null ? "redirect:/login" : "custom/user";
    }

    @GetMapping(value = "/profile")
    public String profile(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        Custom cInfo = (Custom) session.getAttribute("cInfo");
        Custom cusomInfo = customService.getCusomInfo(cInfo);
        model.addAttribute("cInfo", cusomInfo);
        return cInfo == null ? "redirect:/login" : "custom/profile";
    }

    @GetMapping(value = "/change_password")
    public String changePassword(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        Custom cInfo = (Custom) session.getAttribute("cInfo");
        model.addAttribute("cInfo", cInfo);
        return cInfo == null ? "redirect:/login" : "custom/change_password";
    }

    @GetMapping(value = "/order_confirm")
    public String cart(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        Custom cInfo = (Custom) session.getAttribute("cInfo");
        model.addAttribute("cInfo", cInfo);
        return cInfo == null ? "redirect:/login" : "custom/order_confirm";
    }

    @GetMapping(value = "/address")
    public String address(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        Custom cInfo = (Custom) session.getAttribute("cInfo");
        model.addAttribute("cInfo", cInfo);
        return cInfo == null ? "redirect:/login" : "custom/address";
    }

    @GetMapping(value = "/address_edit")
    public String addressEdit(CustomAddress ca, Model model) {
        CustomAddress addressInfo = customService.getAddressInfo(ca);
        model.addAttribute("aInfo", addressInfo);
        return "custom/address_edit";
    }

    @GetMapping(value = "/get_product.do")
    @ResponseBody
    public Map<String,Object> getProduct(@RequestParam(required = false, defaultValue = "1") Integer page,
                                @RequestParam(required = false, defaultValue = "15") Integer limit) {
       return customService.searchProduct(page,limit);
    }

    @GetMapping(value = "/get_nut_child.do")
    @ResponseBody
    public Map<String,Object> getNutChild(@RequestParam(required = false, defaultValue = "1") Integer page,
                                         @RequestParam(required = false, defaultValue = "15") Integer limit) {
        return customService.searchNutChild(page,limit);
    }

    @GetMapping(value = "/get_hmc.do")
    @ResponseBody
    public Map<String,Object> getHmc(@RequestParam(required = false, defaultValue = "1") Integer page,
                                          @RequestParam(required = false, defaultValue = "15") Integer limit) {
        return customService.searchHmc(page,limit);
    }

    @GetMapping(value = "/get_sa.do")
    @ResponseBody
    public Map<String,Object> getSa(@RequestParam(required = false, defaultValue = "1") Integer page,
                                          @RequestParam(required = false, defaultValue = "15") Integer limit) {
        return customService.searchSa(page,limit);
    }

    @GetMapping(value = "/product")
    public String product(HttpServletRequest req,Product p,Model model){
        HttpSession session = req.getSession();
        Custom cInfo = (Custom) session.getAttribute("cInfo");
        model.addAttribute("cInfo", cInfo);
        Product product = customService.showProduct(p);
        model.addAttribute("pInfo",product);
        return "custom/product";
    }

    @GetMapping(value = "/order")
    public String orderList(HttpServletRequest req,Model model){
        HttpSession session = req.getSession();
        Custom cInfo = (Custom) session.getAttribute("cInfo");
        model.addAttribute("cInfo", cInfo);
        return "custom/order_list";
    }

    @GetMapping(value = "/pay_order")
    public String payOrder(Order o,Model model){
        Order orderInfo = customService.getOrderInfo(o);
        model.addAttribute("oInfo",orderInfo);
        return "custom/pay_order";
    }

    @GetMapping(value = "/return_request")
    public String returnRequest(Order o,Model model){
        Order orderInfo = customService.getOrderInfo(o);
        model.addAttribute("oInfo",orderInfo);
        return "custom/return_request";
    }


}
