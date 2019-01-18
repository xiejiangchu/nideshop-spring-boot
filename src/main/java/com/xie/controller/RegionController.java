package com.xie.controller;

import com.xie.controller.api.BaseController;
import com.xie.response.BaseResponse;
import com.xie.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
@RequestMapping("/region")
public class RegionController extends BaseController {

    @Autowired
    private RegionService regionService;

    @RequestMapping(value = "/getByPid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse index(@PathVariable(value = "id") int id) {
        return BaseResponse.ok(regionService.selectByPatentId(id));
    }
}
