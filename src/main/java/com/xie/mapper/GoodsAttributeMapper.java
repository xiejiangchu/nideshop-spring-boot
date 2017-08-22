package com.xie.mapper;

import com.xie.bean.GoodsAttribute;

import java.util.List;

public interface GoodsAttributeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsAttribute record);

    int insertSelective(GoodsAttribute record);

    GoodsAttribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsAttribute record);

    int updateByPrimaryKeyWithBLOBs(GoodsAttribute record);

    int updateByPrimaryKey(GoodsAttribute record);

    List<GoodsAttribute> selectByGoodsId(Integer gid);
}