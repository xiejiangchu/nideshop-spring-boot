package com.xie.mapper;

import com.xie.bean.Footprint;
import com.xie.bean.FootprintWithGoods;

import java.util.List;

public interface FootprintMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    Footprint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);

    List<FootprintWithGoods> selectByUid(Integer uid);
}