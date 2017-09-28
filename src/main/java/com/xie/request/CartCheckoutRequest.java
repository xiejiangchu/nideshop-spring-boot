package com.xie.request;

import java.io.Serializable;

/**
 * Created by xie on 17/9/28.
 */
public class CartCheckoutRequest implements Serializable{
    private static final long serialVersionUID = 2529787337622536989L;
    private Integer addressId;
    private Integer couponId;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }
}
