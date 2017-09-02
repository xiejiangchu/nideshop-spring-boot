package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Category;
import com.xie.bean.CategoryShort;

import java.util.List;

/**
 * Created by xie on 17/8/21.
 */
public interface CategoryService {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    CategoryShort selectShortByPrimaryKey(Integer id);

    List<Category> selectByParent(Integer parent_id);

    List<CategoryShort> selectByParents(List<Integer> parent_ids);

    PageInfo<CategoryShort> selectMainCategory(int pageNum, int pageSize);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}
