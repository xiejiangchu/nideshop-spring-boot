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
@RequestMapping(value = "/api/address")
public class AddressApiController extends BaseController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse list() {

        return BaseResponse.ok(addressService.selectWithNameByUid(getUid()));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse detail(@RequestParam("id") int id) {
        if (id <= 0) {
            return BaseResponse.ok();
        }
        return BaseResponse.ok(addressService.selectWithNameByPrimaryKey(id));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    BaseResponse save(@RequestBody Address address) {
        int clean = addressService.updateDefaultByUid(getUid());
        int result = addressService.insert(address);
        return BaseResponse.ok(addressService.selectByPrimaryKey(result));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    BaseResponse delete(@RequestParam("id") int id) {
        if (addressService.selectByPrimaryKey(id).getUserId() == getUid()) {
            return BaseResponse.ok(addressService.deleteByPrimaryKey(id));
        }
        return BaseResponse.fail("未找到");
    }
}
