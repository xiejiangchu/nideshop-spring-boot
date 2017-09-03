package com.xie.controller.api;

import com.xie.response.BaseResponse;
import com.xie.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xie on 17/8/26.
 */
@Controller
@RequestMapping(value = "/api/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse list(@RequestParam("parentId") int parentId) {

        return BaseResponse.ok(regionService.selectByPatentId(parentId));
    }
}
