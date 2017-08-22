package com.xie.mapper;

import com.xie.bean.Coupon;

public interface CouponMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
}