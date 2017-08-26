package com.xie.response;

/**
 * Created by xie on 17/8/26.
 */
public class CartTotalResponse {


    /**
     * goodsCount : goodsCount
     * goodsAmount : goodsAmount
     * checkedGoodsCount : checkedGoodsCount
     * checkedGoodsAmount : checkedGoodsAmount
     */

    private int goodsCount;
    private double goodsAmount;
    private int checkedGoodsCount;
    private double checkedGoodsAmount;

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public double getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(double goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public int getCheckedGoodsCount() {
        return checkedGoodsCount;
    }

    public void setCheckedGoodsCount(int checkedGoodsCount) {
        this.checkedGoodsCount = checkedGoodsCount;
    }

    public double getCheckedGoodsAmount() {
        return checkedGoodsAmount;
    }

    public void setCheckedGoodsAmount(double checkedGoodsAmount) {
        this.checkedGoodsAmount = checkedGoodsAmount;
    }
}
