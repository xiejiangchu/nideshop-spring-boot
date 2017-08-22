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

    List<Goods> selectAllByCategory(Integer categoryId);

}
