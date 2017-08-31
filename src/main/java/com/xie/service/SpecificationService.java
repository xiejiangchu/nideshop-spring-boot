package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Specification;

public interface SpecificationService {
    int deleteByPrimaryKey(Integer id);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);

    PageInfo<Specification> select(int pageNum, int pageSize);

    int count();
}