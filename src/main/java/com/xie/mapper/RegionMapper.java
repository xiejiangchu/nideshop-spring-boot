package com.xie.mapper;

import com.xie.bean.Region;

public interface RegionMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
}