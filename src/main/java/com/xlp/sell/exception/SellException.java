package com.xlp.sell.exception;

import com.xlp.sell.enums.ResultEnum;

/**
 * @Description TODO
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/10 16:36
 */
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}
