package com.xlp.sell.enums;

import lombok.Getter;

import java.util.PrimitiveIterator;

/**
 * @Description TODO
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/10 13:56
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"未支付"),
    SUCCESS(1,"已支付");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
