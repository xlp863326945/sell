package com.xlp.sell.dao;

import com.xlp.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *  类目Dao
 * @author xianglianpeng
 *@date 2020-06-03 15:52:18
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {
    /**
   * 查询列表
   */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
   * 查询数量
   */
    //int queryTotal(Map<String, Object> params);
}
