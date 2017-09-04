package com.xie.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.xie.bean.Cart;
import com.xie.bean.Goods;
import com.xie.bean.GoodsSpecification;
import com.xie.bean.Product;
import com.xie.request.CartCheckedRequest;
import com.xie.request.CartUpdateRequest;
import com.xie.response.BaseResponse;
import com.xie.response.CartTotalResponse;
import com.xie.service.CartService;
import com.xie.service.GoodsService;
import com.xie.service.GoodsSpecificationService;
import com.xie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ProductService productService;

    @Autowired
    private GoodsSpecificationService goodsSpecificationService;

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse index() {

        return BaseResponse.ok(getCart());
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse add(@RequestParam(value = "goodsId") int goodsId,
                            @RequestParam(value = "productId") int productId,
                            @RequestParam(value = "number") int number) {
        Goods goods = goodsService.selectByPrimaryKey(goodsId);
        if (null == goods || goods.getIsDelete() == 1) {
            return BaseResponse.fail("商品已下架");
        }

        Product product = productService.selectByPrimaryKeyAndGid(productId, goodsId);
        if (product == null || product.getGoodsNumber() < number) {
            return BaseResponse.fail("库存不足");
        }

        Cart cart = cartService.selectByGidAndPid(goodsId, productId);
        if (cart == null) {
            List<GoodsSpecification> goodsSepcifitionValue = null;
            if (cart == null) {
                List<String> goods_specification_ids = Arrays.asList(product.getGoodsSpecificationIds().split("_"));
                goodsSepcifitionValue = goodsSpecificationService.selectByPrimaryKeyAndGoodsId(goods_specification_ids, goodsId);
            }

            Cart insert = new Cart();
            insert.setGoodsId(goodsId);
            insert.setProductId(productId);
            insert.setGoodsSn(goods.getGoodsSn());
            insert.setGoodsName(goods.getName());
            insert.setListPicUrl(goods.getListPicUrl());
            insert.setNumber(number);
            insert.setSessionId("1");
            insert.setUserId(getUid());
            insert.setRetailPrice(product.getRetailPrice());
            insert.setMarketPrice(product.getRetailPrice());
            if (goodsSepcifitionValue != null) {
                StringBuilder stringBuilder = new StringBuilder();
                goodsSepcifitionValue.forEach(item -> {
                    stringBuilder.append(item.getValue());
                    stringBuilder.append(";");
                });
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                insert.setGoodsSpecifitionNameValue(stringBuilder.toString());
            }
            insert.setGoodsSpecifitionIds(product.getGoodsSpecificationIds());
            insert.setChecked(1);

            cartService.insert(insert);
        } else {
            if (product.getGoodsNumber() < (number + cart.getNumber())) {
                return BaseResponse.fail("库存不足");
            } else {
                cartService.updateNumberByProductId(getUid(), productId, number);
            }
        }

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
            if (item.getChecked() == 1) {
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
        int count = cartService.updateCheckedByProductId(getUid(), goodsIds, cartCheckedRequest.getIsChecked());
        return BaseResponse.ok(getCart());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse delete() {
        int count = cartService.deleteByUid(getUid());
        return BaseResponse.ok(getCart());
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse update(@RequestBody CartUpdateRequest cartUpdateRequest) {
        int count = cartService.deleteByUid(getUid());
        return BaseResponse.ok(getCart());
    }

    @RequestMapping(value = "/goodsCount", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse goodsCount() {
        int count = cartService.count(getUid());
        return BaseResponse.ok(count);
    }
}
