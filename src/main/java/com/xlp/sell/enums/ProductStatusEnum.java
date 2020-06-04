package com.xlp.sell.enums;

import lombok.Getter;
/**
 * @Description 商品状态枚举
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/4 10:18
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架");
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}


