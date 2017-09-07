package com.xie.controller;

import com.xie.bean.Product;
import com.xie.controller.api.BaseController;
import com.xie.response.BaseResponse;
import com.xie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xie on 17/9/6.
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/priceUpdate", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse priceUpdate(@RequestParam("goodsId") int goodsId,
                                    @RequestParam("id") int id,
                                    @RequestParam("goodsNumber") int goodsNumber,
                                    @RequestParam("retailPrice") double retailPrice) {
        Product product = new Product();
        product.setId(id);
        product.setGoodsId(goodsId);
        product.setGoodsNumber(goodsNumber);
        product.setRetailPrice(retailPrice);

        productService.updateByPrimaryKeyAndGid(product);
        return BaseResponse.ok();
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse add(@RequestParam("goodsId") int goodsId,
                            @RequestParam("goodsSpecification[]") List<String> goodsSpecification,
                            @RequestParam("goodsNumber") int goodsNumber,
                            @RequestParam("goodsSn") String goodsSn,
                            @RequestParam("retailPrice") double retailPrice) {

        if (productService.selectByGoodsSn(goodsSn) != null) {
            return BaseResponse.fail("Sn已经存在");
        }
        Product product = new Product();
        product.setGoodsSpecificationIds(String.join("_", goodsSpecification));
        product.setGoodsId(goodsId);
        product.setGoodsNumber(goodsNumber);
        product.setRetailPrice(retailPrice);
        product.setGoodsSn(goodsSn);

        productService.insert(product);
        return BaseResponse.ok();
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse delete(@RequestParam("id") int id) {

        productService.deleteByPrimaryKey(id);
        return BaseResponse.ok();
    }
}
