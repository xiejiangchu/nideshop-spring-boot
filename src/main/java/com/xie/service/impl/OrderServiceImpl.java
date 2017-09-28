package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.bean.Order;
import com.xie.bean.OrderHandleOption;
import com.xie.mapper.OrderMapper;
import com.xie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/22.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Order record) {
        orderMapper.insert(record);
        return record.getId();
    }

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public Order selectByPrimaryKey(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Order> selectByUid(Integer uid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Order> page = new PageInfo<Order>(orderMapper.selectByUid(uid));
        return page;
    }

    @Override
    public OrderHandleOption getOrderHandleOption(Integer orderId) {

        OrderHandleOption orderHandleOption = new OrderHandleOption();
        Order order = orderMapper.selectByPrimaryKey(orderId);


        //订单流程：　下单成功－》支付订单－》发货－》收货－》评论

        //订单相关状态字段设计，采用单个字段表示全部的订单状态
        //1xx 表示订单取消和删除等状态 0订单创建成功等待付款，　101订单已取消，　102订单已删除
        //2xx 表示订单支付状态　201订单已付款，等待发货
        //3xx 表示订单物流相关状态　300订单已发货， 301用户确认收货
        //4xx 表示订单退换货相关的状态　401 没有发货，退款　402 已收货，退款退货

        //如果订单已经取消或是已完成，则可删除和再次购买
        if (order.getOrderStatus() == 101) {
            orderHandleOption.setDelete(true);
            orderHandleOption.setBuy(true);
        }

        //如果订单没有被取消，且没有支付，则可支付，可取消
        if (order.getOrderStatus() == 0) {
            orderHandleOption.setCancel(true);
            orderHandleOption.setPay(true);
        }

        //如果订单已付款，没有发货，则可退款操作
        if (order.getOrderStatus() == 201) {
            orderHandleOption.setRet(true);
        }

        //如果订单已经发货，没有收货，则可收货操作和退款、退货操作
        if (order.getOrderStatus() == 300) {
            orderHandleOption.setCancel(true);
            orderHandleOption.setPay(true);
            orderHandleOption.setRet(true);
        }

        //如果订单已经支付，且已经收货，则可完成交易、评论和再次购买
        if (order.getOrderStatus() == 301) {
            orderHandleOption.setDelete(true);
            orderHandleOption.setComment(true);
            orderHandleOption.setBuy(true);
        }
        return orderHandleOption;
    }

    @Override
    public OrderHandleOption getOrderHandleOption(Order order) {
        OrderHandleOption orderHandleOption = new OrderHandleOption();

        //如果订单已经取消或是已完成，则可删除和再次购买
        if (order.getOrderStatus() == 101) {
            orderHandleOption.setDelete(true);
            orderHandleOption.setBuy(true);
        }

        //如果订单没有被取消，且没有支付，则可支付，可取消
        if (order.getOrderStatus() == 0) {
            orderHandleOption.setCancel(true);
            orderHandleOption.setPay(true);
        }

        //如果订单已付款，没有发货，则可退款操作
        if (order.getOrderStatus() == 201) {
            orderHandleOption.setRet(true);
        }

        //如果订单已经发货，没有收货，则可收货操作和退款、退货操作
        if (order.getOrderStatus() == 300) {
            orderHandleOption.setCancel(true);
            orderHandleOption.setPay(true);
            orderHandleOption.setRet(true);
        }

        //如果订单已经支付，且已经收货，则可完成交易、评论和再次购买
        if (order.getOrderStatus() == 301) {
            orderHandleOption.setDelete(true);
            orderHandleOption.setComment(true);
            orderHandleOption.setBuy(true);
        }
        return orderHandleOption;
    }


    @Override
    public String getOrderStatusText(Integer orderId) {
        return "未付款";
    }

    @Override
    public String getOrderStatusText(Order order) {
        return "未付款";
    }
}
