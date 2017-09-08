package com.xie.controller;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Category;
import com.xie.controller.api.BaseController;
import com.xie.response.BaseResponse;
import com.xie.service.CategoryService;
import com.xie.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xie on 17/9/2.
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UploadService uploadService;


    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "40") int pageSize) {
        return "redirect:/category/l1";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id", required = false) Integer id,
                         Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品类别详情");
        Category category = categoryService.selectByPrimaryKey(id);
        model.addAttribute("category", category);
        model.addAttribute("token", uploadService.token());
        return "categoryDetail";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id,
                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "40") int pageSize) {
        Category category = categoryService.selectByPrimaryKey(id);
        if (null == category) {
            return "forward:/category/l1?pageNum=" + pageNum + "&pageSize=" + pageSize;
        }


        if (category.getLevel().equalsIgnoreCase("L1")) {
            categoryService.deleteByParentId(category.getId());
            categoryService.deleteByPrimaryKey(category.getId());
            return "forward:/category/l1?pageNum=" + pageNum + "&pageSize=" + pageSize;
        } else {
            categoryService.deleteByPrimaryKey(category.getId());
            return "forward:/category/l2?pageNum=" + pageNum + "&pageSize=" + pageSize;
        }
    }


    @RequestMapping(value = "/l1", method = RequestMethod.GET)
    public String l1(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                     @RequestParam(value = "pageSize", defaultValue = "40") int pageSize,
                     Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品一级类别");
        PageInfo<Category> categoryPageInfo = categoryService.selectFullMainCategory(pageNum, pageSize);

        model.addAttribute("categoryPageInfo", categoryPageInfo);

        return "categoryL1";
    }


    @RequestMapping(value = "/l2", method = RequestMethod.GET)
    public String l2(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                     @RequestParam(value = "pageSize", defaultValue = "40") int pageSize,
                     Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品二级类别");
        PageInfo<Category> categoryPageInfo = categoryService.selectFullSubCategory(pageNum, pageSize);

        model.addAttribute("categoryPageInfo", categoryPageInfo);

        return "categoryL2";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品类别添加");
        model.addAttribute("token", uploadService.token());

        return "categoryAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse add(@RequestParam("level") String level,
                            @RequestParam("name") String name,
                            @RequestParam("keywords") String keywords,
                            @RequestParam("frontName") String frontName,
                            @RequestParam("frontDesc") String frontDesc,
                            @RequestParam("parentId") int parentId,
                            @RequestParam("sortOrder") int sortOrder,
                            @RequestParam("showIndex") int showIndex,
                            @RequestParam("bannerUrl") String bannerUrl,
                            @RequestParam("iconUrl") String iconUrl,
                            @RequestParam("imgUrl") String imgUrl,
                            @RequestParam("wapBannerUrl") String wapBannerUrl) {
        Category category = new Category();

        category.setLevel(level);
        category.setName(name);
        category.setKeywords(keywords);
        category.setFrontName(frontName);
        category.setFrontDesc(frontDesc);
        category.setParentId(parentId);
        category.setSortOrder(sortOrder);
        category.setShowIndex(showIndex);
        category.setBannerUrl(bannerUrl);
        category.setIconUrl(iconUrl);
        category.setImgUrl(imgUrl);
        category.setWapBannerUrl(wapBannerUrl);

        categoryService.insertSelective(category);

        return BaseResponse.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse update(@RequestParam("id") int id,
                               @RequestParam("level") String level,
                               @RequestParam("name") String name,
                               @RequestParam("keywords") String keywords,
                               @RequestParam("frontName") String frontName,
                               @RequestParam("frontDesc") String frontDesc,
                               @RequestParam("parentId") int parentId,
                               @RequestParam("sortOrder") int sortOrder,
                               @RequestParam("showIndex") int showIndex,
                               @RequestParam("bannerUrl") String bannerUrl,
                               @RequestParam("iconUrl") String iconUrl,
                               @RequestParam("imgUrl") String imgUrl,
                               @RequestParam("wapBannerUrl") String wapBannerUrl
    ) {
        Category category = categoryService.selectByPrimaryKey(id);
        if (category == null) {
            return BaseResponse.fail();
        }

        category.setLevel(level);
        category.setName(name);
        category.setKeywords(keywords);
        category.setFrontName(frontName);
        category.setFrontDesc(frontDesc);
        category.setParentId(parentId);
        category.setSortOrder(sortOrder);
        category.setShowIndex(showIndex);
        category.setBannerUrl(bannerUrl);
        category.setIconUrl(iconUrl);
        category.setImgUrl(imgUrl);
        category.setWapBannerUrl(wapBannerUrl);

        categoryService.updateByPrimaryKeySelective(category);
        return BaseResponse.ok();
    }

}
