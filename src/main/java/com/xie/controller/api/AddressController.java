package com.xie.controller.api;

import com.xie.bean.Address;
import com.xie.response.BaseResponse;
import com.xie.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    BaseResponse list(@RequestParam("uid") int uid) {

        return BaseResponse.ok(addressService.selectWithNameByUid(uid));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse detail(@RequestParam("id") int id) {

        return BaseResponse.ok(addressService.selectWithNameByPrimaryKey(id));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    BaseResponse save(@RequestBody Address address) {
        int result = addressService.insert(address);
        return BaseResponse.ok(addressService.selectByPrimaryKey(result));
    }
}
