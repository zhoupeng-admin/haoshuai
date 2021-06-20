package com.haoshuai.app.mapper;

import com.haoshuai.app.entity.Custom;
import com.haoshuai.app.entity.Order;
import com.haoshuai.app.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    int addOrder(Order order);
    List getOrderInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllOrderInfo();
    List searchOrderInfo(@Param("page") int page, @Param("limit") int limit, @Param("sk") Order sk);
    List searchAllOrderInfo(@Param("sk") Order sk);
    Order getOrder(Order o);
    int payOrder(Order o);
    int cancelOrder(Order o);
    int returnRequest(Order o);
    int confirmRecepit(Order o);
    List getOrderInfoById(@Param("page") int page, @Param("limit") int limit,@Param("sk") Order sk);
    List getAllOrderInfoById(@Param("sk") Order sk);
    List searchOrderInfoById(@Param("page") int page, @Param("limit") int limit, @Param("sk") Order sk);
    List searchAllOrderInfoById(@Param("sk") Order sk);
    int confirmReturn(Order o);
}
