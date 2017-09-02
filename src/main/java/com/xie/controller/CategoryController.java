package com.xie.controller;

import com.xie.bean.CategoryShort;
import com.xie.response.BaseResponse;
import com.xie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xie on 17/9/2.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse index(@PathVariable(value = "id", required = false) Integer id) {
        List<CategoryShort> subCategoryShortList = categoryService.selectByParents(Arrays.asList(id));
        return BaseResponse.ok(subCategoryShortList);
    }
}
