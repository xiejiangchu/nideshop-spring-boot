package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Order;
import com.xie.bean.OrderHandleOption;

/**
 * Created by xie on 17/8/22.
 */
public interface OrderService {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    PageInfo<Order> selectByUid(Integer uid, int pageNum, int pageSize);

    OrderHandleOption getOrderHandleOption(Integer orderId);

    OrderHandleOption getOrderHandleOption(Order order);

    String getOrderStatusText(Integer orderId);

    String getOrderStatusText(Order order);

    PageInfo<Order> selectAll(int pageNum, int pageSize);
}
