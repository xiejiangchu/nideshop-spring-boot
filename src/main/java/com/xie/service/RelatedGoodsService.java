package com.xie.service;

import com.xie.bean.RelatedGoods;

public interface RelatedGoodsService {
    int deleteByPrimaryKey(Integer id);

    int insert(RelatedGoods record);

    int insertSelective(RelatedGoods record);

    RelatedGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RelatedGoods record);

    int updateByPrimaryKey(RelatedGoods record);
}