package com.xie.mapper;

import com.xie.bean.Collect;

public interface CollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}