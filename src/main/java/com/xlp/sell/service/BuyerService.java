package com.xlp.sell.service;

import com.xlp.sell.dto.OrderDto;

public interface BuyerService {
    //查询一个订单
    OrderDto findOrderOne(String openid,String orderId);
    //取消订单
    OrderDto cancelOrder(String openid,String orderId);
}
