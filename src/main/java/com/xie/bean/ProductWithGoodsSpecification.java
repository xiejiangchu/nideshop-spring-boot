package com.xie.bean;

import java.io.Serializable;
import java.util.List;

public class ProductWithGoodsSpecification extends Product implements Serializable {
    private static final long serialVersionUID = -2104659412858440739L;

    private List<GoodsSpecification> goodsSpecificationList;

    public List<GoodsSpecification> getGoodsSpecificationList() {
        return goodsSpecificationList;
    }

    public void setGoodsSpecificationList(List<GoodsSpecification> goodsSpecificationList) {
        this.goodsSpecificationList = goodsSpecificationList;
    }
}