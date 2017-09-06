package com.xie.mapper;

import com.xie.bean.GoodsSpecification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsSpecificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSpecification record);

    int insertSelective(GoodsSpecification record);

    GoodsSpecification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsSpecification record);

    int updateByPrimaryKey(GoodsSpecification record);

    List<GoodsSpecification> selectByGoodsId(Integer gid);

    List<GoodsSpecification> selectByPrimaryKeyAndGoodsId(@Param("ids") List<Integer> ids, @Param("gid") Integer gid);
}