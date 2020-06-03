package com.xlp.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


/**
 *类目表
 *@author xianglianpeng
 *@date 2020-06-03 15:52:19
 */
@Data
@Entity
@DynamicUpdate
//@TableName("product_category")
public class ProductCategory {

    /**
    * 类目id
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    /**
    * 商品名称
    */
    private String categoryName;
    /**
    * 类目编号
    */
    private Integer categoryType;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType, Date createTime, Date updateTime) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ProductCategory() {
    }
}
