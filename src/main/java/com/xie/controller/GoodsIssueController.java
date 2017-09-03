package com.xie.controller;

import com.xie.bean.GoodsIssue;
import com.xie.response.BaseResponse;
import com.xie.service.GoodsIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xie on 17/9/3.
 */
@Controller
@RequestMapping("/goodsIssue")
public class GoodsIssueController {

    @Autowired
    private GoodsIssueService goodsIssueService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse update(@RequestParam("id") int id,
                               @RequestParam("goodsId") int goodsId,
                               @RequestParam("answer") String answer) {
        GoodsIssue goodsIssue = new GoodsIssue();
        goodsIssue.setId(id);
        goodsIssue.setAnswer(answer);

        goodsIssueService.updateByPrimaryKeySelective(goodsIssue);
        return BaseResponse.ok();

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse delete(@RequestParam("id") int id) {
        goodsIssueService.deleteByPrimaryKey(id);
        return BaseResponse.ok();

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse add(@RequestParam("goodsId") int goodsId,
                            @RequestParam("question") String question,
                            @RequestParam("answer") String answer) {
        GoodsIssue goodsIssue = new GoodsIssue();
        goodsIssue.setGoodsId(goodsId);
        goodsIssue.setQuestion(question);
        goodsIssue.setAnswer(answer);

        goodsIssueService.insertSelective(goodsIssue);
        return BaseResponse.ok();

    }


    @RequestMapping(value = "/copy")
    @ResponseBody
    public BaseResponse copy(@RequestParam(value = "from", required = false, defaultValue = "1127052") int from,
                             @RequestParam("to") int to) {
        List<GoodsIssue> goodsIssues = goodsIssueService.selectByGoodsId(from);

        for (int j = 0; j < goodsIssues.size(); j++) {
            GoodsIssue goodsIssue = new GoodsIssue();
            goodsIssue.setGoodsId(to);
            goodsIssue.setQuestion(goodsIssues.get(j).getQuestion());
            goodsIssue.setAnswer(goodsIssues.get(j).getAnswer());
            goodsIssueService.insertSelective(goodsIssue);
        }
        return BaseResponse.ok();

    }

}
