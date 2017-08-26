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

    int updateCheckedByProductId(List<Integer> productids,int checked);

    int deleteByUid(Integer uid);
}
