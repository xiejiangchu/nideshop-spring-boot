package com.xie.controller;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Ad;
import com.xie.controller.api.BaseController;
import com.xie.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xie on 17/8/30.
 */
@Controller
@RequestMapping("/ad")
public class AdController extends BaseController {

    @Autowired
    private AdService adService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
                        Model model) {
        setHeaderData(model);
        model.addAttribute("title", "广告位");
        PageInfo<Ad> adPageInfo = adService.select(pageNum, pageSize);
        model.addAttribute("adPageInfo", adPageInfo);
        model.addAttribute("adCount", adService.count());
        return "ad";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id") int id, Model model) {
        setHeaderData(model);
        model.addAttribute("title", "广告位详情");

        Ad ad = adService.selectByPrimaryKey((short) id);
        model.addAttribute("ad", ad);
        return "adDetail";
    }
}
