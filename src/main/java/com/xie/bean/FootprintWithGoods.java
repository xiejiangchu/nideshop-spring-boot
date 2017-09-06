package com.xie.bean;

import java.io.Serializable;
import java.util.Date;

public class FootprintWithGoods implements Serializable {
    private static final long serialVersionUID = -6158937065999628701L;
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Date addTime;



    private String name;
    /**
     * 商品列表图
     */
    private String listPicUrl;
    /**
     * 零售价格
     */
    private Double retailPrice;
    private String goodsBrief;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}