package com.xie.controller;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Attribute;
import com.xie.bean.AttributeCategory;
import com.xie.controller.api.BaseController;
import com.xie.service.AttributeCategoryService;
import com.xie.service.AttributeService;
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
@RequestMapping("/attributeCategory")
public class AttributeCategoryController extends BaseController {

    @Autowired
    private AttributeCategoryService attributeCategoryService;

    @Autowired
    private AttributeService attributeService;


    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
                        Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品属性");
        PageInfo<AttributeCategory> attributeCategoryPageInfo = attributeCategoryService.select(pageNum, pageSize);
        model.addAttribute("attributeCategoryPageInfo", attributeCategoryPageInfo);
        model.addAttribute("attributeCategoryCount", attributeCategoryService.count());


        return "attributeCategory";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品属性新增");
        return "attributeCategoryAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("name") String name,
                      @RequestParam("enabled") int enabled) {
        AttributeCategory attributeCategory = new AttributeCategory();
        attributeCategory.setName(name);
        attributeCategory.setEnabled(enabled);

        attributeCategoryService.insert(attributeCategory);
        return "redirect:/attributeCategory";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id") int id, Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品属性详情");
        AttributeCategory attributeCategory = attributeCategoryService.selectByPrimaryKey(id);
        model.addAttribute("attributeCategory", attributeCategory);

        PageInfo<Attribute> attributePageInfo = attributeService.selectByAttributeCategory(id, 1, 100);
        model.addAttribute("attributePageInfo", attributePageInfo);

        model.addAttribute("inputTypeList", MallConstants.InputType.json());
        return "attributeCategoryDetail";
    }

    @RequestMapping(value = "/enabled", method = RequestMethod.GET)
    public String enabled(@RequestParam(value = "id") int id,
                          @RequestParam(value = "enabled") int enabled,
                          @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {


        AttributeCategory attributeCategory = attributeCategoryService.selectByPrimaryKey(id);
        attributeCategory.setEnabled(enabled);

        attributeCategoryService.updateByPrimaryKey(attributeCategory);

        return "forward:/attributeCategory?pageNum=" + pageNum + "&pageSize=" + pageSize;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") int id,
                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        attributeCategoryService.deleteByPrimaryKey(id);
        return "forward:/attributeCategory?pageNum=" + pageNum + "&pageSize=" + pageSize;
    }
}
