package com.xlp.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 *商品表
 *@author xianglianpeng
 *@date 2020-06-03 17:23:16
 */
@Data
@Entity
@DynamicUpdate
public class ProductInfo {

    /**
    * 商品id
    */
    @Id
    private String productId;
    /**
    * 商品名称
    */
    private String productName;
    /**
    * 单价
    */
    private BigDecimal productPrice;
    /**
    * 库存
    */
    private Integer productStock;
    /**
    * 描述
    */
    private String productDescription;
    /**
    * 商品小图
    */
    private String productIcon;
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

}
