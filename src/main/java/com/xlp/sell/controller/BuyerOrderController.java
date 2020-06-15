package com.xlp.sell.controller;

import com.xlp.sell.converter.OrderFormToOrderDtoConverter;
import com.xlp.sell.dto.OrderDto;
import com.xlp.sell.enums.ResultEnum;
import com.xlp.sell.exception.SellException;
import com.xlp.sell.form.OrderForm;
import com.xlp.sell.service.BuyerService;
import com.xlp.sell.service.OrderService;
import com.xlp.sell.utils.ResultUtil;
import com.xlp.sell.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/11 14:41
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
    /**
     * 创建订单
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDto orderDto= OrderFormToOrderDtoConverter.converter(orderForm);
        if(CollectionUtils.isEmpty(orderDto.getOrderDetailList())){
            log.error("【创建订单】购物车为空，orderForm={}",orderForm);
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDto resultOrderDto = orderService.create(orderDto);
        Map<String,String> map=new HashMap<>();
        map.put("orderId",resultOrderDto.getOrderId());
        return ResultUtil.success(map);
    }

    @GetMapping("/list")
    public ResultVo<OrderDto> list(@RequestParam("openid") String openid,
                                   @RequestParam(value = "page",defaultValue = "0") Integer page,
                                   @RequestParam(value = "size",defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest=PageRequest.of(page,size);
        Page<OrderDto> pageOrderDto = orderService.findList(openid, pageRequest);

        return ResultUtil.success(pageOrderDto.getContent());
    }

    /**
     * 查询订单详情列表
     * @param openid
     * @param orderId
     * @return
     */
    @GetMapping("/detail")
    public ResultVo<OrderDto> detail(@RequestParam("openid") String openid,@RequestParam("orderId") String orderId){
        OrderDto orderDto = buyerService.findOrderOne(openid, orderId);
        return ResultUtil.success(orderDto);
    }

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    @PostMapping("/cancel")
    public ResultVo cancel(@RequestParam("openid") String openid,@RequestParam("orderId") String orderId){
        buyerService.cancelOrder(openid,orderId);
        return ResultUtil.success();
    }
}
