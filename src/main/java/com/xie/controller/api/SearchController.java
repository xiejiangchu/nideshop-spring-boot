package com.xie.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.xie.bean.Keywords;
import com.xie.bean.SearchHistory;
import com.xie.response.BaseResponse;
import com.xie.service.KeywordsService;
import com.xie.service.SearchHistoryService;
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
@RequestMapping(value = "/api/search")
public class SearchController extends BaseController {

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

    @RequestMapping(value = "/helper", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse keyword(@RequestParam(value = "keyword", required = false) String keyword) {
        List<Keywords> keywordsList = keywordsService.selectLikePrimaryKey(keyword);
        List<String> stringList = keywordsList.stream().map(item -> item.getKeyword()).collect(Collectors.toList());
        return BaseResponse.ok(stringList);
    }


    @RequestMapping(value = "/clearHistory", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse clearHistory() {
        searchHistoryService.deleteByUid(getUid());
        return BaseResponse.ok();
    }

}
