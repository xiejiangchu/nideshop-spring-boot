package com.xie.bean;

import java.io.Serializable;
import java.util.List;

public class CategoryShort implements Serializable {
    private Integer id;

    private String name;

    List<GoodsShort> goodsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsShort> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsShort> goodsList) {
        this.goodsList = goodsList;
    }
}