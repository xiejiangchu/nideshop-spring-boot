package com.xie.controller;

import com.xie.response.BaseResponse;
import com.xie.service.GoodsService;
import com.xie.service.GoodsSpecificationService;
import com.xie.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xie on 17/9/4.
 */
@Controller
@RequestMapping("/goodsSpecification")
public class GoodsSpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @Autowired
    private GoodsSpecificationService goodsSpecificationService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/getByGid")
    @ResponseBody
    public BaseResponse getByGid(@RequestParam("gid") int gid) {

        return BaseResponse.ok(goodsService.getGoodsSpecificationList(gid));
    }
}
