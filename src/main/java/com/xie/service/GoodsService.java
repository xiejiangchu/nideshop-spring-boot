package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Goods;
import com.xie.bean.GoodsShort;

import java.util.List;

/**
 * Created by xie on 17/8/21.
 */
public interface GoodsService {

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    PageInfo<Goods> selectHotGoods(int pageNum, int pageSize);

    PageInfo<Goods> selectNewGoods(int pageNum, int pageSize);

    List<GoodsShort> selectPartialByCategory(Integer categoryId);

    GoodsShort selectPartialByPrimaryKey(Integer id);

    List<GoodsShort> selectPartialByPrimaryKeys(List<Integer> ids);

    List<Goods> selectAllByCategory(Integer categoryId);

    PageInfo<Goods> selectByParams(Integer categoryId, Integer brandId, String keyword, Integer isHot, Integer isNew, String sort, Integer order, int page, int size);

    int count();

}
