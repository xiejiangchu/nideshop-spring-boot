package com.xie.service;

import com.xie.bean.GoodsGallery;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
public interface GoodsGalleryService {

    int deleteByPrimaryKey(Integer id);

    int deleteByGoodsId(Integer gid);

    int insert(GoodsGallery record);

    int insertSelective(GoodsGallery record);

    GoodsGallery selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsGallery record);

    int updateByPrimaryKey(GoodsGallery record);

    List<GoodsGallery> selectByGoodsId(Integer gid);
}
