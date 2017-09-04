package com.xie.service;

import com.xie.bean.Product;

import java.util.List;

public interface ProductService {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectByGoodsId(Integer goodsId);

    Product selectByPrimaryKeyAndGid(Integer id, Integer goodsId);
}