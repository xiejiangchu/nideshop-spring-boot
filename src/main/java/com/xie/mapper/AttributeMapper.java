package com.xie.mapper;

import com.xie.bean.Attribute;

import java.util.List;

public interface AttributeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attribute record);

    int insertSelective(Attribute record);

    Attribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attribute record);

    int updateByPrimaryKeyWithBLOBs(Attribute record);

    int updateByPrimaryKey(Attribute record);

    List<Attribute> select();

    List<Attribute> selectByAttributeCategory(Integer attributeCategory);

    int count();
}