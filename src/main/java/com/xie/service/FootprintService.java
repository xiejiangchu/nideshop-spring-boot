package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Footprint;
import com.xie.bean.FootprintWithGoods;

public interface FootprintService {
    int deleteByPrimaryKey(Integer id);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    Footprint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);

    PageInfo<FootprintWithGoods> selectByUid(Integer uid,int pageSize,int pageNum);
}