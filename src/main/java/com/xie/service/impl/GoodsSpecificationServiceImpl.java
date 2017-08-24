package com.xie.service.impl;

import com.xie.bean.GoodsSpecification;
import com.xie.mapper.GoodsSpecificationMapper;
import com.xie.service.GoodsSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class GoodsSpecificationServiceImpl implements GoodsSpecificationService {

    @Autowired
    private GoodsSpecificationMapper goodsSpecificationMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsSpecificationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsSpecification record) {
        return goodsSpecificationMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsSpecification record) {
        return goodsSpecificationMapper.insertSelective(record);
    }

    @Override
    public GoodsSpecification selectByPrimaryKey(Integer id) {
        return goodsSpecificationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsSpecification record) {
        return goodsSpecificationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsSpecification record) {
        return goodsSpecificationMapper.updateByPrimaryKey(record);
    }
}
