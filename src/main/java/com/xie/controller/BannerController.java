package com.xie.controller;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Ad;
import com.xie.controller.api.BaseController;
import com.xie.service.AdService;
import com.xie.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xie on 17/8/30.
 */
@Controller
@RequestMapping("/banner")
public class BannerController extends BaseController {

    @Autowired
    private AdService adService;

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    @ResponseBody
    public PageInfo index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        PageInfo<Ad> adPageInfo = adService.select(pageNum, pageSize);
        return adPageInfo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Ad getById(@RequestParam(value = "id", defaultValue = "1") short id) {
        Ad ad = adService.selectByPrimaryKey(id);
        return ad;
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    @ResponseBody
    public Ad add(@RequestParam(value = "id", defaultValue = "1") short id) {
        Ad ad = adService.selectByPrimaryKey(id);
        return ad;
    }
}
