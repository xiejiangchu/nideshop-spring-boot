package com.xie.controller.api;

import com.xie.response.BaseResponse;
import com.xie.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xie on 17/8/22.
 */
@Controller
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse getUser(@RequestParam("uid") int uid) {

        return BaseResponse.ok(addressService.selectByUid(uid));
    }
}
