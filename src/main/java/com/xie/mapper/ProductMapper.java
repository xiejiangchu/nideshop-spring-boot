package com.xie.mapper;

import com.xie.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyAndGid(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectByGoodsId(Integer goodsId);

    Product selectByPrimaryKeyAndGid(@Param("id") Integer id, @Param("goodsId") Integer goodsId);
}