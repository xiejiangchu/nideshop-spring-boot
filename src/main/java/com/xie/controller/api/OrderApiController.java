package com.xie.controller.api;

import com.xie.bean.*;
import com.xie.response.BaseResponse;
import com.xie.service.*;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.xie.utils.StringUtils.generateOrderNo;

/**
 * Created by xie on 17/9/2.
 */
@Controller
@RequestMapping(value = "/api/order")
public class OrderApiController extends BaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CouponService couponService;

    @Autowired
    private OrderGoodsMapperService orderGoodsMapperService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse list(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                             @RequestParam(value = "size", required = false, defaultValue = "10") int size) {

        return BaseResponse.ok(orderService.selectByUid(getUid(), page, size));
    }


    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse detail(@RequestParam(value = "orderId") int orderId) {
        Order order = orderService.selectByPrimaryKey(orderId);
        if (null == order || order.getUserId() != getUid()) {
            return BaseResponse.fail("订单不存在");
        }

        return BaseResponse.ok();
    }


    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse submit(@RequestParam(value = "addressId") int addressId,
                               @RequestParam(value = "couponId") short couponId,
                               @RequestParam(value = "postscript", required = false, defaultValue = "") String postscript
    ) {

        Address address = addressService.selectByPrimaryKey(addressId);
        if (null == address) {
            return BaseResponse.fail("请选择收货地址");
        }


        double freightPrice = 0.00;
        double goodsTotalPrice = 0.00;
        double couponPrice = 0.00;

        List<Cart> checkedGoodsList = cartService.selectByUidChecked(getUid());
        if (checkedGoodsList == null || checkedGoodsList.size() == 0) {
            return BaseResponse.fail("请选择商品");
        }
        for (int i = 0; i < checkedGoodsList.size(); i++) {
            goodsTotalPrice += checkedGoodsList.get(i).getNumber() * checkedGoodsList.get(i).getRetailPrice();
        }

        Coupon coupon = couponService.selectByPrimaryKey(couponId);
        if (null != coupon) {

        }

        double orderTotalPrice = goodsTotalPrice + freightPrice - couponPrice;
        double actualPrice = orderTotalPrice - 0.00;

        int currentTime = (int) (DateTime.now().toDate().getTime() / 1000);

        Order order = new Order();
        order.setOrderSn(generateOrderNo());
        order.setUserId(getUid());
        order.setConsignee(address.getName());
        order.setMobile(address.getMobile());
        order.setProvince(address.getProvinceId());
        order.setCity(address.getCityId());
        order.setDistrict(address.getDistrictId());
        order.setAddress(address.getAddress());
        order.setFreightPrice(0);
        order.setPostscript(postscript);
        order.setCouponId((int) couponId);
        order.setCouponPrice(couponPrice);
        order.setAddTime(currentTime);
        order.setGoodsPrice(goodsTotalPrice);
        order.setOrderPrice(orderTotalPrice);
        order.setActualPrice(actualPrice);

        int orderId = orderService.insert(order);
        if (orderId <= 0) {
            return BaseResponse.fail("订单提交失败");
        }

        checkedGoodsList.forEach(item -> {
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setOrderId(orderId);
            BeanUtils.copyProperties(item, orderGoods);
            orderGoodsMapperService.insert(orderGoods);
        });

        cartService.deleteCheckedByUid(getUid());

        return BaseResponse.ok("订单提交成功");
    }

}
