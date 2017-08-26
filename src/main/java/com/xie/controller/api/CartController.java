package com.xie.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.xie.bean.Cart;
import com.xie.request.CartCheckedRequest;
import com.xie.response.BaseResponse;
import com.xie.response.CartTotalResponse;
import com.xie.service.CartService;
import com.xie.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xie on 17/8/26.
 */
@Controller
@RequestMapping(value = "/api/cart")
public class CartController extends BaseController {

    @Autowired
    private CartService cartService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse index() {

        return BaseResponse.ok(getCart());
    }

    private JSONObject getCart() {
        List<Cart> cartList = cartService.selectByUid(getUid());
        int goodsCount = 0;
        double goodsAmount = 0.00;
        int checkedGoodsCount = 0;
        double checkedGoodsAmount = 0.00;
        for (int i = 0; i < cartList.size(); i++) {
            Cart item = cartList.get(i);
            goodsCount += item.getNumber();
            goodsAmount += item.getNumber() * item.getRetailPrice();
            if (item.getChecked()) {
                checkedGoodsCount += item.getNumber();
                checkedGoodsAmount += item.getNumber() * item.getRetailPrice();
            }
        }
        CartTotalResponse cartTotalResponse = new CartTotalResponse();
        cartTotalResponse.setGoodsAmount(goodsAmount);
        cartTotalResponse.setGoodsCount(goodsCount);
        cartTotalResponse.setCheckedGoodsAmount(checkedGoodsAmount);
        cartTotalResponse.setCheckedGoodsCount(checkedGoodsCount);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cartList", cartList);
        jsonObject.put("cartTotal", cartTotalResponse);
        return jsonObject;
    }

    @RequestMapping(value = "/checked", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse checked(@RequestBody CartCheckedRequest cartCheckedRequest) {
        if (cartCheckedRequest.getProductIds() == null) {
            return BaseResponse.ok();
        }
        List<Integer> goodsIds = Arrays.stream(cartCheckedRequest.getProductIds().split(",")).map(item -> Integer.parseInt(item)).collect(Collectors.toList());
        int count = cartService.updateCheckedByProductId(goodsIds, cartCheckedRequest.getIsChecked());
        return BaseResponse.ok(getCart());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse delete() {
        int count = cartService.deleteByUid(getUid());
        return BaseResponse.ok(getCart());
    }
}
