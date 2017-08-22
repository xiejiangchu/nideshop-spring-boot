package com.xie.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsShort implements Serializable {
    private Integer id;

    private Integer categoryId;

    private String name;

    /**
     * 零售价格
     */
    private BigDecimal retailPrice;

    /**
     * 商品列表图
     */
    private String listPicUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
    }

    @Override
    public String toString() {
        return "GoodsShort{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", listPicUrl='" + listPicUrl + '\'' +
                '}';
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }
}