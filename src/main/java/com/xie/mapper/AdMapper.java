package com.xie.mapper;

import com.xie.bean.Ad;

import java.util.List;

public interface AdMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKeyWithBLOBs(Ad record);

    int updateByPrimaryKey(Ad record);

    List<Ad> selectByPosition(int position);
}