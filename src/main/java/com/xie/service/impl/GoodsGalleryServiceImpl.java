package com.xie.service.impl;

import com.xie.bean.GoodsGallery;
import com.xie.service.GoodsGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
@Service
public class GoodsGalleryServiceImpl implements GoodsGalleryService {

    @Autowired
    private GoodsGalleryService goodsGalleryService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsGalleryService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsGallery record) {
        return goodsGalleryService.insert(record);
    }

    @Override
    public int insertSelective(GoodsGallery record) {
        return goodsGalleryService.insertSelective(record);
    }

    @Override
    public GoodsGallery selectByPrimaryKey(Integer id) {
        return goodsGalleryService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsGallery record) {
        return goodsGalleryService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsGallery record) {
        return goodsGalleryService.updateByPrimaryKey(record);
    }

    @Override
    public List<GoodsGallery> selectByGoodsId(Integer gid) {
        return goodsGalleryService.selectByGoodsId(gid);
    }
}
