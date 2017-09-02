package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.AttributeCategory;

/**
 * Created by xie on 17/8/23.
 */
public interface AttributeCategoryService {

    int deleteByPrimaryKey(Integer id);

    int insert(AttributeCategory record);

    int insertSelective(AttributeCategory record);

    AttributeCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AttributeCategory record);

    int updateByPrimaryKey(AttributeCategory record);

    PageInfo<AttributeCategory> select(int pageNum, int pageSize);

    int count();
}
