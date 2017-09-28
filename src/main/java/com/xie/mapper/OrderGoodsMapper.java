package com.xie.mapper;

import com.xie.bean.OrderGoods;

import java.util.List;

public interface OrderGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    OrderGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKeyWithBLOBs(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);

    List<OrderGoods> selectByOrderId(Integer oid);
}