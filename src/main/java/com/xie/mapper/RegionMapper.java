package com.xie.mapper;

import com.xie.bean.Region;

import java.util.List;

public interface RegionMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);

    List<Region> selectByPatentId(Integer parent_id);
}