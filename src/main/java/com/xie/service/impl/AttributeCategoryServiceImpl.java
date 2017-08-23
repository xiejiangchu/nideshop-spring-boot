package com.xie.service.impl;

import com.xie.bean.AttributeCategory;
import com.xie.mapper.AttributeCategoryMapper;
import com.xie.service.AttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class AttributeCategoryServiceImpl implements AttributeCategoryService {

    @Autowired
    private AttributeCategoryMapper attributeCategoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return attributeCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AttributeCategory record) {
        return attributeCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(AttributeCategory record) {
        return attributeCategoryMapper.insertSelective(record);
    }

    @Override
    public AttributeCategory selectByPrimaryKey(Integer id) {
        return attributeCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AttributeCategory record) {
        return attributeCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AttributeCategory record) {
        return attributeCategoryMapper.updateByPrimaryKey(record);
    }
}
