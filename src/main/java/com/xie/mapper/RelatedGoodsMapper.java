package com.xie.mapper;

import com.xie.bean.RelatedGoods;

public interface RelatedGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RelatedGoods record);

    int insertSelective(RelatedGoods record);

    RelatedGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RelatedGoods record);

    int updateByPrimaryKey(RelatedGoods record);
}