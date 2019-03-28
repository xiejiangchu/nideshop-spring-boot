package com.xie.controller.api;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Footprint;
import com.xie.bean.FootprintWithGoods;
import com.xie.response.BaseResponse;
import com.xie.service.FootprintService;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xie on 17/9/3.
 */
@Controller
@RequestMapping("/api/footprint")
public class FootPrintApiController extends BaseController {

    @Autowired
    private FootprintService footprintService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                             @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {
        PageInfo<FootprintWithGoods> footprintWithGoodsList = footprintService.selectByUid(getUid(), page, size);

        List<FootprintWithGoods> list_today = new ArrayList<>();
        List<FootprintWithGoods> list_one_day_ago = new ArrayList<>();
        List<FootprintWithGoods> list_two_day_ago = new ArrayList<>();
        List<FootprintWithGoods> list_three_day_ago = new ArrayList<>();
        footprintWithGoodsList.getList().forEach(item -> {
            if (DateTime.now().withTimeAtStartOfDay().toDate().compareTo(item.getAddTime()) < 0) {
                item.setAddTimeStr("今天");
                list_today.add(item);
            } else if (DateTime.now().minusDays(1).withTimeAtStartOfDay().toDate().compareTo(item.getAddTime()) < 0) {
                item.setAddTimeStr("昨天");
                list_one_day_ago.add(item);
            } else if (DateTime.now().minusDays(2).withTimeAtStartOfDay().toDate().compareTo(item.getAddTime()) < 0) {
                item.setAddTimeStr("前天");
                list_two_day_ago.add(item);
            } else {
                item.setAddTimeStr("");
                list_three_day_ago.add(item);
            }
        });

        PageInfo<List<FootprintWithGoods>> paginate = new PageInfo<>();
        BeanUtils.copyProperties(footprintWithGoodsList, paginate);
        List<List<FootprintWithGoods>> list=new ArrayList<>();
        if(list_today.size()>0){
            list.add(list_today);
        }
        if(list_one_day_ago.size()>0){
            list.add(list_one_day_ago);
        }
        if(list_two_day_ago.size()>0){
            list.add(list_two_day_ago);
        }
        if(list_three_day_ago.size()>0){
            list.add(list_three_day_ago);
        }
        paginate.setList(list);


        return BaseResponse.ok(paginate);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse delete(@RequestParam("footprintId") int footprintId) {
        Footprint footprint = footprintService.selectByPrimaryKey(footprintId);
        if (footprint.getUserId() == getUid()) {
            footprintService.deleteByPrimaryKey(footprintId);
            return BaseResponse.ok();
        }
        return BaseResponse.fail();
    }
}
