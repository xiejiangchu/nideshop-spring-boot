package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.bean.Goods;
import com.xie.bean.GoodsShort;
import com.xie.bean.GoodsSpecification;
import com.xie.mapper.GoodsMapper;
import com.xie.response.SkuResponse;
import com.xie.service.GoodsService;
import com.xie.service.GoodsSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by xie on 17/8/21.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsSpecificationService goodsSpecificationService;

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
        goodsMapper.insertSelective(record);
        return record.getId();
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
    public PageInfo<Goods> selectGoods(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Goods> page = new PageInfo<Goods>(goodsMapper.selectGoods());
        return page;
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
    public GoodsShort selectPartialByPrimaryKey(Integer id) {
        return goodsMapper.selectPartialByPrimaryKey(id);
    }

    @Override
    public List<GoodsShort> selectPartialByPrimaryKeys(List<Integer> ids) {
        return goodsMapper.selectPartialByPrimaryKeys(ids);
    }

    @Override
    public List<Goods> selectAllByCategory(Integer categoryId) {
        return goodsMapper.selectAllByCategory(categoryId);
    }

    @Override
    public PageInfo<GoodsShort> selectByParams(Integer categoryId, Integer brandId, String keyword, Integer isHot, Integer isNew, String sort, String order, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<GoodsShort> page = new PageInfo<GoodsShort>(goodsMapper.selectByParams(categoryId, brandId, keyword, isHot, isNew, sort, order));
        return page;
    }

    @Override
    public int count() {
        return goodsMapper.count();
    }

    @Override
    public List<SkuResponse> getGoodsSpecificationList(Integer gid) {

        List<GoodsSpecification> goodsSpecificationList = goodsSpecificationService.selectByGoodsId(gid);
        List<SkuResponse> skuResponseList = new ArrayList<>();
        Map<Integer, List<GoodsSpecification>> map = new HashMap<>();
        goodsSpecificationList.forEach(item -> {
            List<GoodsSpecification> list = map.get(item.getSpecificationId());
            if (null == list) {
                list = new ArrayList<GoodsSpecification>();
                list.add(item);
                map.put(item.getSpecificationId(), list);
            } else {
                list.add(item);
            }
        });

        Set s = map.keySet();
        Iterator<Integer> it = s.iterator();
        while (it.hasNext()) {
            Integer key = it.next().intValue();
            List<GoodsSpecification> value = map.get(key);
            SkuResponse sukResponse = new SkuResponse();
            sukResponse.setSpecificationId(value.get(0).getSpecificationId());
            sukResponse.setName(value.get(0).getName());
            sukResponse.setValueList(value);
            skuResponseList.add(sukResponse);
        }

        return skuResponseList;
    }
}
