package com.xie.mapper;

import com.xie.bean.Category;
import com.xie.bean.CategoryShort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    CategoryShort selectShortByPrimaryKey(Integer id);

    List<Category> selectByParent(Integer parent_id);

    List<CategoryShort> selectByParents(@Param("parent_ids") List<Integer> parent_ids);

    List<CategoryShort> selectMainCategory();

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}