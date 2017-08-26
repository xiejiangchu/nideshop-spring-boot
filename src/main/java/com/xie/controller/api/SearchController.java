package com.xie.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.xie.bean.Keywords;
import com.xie.bean.SearchHistory;
import com.xie.bean.Topic;
import com.xie.response.BaseResponse;
import com.xie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
@Controller
@RequestMapping(value = "/api/search")
public class SearchController extends BaseController {


    @Autowired
    private TopicService topicService;

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
    private KeywordsService keywordsService;

    @Autowired
    private SearchHistoryService searchHistoryService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse index() {
        List<Keywords> defaultKeyword = keywordsService.defaultKeyword(1, 1).getList();
        List<Keywords> hotKeywordList = keywordsService.hotKeyword(1, 10).getList();
        List<SearchHistory> historyKeywordList = searchHistoryService.historyKeyword(getUid(), 1, 10).getList();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("defaultKeyword", defaultKeyword);
        jsonObject.put("hotKeywordList", hotKeywordList);
        jsonObject.put("historyKeywordList", historyKeywordList);
        return BaseResponse.ok(jsonObject);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse detail(@RequestParam(value = "id", required = false) int id) {

        return BaseResponse.ok(topicService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "/related", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse related(@RequestParam(value = "id", required = false) int id) {

        return BaseResponse.ok(topicService.select(1, 4).getList());

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    BaseResponse post(@RequestBody Topic record) {

        return BaseResponse.ok(topicService.insert(record));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    BaseResponse put(@RequestBody Topic record) {

        return BaseResponse.ok(topicService.updateByPrimaryKey(record));
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    @ResponseBody
    BaseResponse delete(@RequestParam int id) {

        return BaseResponse.ok(topicService.deleteByPrimaryKey(id));
    }
}
