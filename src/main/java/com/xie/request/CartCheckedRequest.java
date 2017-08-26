package com.xie.request;

/**
 * Created by xie on 17/8/26.
 */
public class CartCheckedRequest {
    /**
     * productIds :
     * isChecked : 0
     */

    private String productIds;
    private int isChecked;

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }
}
