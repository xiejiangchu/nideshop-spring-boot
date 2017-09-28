package com.xie.controller;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Order;
import com.xie.controller.api.BaseController;
import com.xie.response.BaseResponse;
import com.xie.service.OrderGoodsService;
import com.xie.service.OrderService;
import com.xie.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xie on 17/9/28.
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderGoodsService orderGoodsService;

    @Autowired
    private RegionService regionService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "40") int pageSize,
                       Model model) {
        setHeaderData(model);
        model.addAttribute("title", "订单信息");
        PageInfo<Order> orderPageInfo = orderService.selectAll(pageNum, pageSize);

        orderPageInfo.getList().forEach(item -> {
            item.setProvinceName(regionService.selectByPrimaryKey(item.getProvince()).getName());
            item.setCityName(regionService.selectByPrimaryKey(item.getCity()).getName());
            item.setDistrictName(regionService.selectByPrimaryKey(item.getDistrict()).getName());
            item.setFullRegion(item.getProvinceName() + item.getCityName() + item.getDistrictName());
            item.setOrderStatusText(orderService.getOrderStatusText(item));
            item.setOrderHandleOption(orderService.getOrderHandleOption(item));
            item.setOrderGoodsList(orderGoodsService.selectByOrderId(item.getId()));
        });

        model.addAttribute("orderPageInfo", orderPageInfo);
        return "order";
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse post(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "40") int pageSize,
                             Model model) {
        PageInfo<Order> orderPageInfo = orderService.selectAll(pageNum, pageSize);

        orderPageInfo.getList().forEach(item -> {
            item.setProvinceName(regionService.selectByPrimaryKey(item.getProvince()).getName());
            item.setCityName(regionService.selectByPrimaryKey(item.getCity()).getName());
            item.setDistrictName(regionService.selectByPrimaryKey(item.getDistrict()).getName());
            item.setFullRegion(item.getProvinceName() + item.getCityName() + item.getDistrictName());
            item.setOrderStatusText(orderService.getOrderStatusText(item));
            item.setOrderHandleOption(orderService.getOrderHandleOption(item));
            item.setOrderGoodsList(orderGoodsService.selectByOrderId(item.getId()));
        });
        return BaseResponse.ok(orderPageInfo);
    }
}
