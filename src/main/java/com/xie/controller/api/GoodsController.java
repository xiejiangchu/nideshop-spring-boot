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
import java.util.stream.Collectors;

/**
 * Created by xie on 17/8/22.
 */
@Controller
@RequestMapping(value = "/api/goods")
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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse list(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                             @RequestParam(value = "brandId", required = false) Integer brandId,
                             @RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "isHot", required = false) Integer isHot,
                             @RequestParam(value = "isNew", required = false) Integer isNew,
                             @RequestParam(value = "sort", required = false) String sort,
                             @RequestParam(value = "order", required = false) Integer order,
                             @RequestParam(value = "page") int page,
                             @RequestParam(value = "size") int size) {

        return BaseResponse.ok(goodsService.selectByParams(categoryId, brandId, keyword, isHot, isNew, sort, order, page, size));
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse category(@RequestParam(value = "id") int id) {
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
    public BaseResponse detail(@RequestParam(value = "id") int id) {
        GoodsDetailResponse goodsDetailResponse = new GoodsDetailResponse();
        Goods goods = goodsService.selectByPrimaryKey(id);
        List<GoodsGallery> goodsGalleries = goodsGalleryService.selectByGoodsId(id);
        List<GoodsAttribute> attributes = goodsAttributeService.selectByGoodsId(id);
        List<GoodsIssue> goodsIssues = goodsIssueService.selectByGoodsId(id);
        Brand brand = brandService.selectByPrimaryKey(goods.getBrandId());
        int commentCount = commentService.countByGoodsIdAndType(id, 0);
        List<Comment> hotComment = commentService.selectByGoodsIdAndType(id, 0);

        goodsDetailResponse.setAttributes(attributes);
        goodsDetailResponse.setBrand(brand);
        goodsDetailResponse.setCommentCount(commentCount);
        goodsDetailResponse.setHotComment(hotComment);
        goodsDetailResponse.setGoodsGalleries(goodsGalleries);
        goodsDetailResponse.setGoodsIssues(goodsIssues);

        return BaseResponse.ok(goodsDetailResponse);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse count() {

        return BaseResponse.ok(goodsService.count());
    }

    @RequestMapping(value = "/related", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse related(@RequestParam(value = "id") int id) {

        List<RelatedGoods> relatedGoodses = relatedGoodsService.selectByGoodsId(id);
        if (null == relatedGoodses || relatedGoodses.size() == 0) {
            Goods goods = goodsService.selectByPrimaryKey(id);
            List<GoodsShort> goodsList = goodsService.selectPartialByCategory(goods.getCategoryId());
            return BaseResponse.ok(goodsList);
        } else {
            List<Integer> ids = relatedGoodses.stream().map(item -> item.getId()).collect(Collectors.toList());
            List<GoodsShort> goodsList = goodsService.selectPartialByPrimaryKeys(ids);
            return BaseResponse.ok(goodsList);
        }
    }

}
