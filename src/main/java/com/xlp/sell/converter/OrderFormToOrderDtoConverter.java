package com.xlp.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xlp.sell.dto.OrderDto;
import com.xlp.sell.entity.OrderDetail;
import com.xlp.sell.enums.ResultEnum;
import com.xlp.sell.exception.SellException;
import com.xlp.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/11 15:14
 */
@Slf4j
public class OrderFormToOrderDtoConverter {
    public static OrderDto converter(OrderForm orderForm){
        Gson gson=new Gson();
        OrderDto orderDto=new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList =new ArrayList<>();
        try {
            orderDetailList=gson.fromJson(orderForm.getItems()
                    ,new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转换】错误，String={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }
}
