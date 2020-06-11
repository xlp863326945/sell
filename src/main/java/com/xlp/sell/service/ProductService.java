package com.xlp.sell.service;

import com.xlp.sell.dto.CartDto;
import com.xlp.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description TODO
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/4 10:01
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询所有商品列表
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);
    //加库存
    void increaseStock(List<CartDto> cartDtoList);
    //减库存
    void decreaseStock(List<CartDto> cartDtoList);
}
