package com.xie.service.impl;

import com.xie.bean.Category;
import com.xie.bean.CategoryShort;
import com.xie.mapper.CategoryMapper;
import com.xie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xie on 17/8/21.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }

    @Override
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Category> selectByParent(Integer parent_id) {
        return categoryMapper.selectByParent(parent_id);
    }

    @Override
    public List<CategoryShort> selectByParents(List<Integer> parent_ids) {
        return categoryMapper.selectByParents(parent_ids);
    }

    @Override
    public List<CategoryShort> selectMainCategory() {
        return categoryMapper.selectMainCategory();
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }
}
