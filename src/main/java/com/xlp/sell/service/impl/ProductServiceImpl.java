package com.xlp.sell.service.impl;

import com.xlp.sell.dao.ProductInfoDao;
import com.xlp.sell.dto.CartDto;
import com.xlp.sell.entity.ProductInfo;
import com.xlp.sell.enums.ProductStatusEnum;
import com.xlp.sell.enums.ResultEnum;
import com.xlp.sell.exception.SellException;
import com.xlp.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Description TODO
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/4 10:02
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId(productId);
        Example<ProductInfo> example=Example.of(productInfo);
        return productInfoDao.findOne(example).get();
    }

    /**
     * 查询在架商品
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }


    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDto> cartDtoList) {
        for(CartDto cartDto:cartDtoList){
            ProductInfo productInfo = findOne(cartDto.getProductId());
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int result = productInfo.getProductStock() + cartDto.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDto> cartDtoList) {
        for(CartDto cartDto:cartDtoList){
            ProductInfo productInfo = findOne(cartDto.getProductId());
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int result = productInfo.getProductStock() - cartDto.getProductQuantity();
            if(result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }
    }
}
