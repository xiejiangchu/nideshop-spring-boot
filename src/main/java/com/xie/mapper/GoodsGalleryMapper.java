package com.xie.mapper;

import com.xie.bean.GoodsGallery;

import java.util.List;

public interface GoodsGalleryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsGallery record);

    int insertSelective(GoodsGallery record);

    GoodsGallery selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsGallery record);

    int updateByPrimaryKey(GoodsGallery record);

    List<GoodsGallery> selectByGoodsId(Integer gid);

    int deleteByGoodsId(Integer gid);
}