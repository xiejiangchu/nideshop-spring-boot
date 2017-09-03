package com.xie.controller.api;

import com.xie.bean.Topic;
import com.xie.response.BaseResponse;
import com.xie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xie on 17/8/22.
 */
@Controller
@RequestMapping(value = "/api/topic")
public class TopicApiController extends BaseController {


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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse getUser(@RequestParam(value = "page", required = false) int pageNum,
                         @RequestParam(value = "size", required = false) int pageSize) {

        return BaseResponse.ok(topicService.select(pageNum, pageSize));
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
