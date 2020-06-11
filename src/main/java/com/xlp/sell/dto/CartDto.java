package com.xlp.sell.dto;

import lombok.Data;

/**
 * @Description TODO
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/10 17:12
 */
@Data
public class CartDto {
    /**
     * 商品ID
     */
    private String productId;
    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
