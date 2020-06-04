package com.xlp.sell.vo;

import lombok.Data;

/**
 * @Description TODO
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/4 11:04
 */
@Data
public class ResultVo<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回的具体数据
     */
    private T data;
}
