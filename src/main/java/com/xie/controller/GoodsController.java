package com.xie.controller;

import com.github.pagehelper.PageInfo;
import com.xie.bean.*;
import com.xie.controller.api.BaseController;
import com.xie.response.BaseResponse;
import com.xie.response.GoodDetail;
import com.xie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private UploadService uploadService;

    @Autowired
    private AttributeService attributeService;

    @Autowired
    private SpecificationService specificationService;

    @Autowired
    private ProductService productService;


    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "40") int pageSize,
                        Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品信息");
        PageInfo<Goods> goodsPageInfo = goodsService.selectGoods(pageNum, pageSize);
        model.addAttribute("goodsPageInfo", goodsPageInfo);
        model.addAttribute("goodsCount", goodsService.count());
        return "goods";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String detail(Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品添加");
        return "goodsAdd";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id") int id, Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品详情");
        model.addAttribute("token", uploadService.token());

        GoodDetail goodDetail = new GoodDetail();
        Goods goods = goodsService.selectByPrimaryKey(id);
        List<GoodsGallery> goodsGalleries = goodsGalleryService.selectByGoodsId(id);
        List<GoodsAttribute> attributes = goodsAttributeService.selectByGoodsId(id);
        List<GoodsIssue> goodsIssues = goodsIssueService.selectByGoodsId(id);
        Brand brand = brandService.selectByPrimaryKey(goods.getBrandId());
        int commentCount = commentService.countByGoodsIdAndType(id, 0);
        List<Comment> hotComment = commentService.selectByGoodsIdAndType(id, 0);


        PageInfo<Attribute> attributePageInfo = attributeService.selectByAttributeCategory(goods.getCategoryId(), 1, 100);
        model.addAttribute("attributePageInfo", attributePageInfo);

        goodDetail.setGoods(goods);
        goodDetail.setAttributes(attributes);
        goodDetail.setBrand(brand);
        goodDetail.setCommentCount(commentCount);
        goodDetail.setHotComment(hotComment);

        /**
         * 相册
         */
        goodDetail.setGoodsGalleries(goodsGalleries);
        /**
         * 问与答
         */
        goodDetail.setGoodsIssues(goodsIssues);

        /**
         * 当前商品规格列表
         */
        goodDetail.setSpecificationList(goodsService.getGoodsSpecificationList(id));

        /**
         * 规格种类
         */
        goodDetail.setSpecifications(specificationService.select(1, 100).getList());

        /**
         * 产品列表
         */
        goodDetail.setProductWithGoodsSpecificationList(productService.selectFullByGoodsId(id));

        model.addAttribute("goodsDetail", goodDetail);

        model.addAttribute("categoryL1List", categoryService.selectFullMainCategory());

        return "goodsDetail";
    }

    @RequestMapping(value = "/hot", method = RequestMethod.GET)
    public String isHot(@RequestParam(value = "id") int id,
                        @RequestParam(value = "isHot") int isHot,
                        @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {


        Goods goods = goodsService.selectByPrimaryKey(id);
        goods.setIsHot(isHot);

        goodsService.updateByPrimaryKey(goods);

        return "forward:/goods?pageNum=" + pageNum + "&pageSize=" + pageSize;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String isNew(@RequestParam(value = "id") int id,
                        @RequestParam(value = "isNew") int isNew,
                        @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {


        Goods goods = goodsService.selectByPrimaryKey(id);
        goods.setIsNew(isNew);

        goodsService.updateByPrimaryKey(goods);

        return "forward:/goods?pageNum=" + pageNum + "&pageSize=" + pageSize;
    }


    @RequestMapping(value = "/categoryUpdate", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updateBaseInfo(@RequestParam("id") int id,
                                       @RequestParam("categoryId") int categoryId) {
        if (categoryService.selectByPrimaryKey(categoryId) != null) {
            Goods goods = new Goods();
            goods.setId(id);
            goods.setCategoryId(categoryId);

            goodsService.updateByPrimaryKeySelective(goods);
            return BaseResponse.ok();
        }
        return BaseResponse.fail();
    }


    @RequestMapping(value = "/enabled", method = RequestMethod.GET)
    public String enabled(@RequestParam(value = "id") int id,
                          @RequestParam(value = "enabled") int enabled,
                          @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {


        Goods goods = goodsService.selectByPrimaryKey(id);
        goods.setIsOnSale(enabled);

        goodsService.updateByPrimaryKey(goods);

        return "forward:/goods?pageNum=" + pageNum + "&pageSize=" + pageSize;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") int id,
                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {

        goodsService.deleteByPrimaryKey(id);
        return "forward:/goods?pageNum=" + pageNum + "&pageSize=" + pageSize;
    }


    @RequestMapping(value = "/addBaseInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse addBaseInfo(
            @RequestParam("name") String name,
            @RequestParam("goodsSn") String goodsSn,
            @RequestParam("keywords") String keywords,
            @RequestParam("goodsUnit") String goodsUnit,
            @RequestParam("promotionTag") String promotionTag,
            @RequestParam("promotionDesc") String promotionDesc,
            @RequestParam("goodsBrief") String goodsBrief) {

        Goods goods = new Goods();
        goods.setName(name);
        goods.setGoodsSn(goodsSn);
        goods.setKeywords(keywords);
        goods.setGoodsUnit(goodsUnit);
        goods.setPromotionDesc(promotionDesc);
        goods.setPromotionTag(promotionTag);
        goods.setGoodsBrief(goodsBrief);

        int id = goodsService.insertSelective(goods);
        return BaseResponse.ok(id);

    }

    @RequestMapping(value = "/updateBaseInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updateBaseInfo(@RequestParam("id") int id,
                                       @RequestParam("name") String name,
                                       @RequestParam("goodsSn") String goodsSn,
                                       @RequestParam("keywords") String keywords,
                                       @RequestParam("goodsUnit") String goodsUnit,
                                       @RequestParam("promotionTag") String promotionTag,
                                       @RequestParam("promotionDesc") String promotionDesc,
                                       @RequestParam("goodsBrief") String goodsBrief) {

        Goods goods = new Goods();
        goods.setId(id);
        goods.setName(name);
        goods.setGoodsSn(goodsSn);
        goods.setKeywords(keywords);
        goods.setGoodsUnit(goodsUnit);
        goods.setPromotionDesc(promotionDesc);
        goods.setPromotionTag(promotionTag);
        goods.setGoodsBrief(goodsBrief);

        goodsService.updateByPrimaryKeySelective(goods);
        return BaseResponse.ok();

    }


    @RequestMapping(value = "/updateGoodsDesc", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updateGoodsDesc(@RequestParam("id") int id,
                                        @RequestParam("goodsDesc") String goodsDesc) {

        Goods goods = new Goods();
        if (StringUtils.isEmpty(goodsDesc)) {
            return BaseResponse.fail("内容不能为空");
        }
        goods.setId(id);
        goods.setGoodsDesc(goodsDesc);

        goodsService.updateByPrimaryKeySelective(goods);
        return BaseResponse.ok();
    }


    @RequestMapping(value = "/updateGoodsPic", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updateGoodsPic(@RequestParam("id") int gid,
                                       @RequestParam("primaryPicUrl") String primaryPicUrl,
                                       @RequestParam(value = "listPicUrl", required = false) String listPicUrl,
                                       @RequestParam(value = "detailPicUrl", required = false) List<String> detailPicUrls) {

        Goods goods = new Goods();
        goods.setId(gid);
        if (!StringUtils.isEmpty(primaryPicUrl)) {
            goods.setPrimaryPicUrl(primaryPicUrl);
        }
        if (!StringUtils.isEmpty(listPicUrl)) {
            goods.setListPicUrl(listPicUrl);
        }
        goodsService.updateByPrimaryKeySelective(goods);

        if (detailPicUrls != null && detailPicUrls.size() > 0) {
            goodsGalleryService.deleteByGoodsId(gid);
            for (int i = 0; i < detailPicUrls.size(); i++) {
                if (!StringUtils.isEmpty(detailPicUrls.get(i))) {
                    GoodsGallery goodsGallery = new GoodsGallery();
                    goodsGallery.setGoodsId(gid);
                    goodsGallery.setImgUrl(detailPicUrls.get(i));
                    goodsGallery.setSortOrder(detailPicUrls.size() - i);
                    goodsGalleryService.insertSelective(goodsGallery);
                }
            }
        }


        return BaseResponse.ok();
    }


    @RequestMapping(value = "/updateGoodsPrice", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updateGoodsPrice(@RequestParam("id") int id,
                                         @RequestParam("goodsNumber") int goodsNumber,
                                         @RequestParam("counterPrice") double counterPrice,
                                         @RequestParam("extraPrice") double extraPrice,
                                         @RequestParam("retailPrice") double retailPrice,
                                         @RequestParam("unitPrice") double unitPrice,
                                         @RequestParam("appExclusivePrice") double appExclusivePrice,
                                         @RequestParam("sellVolume") int sellVolume) {

        Goods goods = new Goods();
        goods.setId(id);
        goods.setGoodsNumber(goodsNumber);
        goods.setCounterPrice(counterPrice);
        goods.setExtraPrice(extraPrice);
        goods.setRetailPrice(retailPrice);
        goods.setUnitPrice(unitPrice);
        goods.setAppExclusivePrice(appExclusivePrice);
        goods.setSellVolume(sellVolume);

        goodsService.updateByPrimaryKeySelective(goods);
        return BaseResponse.ok();
    }


}
