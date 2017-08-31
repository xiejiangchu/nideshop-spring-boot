package com.xie.service;

import com.xie.bean.GoodsSpecification;

import java.util.List;

/**
 * Created by xie on 17/8/23.
 */
public interface GoodsSpecificationService {

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSpecification record);

    int insertSelective(GoodsSpecification record);

    GoodsSpecification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsSpecification record);

    int updateByPrimaryKey(GoodsSpecification record);

    List<GoodsSpecification> selectByGoodsId(Integer gid);
}
