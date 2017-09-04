package com.xie.service.impl;

import com.xie.bean.Cart;
import com.xie.mapper.CartMapper;
import com.xie.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cartMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Cart record) {
        return cartMapper.insert(record);
    }

    @Override
    public int insertSelective(Cart record) {
        return cartMapper.insertSelective(record);
    }

    @Override
    public Cart selectByPrimaryKey(Integer id) {
        return cartMapper.selectByPrimaryKey(id);
    }

    @Override
    public Cart selectByGidAndPid(Integer goodsId, Integer productId) {
        return cartMapper.selectByGidAndPid(goodsId, productId);
    }

    @Override
    public int updateByPrimaryKeySelective(Cart record) {
        return cartMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Cart record) {
        return cartMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Cart record) {
        return cartMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Cart> selectByUid(Integer uid) {
        return cartMapper.selectByUid(uid);
    }

    @Override
    public int updateCheckedByProductId(Integer uid, List<Integer> productids, int checked) {
        return cartMapper.updateCheckedByProductId(uid, productids, checked);
    }

    @Override
    public int updateNumberByProductId(Integer uid, Integer productId, int number) {
        return cartMapper.updateNumberByProductId(uid, productId, number);
    }

    @Override
    public int deleteByUid(Integer uid) {
        return cartMapper.deleteByUid(uid);
    }

    @Override
    public int count(Integer uid) {
        return cartMapper.count(uid);
    }
}
