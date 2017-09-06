package com.xie.request;

import java.io.Serializable;

/**
 * Created by xie on 17/8/26.
 */
public class CartUpdateRequest implements Serializable {
    private static final long serialVersionUID = 3052986989467365381L;
    /**
     * productIds :
     * isChecked : 0
     */
    private int id;
    private int goodsId;
    private int productId;
    private int number;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
