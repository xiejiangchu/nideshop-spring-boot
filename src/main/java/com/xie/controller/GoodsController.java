package com.xie.controller;

import com.github.pagehelper.PageInfo;
import com.xie.bean.*;
import com.xie.controller.api.BaseController;
import com.xie.response.GoodsDetailResponse;
import com.xie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by xie on 17/1/7.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsGalleryService goodsGalleryService;

    @Autowired
    private GoodsAttributeService goodsAttributeService;

    @Autowired
    private GoodsIssueService goodsIssueService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RelatedGoodsService relatedGoodsService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
                        Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品信息");
        PageInfo<Goods> goodsPageInfo = goodsService.selectGoods(pageNum, pageSize);
        model.addAttribute("goodsPageInfo", goodsPageInfo);
        model.addAttribute("goodsCount", goodsService.count());
        return "goods";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id") int id, Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品详情");

        GoodsDetailResponse goodsDetailResponse = new GoodsDetailResponse();
        Goods goods = goodsService.selectByPrimaryKey(id);
        List<GoodsGallery> goodsGalleries = goodsGalleryService.selectByGoodsId(id);
        List<GoodsAttribute> attributes = goodsAttributeService.selectByGoodsId(id);
        List<GoodsIssue> goodsIssues = goodsIssueService.selectByGoodsId(id);
        Brand brand = brandService.selectByPrimaryKey(goods.getBrandId());
        int commentCount = commentService.countByGoodsIdAndType(id, 0);
        List<Comment> hotComment = commentService.selectByGoodsIdAndType(id, 0);

        goodsDetailResponse.setGoods(goods);
        goodsDetailResponse.setAttributes(attributes);
        goodsDetailResponse.setBrand(brand);
        goodsDetailResponse.setCommentCount(commentCount);
        goodsDetailResponse.setHotComment(hotComment);
        goodsDetailResponse.setGoodsGalleries(goodsGalleries);
        goodsDetailResponse.setGoodsIssues(goodsIssues);

        model.addAttribute("goodsDetail", goodsDetailResponse);
        return "goodsDetail";
    }

}
