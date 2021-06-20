package com.haoshuai.app.services;

import com.haoshuai.app.entity.FiscalExpenditure;
import com.haoshuai.app.entity.Order;
import com.haoshuai.app.entity.ResultCode;
import com.haoshuai.app.entity.StatusCode;
import com.haoshuai.app.mapper.FiscalExpenditureMapper;
import com.haoshuai.app.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.security.sasl.SaslClient;
import java.util.List;

@Service
public class FinanceService {

    @Resource
    private FiscalExpenditureMapper fiscalExpenditureMapper;
    @Resource
    private OrderMapper orderMapper;

    ResultCode rCode = new ResultCode();

    public ResultCode getFEInfo(int page, int limit) {
        List list = fiscalExpenditureMapper.getFEInfo((page - 1) * limit, limit);
        List list1 = fiscalExpenditureMapper.getAllFEInfo();
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchFEInfo(int page, int limit, FiscalExpenditure sk) {
        List list = fiscalExpenditureMapper.searchFEInfo((page - 1) * limit, limit, sk);
        List list1 = fiscalExpenditureMapper.searchAllFEInfo(sk);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode getOrderInfo(int page, int limit) {
        List list = orderMapper.getOrderInfo((page - 1) * limit, limit);
        List list1 = orderMapper.getAllOrderInfo();
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public ResultCode searchOrderInfo(int page, int limit, Order o) {
        List list = orderMapper.searchOrderInfo((page - 1) * limit, limit, o);
        List list1 = orderMapper.searchAllOrderInfo(o);
        rCode.setCode(0);
        rCode.setCount(list1.size());
        rCode.setData(list);
        rCode.setMsg("");
        if (list1.size() == 0) {
            rCode.setMsg("无数据");
        }
        return rCode;
    }

    public StatusCode confirmReturn(Order o,FiscalExpenditure fe){
        int i = orderMapper.confirmReturn(o);
        fe.setFeType(2);
        fe.setFeSpendType(0);
        fe.setFeIntoCount("123321");
        int i1 = fiscalExpenditureMapper.addFiscalExpenditure(fe);
        if (i1 == 1 && i == 1) {
            return new StatusCode("操作成功",1);
        }else{
            return new StatusCode("操作失败",2);
        }
    }
}
