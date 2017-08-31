package com.xie.controller;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Attribute;
import com.xie.controller.api.BaseController;
import com.xie.service.AttributeService;
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
@RequestMapping("/attribute")
public class AttributeController extends BaseController {

    @Autowired
    private AttributeService attributeService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
                        Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品属性");
        PageInfo<Attribute> attributePageInfo = attributeService.select(pageNum, pageSize);
        model.addAttribute("attributePageInfo", attributePageInfo);
        model.addAttribute("attributeCount", attributeService.count());
        return "attribute";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id") int id, Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品属性详情");
        Attribute attribute = attributeService.selectByPrimaryKey(id);
        model.addAttribute("attribute", attribute);
        return "attributeDetail";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") int id) {
        attributeService.deleteByPrimaryKey(id);
        return "redirect:/attribute";
    }
}
