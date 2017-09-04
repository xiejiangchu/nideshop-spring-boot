package com.xie.controller;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Category;
import com.xie.bean.CategoryShort;
import com.xie.controller.api.BaseController;
import com.xie.response.BaseResponse;
import com.xie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xie on 17/9/2.
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "40") int pageSize) {
        return "redirect:/category/l1";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BaseResponse detail(@PathVariable(value = "id", required = false) Integer id) {
        List<CategoryShort> subCategoryShortList = categoryService.selectByParents(Arrays.asList(id));
        return BaseResponse.ok(subCategoryShortList);
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
        model.addAttribute("title", "商品一级分类");
        PageInfo<Category> categoryPageInfo = categoryService.selectFullMainCategory(pageNum, pageSize);

        model.addAttribute("categoryPageInfo", categoryPageInfo);

        return "categoryL1";
    }


    @RequestMapping(value = "/l2", method = RequestMethod.GET)
    public String l2(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                     @RequestParam(value = "pageSize", defaultValue = "40") int pageSize,
                     Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品二级分类");
        PageInfo<Category> categoryPageInfo = categoryService.selectFullSubCategory(pageNum, pageSize);

        model.addAttribute("categoryPageInfo", categoryPageInfo);

        return "categoryL2";
    }
}
