package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Attribute;

public interface AttributeService {
    int deleteByPrimaryKey(Integer id);

    int insert(Attribute record);

    int insertSelective(Attribute record);

    Attribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attribute record);

    int updateByPrimaryKeyWithBLOBs(Attribute record);

    int updateByPrimaryKey(Attribute record);

    PageInfo<Attribute> select(int pageNum, int pageSize);

    PageInfo<Attribute> selectByAttributeCategory(int attributeCategory, int pageNum, int pageSize);

    int count();
}