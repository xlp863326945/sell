package com.xlp.sell.service;


import com.xlp.sell.entity.ProductCategory;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 类目接口类
 * @author xianglianpeng
 * @date 2020-06-03 15:52:19
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
