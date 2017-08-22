package com.xie.mapper;

import com.xie.bean.Goods;
import com.xie.bean.GoodsShort;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectHotGoods();

    List<Goods> selectNewGoods();

    List<GoodsShort> selectPartialByCategory(Integer categoryId);

    List<Goods> selectAllByCategory(Integer categoryId);
}