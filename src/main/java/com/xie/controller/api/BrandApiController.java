package com.xie.controller.api;

import com.xie.response.BaseResponse;
import com.xie.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xie on 17/8/31.
 */
@Controller
@RequestMapping(value = "/api/brand")
public class BrandApiController extends BaseController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse index() {

        return BaseResponse.ok();
    }
}
