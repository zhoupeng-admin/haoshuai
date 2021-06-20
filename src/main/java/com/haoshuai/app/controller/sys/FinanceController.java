package com.haoshuai.app.controller.sys;

import com.haoshuai.app.entity.FiscalExpenditure;
import com.haoshuai.app.entity.Order;
import com.haoshuai.app.entity.ResultCode;
import com.haoshuai.app.entity.StatusCode;
import com.haoshuai.app.services.FinanceService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("fc")
public class FinanceController {
    @Resource
    private FinanceService financeService;

    @GetMapping(value = "/get_fe_list.do")
    @ResponseBody
    public ResultCode getFeList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                   @RequestParam(required = false,defaultValue = "15") Integer limit){
        return financeService.getFEInfo(page,limit);
    }

    @PostMapping(value = "/search_fe_list.do")
    @ResponseBody
    public ResultCode searchFeList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                      @RequestParam(required = false,defaultValue = "15") Integer limit,
                                      FiscalExpenditure fe){
        return financeService.searchFEInfo(page,limit,fe);
    }

    @GetMapping(value = "/get_order_list.do")
    @ResponseBody
    public ResultCode getOrderList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                @RequestParam(required = false,defaultValue = "15") Integer limit){
        return financeService.getOrderInfo(page,limit);
    }

    @PostMapping(value = "/search_order_list.do")
    @ResponseBody
    public ResultCode searchOrderList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                   @RequestParam(required = false,defaultValue = "15") Integer limit,
                                   Order o){
        return financeService.searchOrderInfo(page,limit,o);
    }

    @PostMapping(value = "/confirm_return.do")
    @ResponseBody
    public StatusCode confirmReturn(FiscalExpenditure fe,Order o){
        return financeService.confirmReturn(o,fe);
    }
}
