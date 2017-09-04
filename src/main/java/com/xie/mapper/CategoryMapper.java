package com.xie.mapper;

import com.xie.bean.Category;
import com.xie.bean.CategoryShort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByParentId(Integer pid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    CategoryShort selectShortByPrimaryKey(Integer id);

    List<CategoryShort> selectShortByPrimaryKeys(@Param("ids") List<Integer> ids);

    List<Category> selectByPrimaryKeys(@Param("ids") List<Integer> ids);

    List<Category> selectByParent(Integer parent_id);

    List<CategoryShort> selectByParents(@Param("parent_ids") List<Integer> parent_ids);

    List<CategoryShort> selectMainCategory();

    List<CategoryShort> selectSubCategory();

    List<Category> selectFullMainCategory();

    List<Category> selectFullSubCategory();

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}