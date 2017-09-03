package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.bean.Category;
import com.xie.bean.CategoryShort;
import com.xie.mapper.CategoryMapper;
import com.xie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
    public CategoryShort selectShortByPrimaryKey(Integer id) {
        return categoryMapper.selectShortByPrimaryKey(id);
    }

    @Override
    public List<CategoryShort> selectShortByPrimaryKeys(List<Integer> ids) {
        Assert.notEmpty(ids);
        return categoryMapper.selectShortByPrimaryKeys(ids);
    }

    @Override
    public List<Category> selectByPrimaryKeys(List<Integer> ids) {
        Assert.notEmpty(ids);
        return categoryMapper.selectByPrimaryKeys(ids);
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
    public PageInfo<CategoryShort> selectMainCategory(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<CategoryShort> page = new PageInfo<CategoryShort>(categoryMapper.selectMainCategory());
        return page;
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
