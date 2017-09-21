package com.xie.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.xie.bean.*;
import com.xie.response.BaseResponse;
import com.xie.response.CategoryGoodsResponse;
import com.xie.response.GoodsDetailResponse;
import com.xie.service.*;
import com.xie.utils.MallConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xie on 17/8/22.
 */
@Controller
@RequestMapping(value = "/api/goods")
public class GoodsApiController extends BaseController {

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

    @Autowired
    private GoodsSpecificationService goodsSpecificationService;

    @Autowired
    private CollectService collectService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @Cacheable(value = MallConstants.CACHE_NAME, key = "#root.methodName")
    public BaseResponse list(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                             @RequestParam(value = "brandId", required = false) Integer brandId,
                             @RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "isHot", required = false) Integer isHot,
                             @RequestParam(value = "isNew", required = false) Integer isNew,
                             @RequestParam(value = "sort", required = false) String sort,
                             @RequestParam(value = "order", required = false) String order,
                             @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                             @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {

        if (categoryId != null && categoryId == 0) {
            categoryId = null;
        }

        if (brandId != null && brandId == 0) {
            brandId = null;
        }

        List<CategoryShort> filterCategory = new ArrayList<>();
        CategoryShort categoryShort = new CategoryShort();
        categoryShort.setId(0);
        categoryShort.setName("全部");
        categoryShort.setChecked(false);
        filterCategory.add(categoryShort);

        PageInfo<GoodsShort> goodsList = goodsService.selectByParams(categoryId, brandId, keyword, isHot, isNew, sort, order, page, size);
        List<Integer> categoryIds = goodsList.getList().stream().map(item -> item.getCategoryId()).distinct().collect(Collectors.toList());
        if (categoryIds != null && categoryIds.size() > 0) {
            List<Category> categoryShortList = categoryService.selectByPrimaryKeys(categoryIds);
            List<Integer> parent_categoryIds = categoryShortList.stream().map(item -> item.getId()).distinct().collect(Collectors.toList());
            if (parent_categoryIds != null && parent_categoryIds.size() > 0) {
                List<CategoryShort> parent_categoryShortList = categoryService.selectShortByPrimaryKeys(parent_categoryIds);
                if (parent_categoryShortList != null && parent_categoryShortList.size() > 0) {
                    filterCategory.addAll(parent_categoryShortList);
                }
            }
        }

        Integer finalCategoryId = categoryId;
        filterCategory.forEach(item -> {
            if ((finalCategoryId == null && item.getId() == 0) || (item.getId() == finalCategoryId)) {
                item.setChecked(true);
            } else {
                item.setChecked(false);
            }
        });

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("goodsList", goodsList);
        jsonObject.put("filterCategory", filterCategory);
        return BaseResponse.ok(jsonObject);
    }


    @RequestMapping(value = "/sku", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse list(@RequestParam(value = "id", required = false) Integer id) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("productList", productService.selectByGoodsId(id));
        jsonObject.put("specificationList", goodsService.getGoodsSpecificationList(id));
        return BaseResponse.ok(jsonObject);
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

        goodsDetailResponse.setGoods(goods);
        goodsDetailResponse.setAttributes(attributes);
        goodsDetailResponse.setBrand(brand);
        goodsDetailResponse.setCommentCount(commentCount);
        goodsDetailResponse.setHotComment(hotComment);
        goodsDetailResponse.setGoodsGalleries(goodsGalleries);
        goodsDetailResponse.setGoodsIssues(goodsIssues);
        goodsDetailResponse.setSpecificationList(goodsService.getGoodsSpecificationList(id));
        goodsDetailResponse.setProductList(productService.selectByGoodsId(id));
        goodsDetailResponse.setUserHasCollect(collectService.selectByParams(getUid(), MallConstants.CollectType.商品.getVal(), id) == null ? 0 : 1);

        return BaseResponse.ok(goodsDetailResponse);
    }


    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse filter(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                               @RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(value = "isHot", required = false) Integer isHot,
                               @RequestParam(value = "isNew", required = false) Integer isNew,
                               @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam(value = "size", required = false, defaultValue = "1000") Integer size) {

        if (categoryId != null && categoryId == 0) {
            categoryId = null;
        }

        List<CategoryShort> filterCategory = new ArrayList<>();
        CategoryShort categoryShort = new CategoryShort();
        categoryShort.setId(0);
        categoryShort.setName("全部");
        categoryShort.setChecked(false);
        filterCategory.add(categoryShort);

        PageInfo<GoodsShort> goodsList = goodsService.selectByParams(categoryId, null, keyword, isHot, isNew, null, null, page, size);
        List<Integer> categoryIds = goodsList.getList().stream().map(item -> item.getCategoryId()).distinct().collect(Collectors.toList());
        if (categoryIds != null && categoryIds.size() > 0) {
            List<Category> categoryShortList = categoryService.selectByPrimaryKeys(categoryIds);
            List<Integer> parent_categoryIds = categoryShortList.stream().map(item -> item.getId()).distinct().collect(Collectors.toList());
            if (parent_categoryIds != null && parent_categoryIds.size() > 0) {
                List<CategoryShort> parent_categoryShortList = categoryService.selectShortByPrimaryKeys(parent_categoryIds);
                if (parent_categoryShortList != null && parent_categoryShortList.size() > 0) {
                    filterCategory.addAll(parent_categoryShortList);
                }
            }
        }

        Integer finalCategoryId = categoryId;
        filterCategory.forEach(item -> {
            if ((finalCategoryId == null && item.getId() == 0) || (item.getId() == finalCategoryId)) {
                item.setChecked(true);
            } else {
                item.setChecked(false);
            }
        });

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("goodsList", goodsList);
        jsonObject.put("filterCategory", filterCategory);
        return BaseResponse.ok(jsonObject);
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


    @RequestMapping(value = "/hot", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse hot() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", "");
        jsonObject.put("name", "大家都在买的严选好物");
        jsonObject.put("imgUrl", "http://yanxuan.nosdn.127.net/8976116db321744084774643a933c5ce.png");

        return BaseResponse.ok(jsonObject);
    }


    @RequestMapping(value = "/new", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse newAction() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", "");
        jsonObject.put("name", "坚持初心，为你寻觅世间好物");
        jsonObject.put("imgUrl", "http://yanxuan.nosdn.127.net/8976116db321744084774643a933c5ce.png");

        return BaseResponse.ok(jsonObject);
    }

}
