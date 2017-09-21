package com.xie.controller.api;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Brand;
import com.xie.response.BaseResponse;
import com.xie.service.BrandService;
import com.xie.utils.MallConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xie on 17/8/31.
 */
@Controller
@RequestMapping(value = "/api/brand")
public class BrandApiController extends BaseController {

    @Autowired
    private BrandService brandService;



    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @Cacheable(value = MallConstants.CACHE_NAME, key = "#root.methodName+#page")
    public BaseResponse list(@RequestParam(value = "page") int page,
                             @RequestParam(value = "size") int size) {
        PageInfo<Brand> brandList = brandService.select(page, size);
        return BaseResponse.ok(brandList);
    }


    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse detail(@RequestParam(value = "id") int id) {
        return BaseResponse.ok(brandService.selectByPrimaryKey(id));
    }

}
