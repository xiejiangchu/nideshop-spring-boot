package com.xie.response;

import com.xie.bean.Category;
import com.xie.bean.GoodsShort;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
public class CategoryGoodsResponse {
    Category currentCategory;
    Category parentCategory;
    List<Category> brotherCategory;
    List<GoodsShort> categoryGoods;

    public Category getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Category> getBrotherCategory() {
        return brotherCategory;
    }

    public void setBrotherCategory(List<Category> brotherCategory) {
        this.brotherCategory = brotherCategory;
    }

    public List<GoodsShort> getCategoryGoods() {
        return categoryGoods;
    }

    public void setCategoryGoods(List<GoodsShort> categoryGoods) {
        this.categoryGoods = categoryGoods;
    }
}
