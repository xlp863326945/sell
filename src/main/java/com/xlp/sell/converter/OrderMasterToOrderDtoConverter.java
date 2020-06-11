package com.xlp.sell.converter;

import com.xlp.sell.dto.OrderDto;
import com.xlp.sell.entity.OrderDetail;
import com.xlp.sell.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/11 11:30
 */
public class OrderMasterToOrderDtoConverter {
    public static OrderDto converter(OrderMaster orderMaster){
        OrderDto orderDto=new OrderDto();
        BeanUtils.copyProperties(orderMaster,orderDto);
        return orderDto;
    }
    public static List<OrderDto> converter(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->converter(e)).collect(Collectors.toList());
    }
}
