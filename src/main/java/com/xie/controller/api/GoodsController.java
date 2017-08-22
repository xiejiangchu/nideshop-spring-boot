package com.xie.controller.api;

import com.xie.bean.*;
import com.xie.response.BaseResponse;
import com.xie.response.CategoryGoodsResponse;
import com.xie.response.GoodsDetailResponse;
import com.xie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse getUser(@RequestParam(value = "categoryId", required = false) int categoryId,
                         @RequestParam(value = "brandId", required = false) int brandId,
                         @RequestParam(value = "keyword", required = false) String keyword,
                         @RequestParam(value = "isHot", required = false) int isHot,
                         @RequestParam(value = "isNew", required = false) int isNew,
                         @RequestParam(value = "page") int page,
                         @RequestParam(value = "size") int size,
                         @RequestParam(value = "sort", required = false) String sort,
                         @RequestParam(value = "order", required = false) int order) {

        return BaseResponse.ok();
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse category(@RequestParam(value = "id") int id) {
        CategoryGoodsResponse categoryGoodsResponse = new CategoryGoodsResponse();
        Category currentCategory = categoryService.selectByPrimaryKey(id);
        Category parentCategory = categoryService.selectByPrimaryKey(currentCategory.getParentId());
        List<Category> brotherCategory = categoryService.selectByParent(currentCategory.getParentId());
//        List<GoodsShort> categoryGoods = goodsService.selectPartialByCategory(id);
        categoryGoodsResponse.setCurrentCategory(currentCategory);
        categoryGoodsResponse.setParentCategory(parentCategory);
        categoryGoodsResponse.setBrotherCategory(brotherCategory);
        return BaseResponse.ok(categoryGoodsResponse);
    }


    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse detail(@RequestParam(value = "id") int id) {
        GoodsDetailResponse goodsDetailResponse = new GoodsDetailResponse();
        Goods goods = goodsService.selectByPrimaryKey(id);
        List<GoodsGallery> goodsGalleries = goodsGalleryService.selectByGoodsId(id);
        List<GoodsAttribute> attributes = goodsAttributeService.selectByGoodsId(id);
        List<GoodsIssue> goodsIssues = goodsIssueService.selectByGoodsId(id);
        Brand brand = brandService.selectByPrimaryKey(goods.getBrandId());
        int commentCount = commentService.countByGoodsIdAndType(id, 0);
        List<Comment> hotComment = commentService.selectByGoodsIdAndType(id, 0);

        return BaseResponse.ok(goodsDetailResponse);
    }
}
