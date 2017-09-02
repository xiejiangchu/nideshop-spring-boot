package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.bean.Attribute;
import com.xie.mapper.AttributeMapper;
import com.xie.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/30.
 */
@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeMapper attributeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return attributeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Attribute record) {
        return attributeMapper.insert(record);
    }

    @Override
    public int insertSelective(Attribute record) {
        return attributeMapper.insertSelective(record);
    }

    @Override
    public Attribute selectByPrimaryKey(Integer id) {
        return attributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Attribute record) {
        return attributeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Attribute record) {
        return attributeMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Attribute record) {
        return attributeMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Attribute> select(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Attribute> page = new PageInfo<Attribute>(attributeMapper.select());
        return page;
    }

    @Override
    public PageInfo<Attribute> selectByAttributeCategory(int attributeCategory, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Attribute> page = new PageInfo<Attribute>(attributeMapper.selectByAttributeCategory(attributeCategory));
        return page;
    }

    @Override
    public int count() {
        return attributeMapper.count();
    }
}
