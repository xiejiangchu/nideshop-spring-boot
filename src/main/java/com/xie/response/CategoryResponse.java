package com.xie.response;

import com.xie.bean.Category;

import java.util.List;

/**
 * Created by xie on 17/8/26.
 */
public class CategoryResponse {

    private List<Category> categoryList;
    private Category currentCategory;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Category getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
    }
}
