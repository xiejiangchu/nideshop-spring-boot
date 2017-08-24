package com.xie.service.impl;

import com.xie.bean.RelatedGoods;
import com.xie.mapper.RelatedGoodsMapper;
import com.xie.service.RelatedGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class RelatedGoodsServiceImpl implements RelatedGoodsService {

    @Autowired
    private RelatedGoodsMapper relatedGoodsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return relatedGoodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RelatedGoods record) {
        return relatedGoodsMapper.insert(record);
    }

    @Override
    public int insertSelective(RelatedGoods record) {
        return relatedGoodsMapper.insertSelective(record);
    }

    @Override
    public RelatedGoods selectByPrimaryKey(Integer id) {
        return relatedGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RelatedGoods record) {
        return relatedGoodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RelatedGoods record) {
        return relatedGoodsMapper.updateByPrimaryKey(record);
    }
}
