package com.xie.mapper;

import com.xie.bean.Goods;
import com.xie.bean.GoodsShort;
import org.apache.ibatis.annotations.Param;

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

    GoodsShort selectPartialByPrimaryKey(Integer id);

    List<GoodsShort> selectPartialByPrimaryKeys(List<Integer> ids);

    List<Goods> selectAllByCategory(Integer categoryId);

    List<Goods> selectByParams(@Param("categoryId") Integer categoryId,
                               @Param("brandId") Integer brandId,
                               @Param("keyword") String keyword,
                               @Param("isHot") Integer isHot,
                               @Param("isNew") Integer isNew,
                               @Param("sort") String sort,
                               @Param("order") Integer order);

    int count();
}