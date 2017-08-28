package com.xie.request;

/**
 * Created by xie on 17/8/26.
 */
public class CartUpdateRequest {
    /**
     * productIds :
     * isChecked : 0
     */

    private int productId;
    private int number;

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
