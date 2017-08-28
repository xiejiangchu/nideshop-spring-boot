package com.xie.service;

import com.xie.bean.Cart;

import java.util.List;

/**
 * Created by xie on 17/8/23.
 */
public interface CartService {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKeyWithBLOBs(Cart record);

    int updateByPrimaryKey(Cart record);

    List<Cart> selectByUid(Integer uid);

    int updateCheckedByProductId(Integer uid,List<Integer> productIds,int checked);

    int updateNumberByProductId(Integer uid,Integer productId,int number);

    int deleteByUid(Integer uid);
}