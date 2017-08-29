package com.xie.controller;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Goods;
import com.xie.controller.api.BaseController;
import com.xie.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xie on 17/1/7.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    public String index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
                        Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品信息");
        PageInfo<Goods> goodsPageInfo = goodsService.selectGoods(pageNum, pageSize);
        model.addAttribute("goodsPageInfo", goodsPageInfo);
        return "goods";
    }

}
