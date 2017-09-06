package com.xie.controller.api;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Footprint;
import com.xie.bean.FootprintWithGoods;
import com.xie.response.BaseResponse;
import com.xie.service.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return BaseResponse.ok("删除成功");
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
