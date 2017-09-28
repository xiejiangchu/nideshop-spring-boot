package com.xie.service;

import com.xie.bean.OrderGoods;

import java.util.List;

/**
 * Created by xie on 17/9/21.
 */
public interface OrderGoodsService {

    int deleteByPrimaryKey(Integer id);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    OrderGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKeyWithBLOBs(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);

    List<OrderGoods> selectByOrderId(Integer orderId);
}
