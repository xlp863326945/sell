package com.xlp.sell.service.impl;

import com.xlp.sell.dao.ProductCategoryDao;
import com.xlp.sell.entity.ProductCategory;
import com.xlp.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Description 类目实现类
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/3 17:06
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryId(categoryId);
        Example<ProductCategory> example = Example.of(productCategory);
        return productCategoryDao.findOne(example).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}
