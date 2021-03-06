package com.xie.controller.api;

import com.xie.bean.CategoryShort;
import com.xie.response.BaseResponse;
import com.xie.response.IndexResponse;
import com.xie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xie on 17/1/7.
 */
@Controller
public class IndexController {

    @Autowired
    private AdService adService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ChannelService channelService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse index() {
        IndexResponse indexResponse = new IndexResponse();
        indexResponse.setBanner(adService.selectByPosition(1));
        indexResponse.setHotGoodsList(goodsService.selectHotGoods(1, 4).getList());
        indexResponse.setNewGoodsList(goodsService.selectNewGoods(1, 4).getList());
        indexResponse.setBrandList(brandService.selectNewBrands(1, 4).getList());
        indexResponse.setTopicList(topicService.select(1, 3).getList());

        List<CategoryShort> mainCategory = categoryService.selectMainCategory();
        List<Integer> ids = mainCategory.stream().map(item -> item.getId()).distinct().collect(Collectors.toList());
        List<CategoryShort> categories = categoryService.selectByParents(ids);
        categories.stream().forEach(item->item.setGoodsList(goodsService.selectPartialByCategory(item.getId())));
        indexResponse.setCategoryList(categories);

        indexResponse.setChannel(channelService.selectAll(1, 10).getList());
        return BaseResponse.ok(indexResponse);
    }

}
