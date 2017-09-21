package com.xie.service.impl;

import com.xie.bean.OrderGoods;
import com.xie.mapper.OrderGoodsMapper;
import com.xie.service.OrderGoodsMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/9/21.
 */
@Service
public class OrderGoodsMapperServiceImpl implements OrderGoodsMapperService {

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return orderGoodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderGoods record) {
        return orderGoodsMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderGoods record) {
        return orderGoodsMapper.insertSelective(record);
    }

    @Override
    public OrderGoods selectByPrimaryKey(Integer id) {
        return orderGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderGoods record) {
        return orderGoodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(OrderGoods record) {
        return orderGoodsMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(OrderGoods record) {
        return orderGoodsMapper.updateByPrimaryKey(record);
    }
}
