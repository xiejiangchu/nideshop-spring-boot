package com.xie.service.impl;

import com.xie.bean.UserCoupon;
import com.xie.mapper.UserCouponMapper;
import com.xie.service.UserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/9/28.
 */
@Service
public class UserCouponServiceImpl implements UserCouponService {

    @Autowired
    private UserCouponMapper userCouponMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userCouponMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserCoupon record) {
        return userCouponMapper.insert(record);
    }

    @Override
    public int insertSelective(UserCoupon record) {
        return userCouponMapper.insertSelective(record);
    }

    @Override
    public UserCoupon selectByPrimaryKey(Integer id) {
        return userCouponMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserCoupon record) {
        return userCouponMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserCoupon record) {
        return userCouponMapper.updateByPrimaryKey(record);
    }
}
