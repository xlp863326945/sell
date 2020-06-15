package com.xlp.sell.form;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

/**
 * @Description TODO
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/11 14:48
 */
@Data
public class OrderForm {
    @NotEmpty(message = "买家姓名必填")
    private String name;
    @NotEmpty(message = "买家姓名必填")
    private String phone;
    @NotEmpty(message = "地址必填")
    private String address;
    @NotEmpty(message = "openid必填")
    private String openid;
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
