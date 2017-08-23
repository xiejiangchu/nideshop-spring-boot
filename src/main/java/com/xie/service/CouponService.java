package com.xie.service;

import com.xie.bean.Coupon;

/**
 * Created by xie on 17/8/23.
 */
public interface CouponService {
    int deleteByPrimaryKey(Short id);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
}
