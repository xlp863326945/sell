package com.xlp.sell.service.impl;

import com.xlp.sell.dto.OrderDto;
import com.xlp.sell.enums.ResultEnum;
import com.xlp.sell.exception.SellException;
import com.xlp.sell.service.BuyerService;
import com.xlp.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/12 14:21
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;
    @Override
    public OrderDto findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid,orderId);
    }

    @Override
    public OrderDto cancelOrder(String openid, String orderId) {
        OrderDto orderDto = checkOrderOwner(openid, orderId);
        if(orderDto==null){
            log.error("【取消订单】查不到订单，orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        return orderService.cancel(orderDto);
    }

    private OrderDto checkOrderOwner(String openid, String orderId){
        OrderDto orderDto = orderService.findOne(orderId);
        if(orderDto==null){
            return null;
        }
        if(!orderId.equals(orderDto.getBuyerOpenid())){
            log.error("【查询订单】订单openid不一致，openid={},orderDto={}",openid,orderDto);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDto;
    }
}
