package com.xlp.sell.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xlp.sell.utils.serializer.DateToLongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description 订单详情
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/10 14:13
 */
@Data
@Entity
@DynamicUpdate
public class OrderDetail {
    /**
     * 详情ID
     */
    @Id
    private String detailId;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 商品id
     */
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
     * 商品数量
     */
    private Integer productQuantity;
    /**
     * 商品小图
     */
    private String productIcon;
    /**
     * 创建时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date updateTime;

}
