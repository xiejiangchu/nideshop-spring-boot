package com.xie.controller;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Ad;
import com.xie.controller.api.BaseController;
import com.xie.service.AdService;
import com.xie.service.UploadService;
import com.xie.utils.MallConstants;
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

    @Autowired
    private UploadService uploadService;

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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        setHeaderData(model);
        model.addAttribute("title", "新增广告位");
        model.addAttribute("adPositionTypeList", MallConstants.AdPositionType.json());
        model.addAttribute("mediaTypeList", MallConstants.MediaType.json());
        model.addAttribute("token", uploadService.token());
        return "adAdd";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam("id") short id,
                         @RequestParam("adPositionId") short adPositionId,
                         @RequestParam("mediaType") short mediaType,
                         @RequestParam("name") String name,
                         @RequestParam("link") String link,
                         @RequestParam("imageUrl") String imageUrl,
                         @RequestParam("content") String content) {
        Ad ad = new Ad();
        ad.setId(id);
        ad.setAdPositionId(adPositionId);
        ad.setMediaType((byte) mediaType);
        ad.setName(name);
        ad.setLink(link);
        ad.setImageUrl(imageUrl);
        ad.setContent(content);
        ad.setEnabled((byte) 1);

        adService.updateByPrimaryKeyWithBLOBs(ad);
        return "redirect:/ad";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id") int id, Model model) {
        setHeaderData(model);
        model.addAttribute("title", "广告位详情");
        model.addAttribute("adPositionTypeList", MallConstants.AdPositionType.json());
        model.addAttribute("mediaTypeList", MallConstants.MediaType.json());

        Ad ad = adService.selectByPrimaryKey((short) id);
        model.addAttribute("ad", ad);
        model.addAttribute("token", uploadService.token());
        return "adDetail";
    }

    @RequestMapping(value = "/enabled", method = RequestMethod.GET)
    public String enabled(@RequestParam(value = "id") int id,
                          @RequestParam(value = "enabled") int enabled) {


        Ad ad = adService.selectByPrimaryKey((short) id);
        ad.setEnabled((byte) enabled);

        adService.updateByPrimaryKey(ad);

        return "redirect:/ad";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") int id) {

        adService.deleteByPrimaryKey((short) id);
        return "redirect:/ad";
    }
}
