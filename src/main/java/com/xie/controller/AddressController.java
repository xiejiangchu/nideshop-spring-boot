package com.xie.controller;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Address;
import com.xie.bean.Region;
import com.xie.controller.api.BaseController;
import com.xie.response.BaseResponse;
import com.xie.service.AddressService;
import com.xie.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xie on 17/1/7.
 */
@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {


    @Autowired
    private AddressService addressService;

    @Autowired
    private RegionService regionService;


    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "40") int pageSize,
                        Model model) {
        setHeaderData(model);
        model.addAttribute("title", "地址列表");
        PageInfo<Address> goodsPageInfo = addressService.selectAddress(pageNum, pageSize);
        model.addAttribute("addressPageInfo", goodsPageInfo);
        model.addAttribute("addressCount", addressService.count());
        return "address";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String detail(Model model) {
        setHeaderData(model);
        model.addAttribute("title", "地址添加");
        return "addressAdd";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id,
                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "40") int pageSize) {
        addressService.deleteByPrimaryKey(id);
        return "forward:/address?pageNum=" + pageNum + "&pageSize=" + pageSize;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id") int id, Model model) {
        setHeaderData(model);
        model.addAttribute("title", "地址详情");
        model.addAttribute("address", addressService.selectWithNameByPrimaryKey(id));
        List<Region> province = regionService.selectByPatentId(1);
        model.addAttribute("province", province);
        List<Region> city = regionService.selectByPatentId(Integer.valueOf(province.get(0).getId()));
        model.addAttribute("city", city);
        List<Region> district = regionService.selectByPatentId(Integer.valueOf(city.get(0).getId()));
        model.addAttribute("district", district);
        return "addressDetail";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updateBaseInfo(@RequestParam("id") int id,
                                       @RequestParam("provinceId") short provinceId,
                                       @RequestParam("cityId") short cityId,
                                       @RequestParam("districtId") short districtId,
                                       @RequestParam("address") String addr) {
        Address address = addressService.selectByPrimaryKey(id);
        address.setProvinceId(provinceId);
        address.setCityId(cityId);
        address.setDistrictId(districtId);
        address.setAddress(addr);
        int result = addressService.updateByPrimaryKey(address);
        if (result <= 0) {
            return BaseResponse.fail();
        }
        return BaseResponse.ok();
    }
}
