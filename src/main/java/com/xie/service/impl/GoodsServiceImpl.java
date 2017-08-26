package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.bean.Goods;
import com.xie.bean.GoodsShort;
import com.xie.mapper.GoodsMapper;
import com.xie.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xie on 17/8/21.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    @Override
    public int insertSelective(Goods record) {
        return goodsMapper.insertSelective(record);
    }

    @Override
    public Goods selectByPrimaryKey(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Goods record) {
        return goodsMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Goods record) {
        return goodsMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Goods> selectHotGoods(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Goods> page = new PageInfo<Goods>(goodsMapper.selectHotGoods());
        return page;
    }

    @Override
    public PageInfo<Goods> selectNewGoods(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Goods> page = new PageInfo<Goods>(goodsMapper.selectNewGoods());
        return page;
    }

    @Override
    public List<GoodsShort> selectPartialByCategory(Integer categoryId) {
        return goodsMapper.selectPartialByCategory(categoryId);
    }

    @Override
    public List<Goods> selectAllByCategory(Integer categoryId) {
        return goodsMapper.selectAllByCategory(categoryId);
    }

    @Override
    public PageInfo<Goods> selectByParams(Integer categoryId, Integer brandId, String keyword, Integer isHot, Integer isNew, String sort, Integer order, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Goods> page = new PageInfo<Goods>(goodsMapper.selectByParams(categoryId, brandId, keyword, isHot, isNew, sort, order));
        return page;
    }

    @Override
    public int count() {
        return goodsMapper.count();
    }
}
