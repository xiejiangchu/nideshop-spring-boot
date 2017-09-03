package com.xie.controller;

import com.xie.bean.GoodsAttribute;
import com.xie.response.BaseResponse;
import com.xie.service.GoodsAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xie on 17/9/3.
 */
@Controller
@RequestMapping("/goodsAttribute")
public class GoodsAttributeController {

    @Autowired
    private GoodsAttributeService goodsAttributeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse add(@RequestParam("goodsId") int goodsId,
                            @RequestParam("attributeId") int attributeId,
                            @RequestParam("value") String value) {
        GoodsAttribute goodsAttribute = new GoodsAttribute();
        goodsAttribute.setGoodsId(goodsId);
        goodsAttribute.setAttributeId(attributeId);
        goodsAttribute.setValue(value);

        goodsAttributeService.insertSelective(goodsAttribute);
        return BaseResponse.ok();

    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse update(@RequestParam("id") int id,
                               @RequestParam("goodsId") int goodsId,
                               @RequestParam("attributeId") int attributeId,
                               @RequestParam("value") String value) {
        GoodsAttribute goodsAttribute = new GoodsAttribute();
        goodsAttribute.setId(id);
        goodsAttribute.setGoodsId(goodsId);
        goodsAttribute.setAttributeId(attributeId);
        goodsAttribute.setValue(value);

        goodsAttributeService.updateByPrimaryKeyWithBLOBs(goodsAttribute);
        return BaseResponse.ok();

    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse delete(@RequestParam("id") int id) {
        goodsAttributeService.deleteByPrimaryKey(id);
        return BaseResponse.ok();

    }
}
