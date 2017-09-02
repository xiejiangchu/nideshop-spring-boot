package com.xie.controller.api;

import com.xie.bean.Category;
import com.xie.response.BaseResponse;
import com.xie.response.CategoryResponse;
import com.xie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
@Controller
@RequestMapping(value = "/api/catalog")
public class CategoryController extends BaseController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsGalleryService goodsGalleryService;

    @Autowired
    private GoodsAttributeService goodsAttributeService;

    @Autowired
    private GoodsIssueService goodsIssueService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse index(@RequestParam(value = "id", required = false) Integer id) {
        Category currentCategory = null;
        if (id != null && id > 0) {
            currentCategory = categoryService.selectByPrimaryKey(id);
        }
        List<Category> categoryList = categoryService.selectByParent(0);
        if (currentCategory == null) {
            currentCategory = categoryList.get(0);
        }
        currentCategory.setSubCategoryList(categoryService.selectByParent(currentCategory.getId()));

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCurrentCategory(currentCategory);
        categoryResponse.setCategoryList(categoryList);

        return BaseResponse.ok(categoryResponse);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse list(@RequestParam(value = "page", required = false) int pageNum,
                      @RequestParam(value = "size", required = false) int pageSize) {

        return BaseResponse.ok(categoryService.selectMainCategory(pageNum, pageSize));
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse current(@RequestParam(value = "id") int id) {

        Category currentCategory = categoryService.selectByPrimaryKey(id);
        currentCategory.setSubCategoryList(categoryService.selectByParent(currentCategory.getId()));
        return BaseResponse.ok(currentCategory);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    BaseResponse post(@RequestBody Category category) {

        return BaseResponse.ok(categoryService.insert(category));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    BaseResponse put(@RequestBody Category category) {

        return BaseResponse.ok(categoryService.updateByPrimaryKey(category));
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    @ResponseBody
    BaseResponse delete(@RequestParam int id) {

        return BaseResponse.ok(categoryService.deleteByPrimaryKey(id));
    }
}
