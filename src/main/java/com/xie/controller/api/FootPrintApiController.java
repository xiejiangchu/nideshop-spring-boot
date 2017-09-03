package com.xie.controller.api;

import com.xie.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xie on 17/9/3.
 */
@Controller
@RequestMapping("/api/footprint")
public class FootPrintApiController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse list() {
        return BaseResponse.ok();
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse delete() {
        return BaseResponse.ok();
    }
}
