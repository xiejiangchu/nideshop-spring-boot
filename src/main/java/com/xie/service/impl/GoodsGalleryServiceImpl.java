package com.xie.service.impl;

import com.xie.bean.GoodsGallery;
import com.xie.mapper.GoodsGalleryMapper;
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
    private GoodsGalleryMapper goodsGalleryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsGalleryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByGoodsId(Integer gid) {
        return goodsGalleryMapper.deleteByGoodsId(gid);
    }

    @Override
    public int insert(GoodsGallery record) {
        return goodsGalleryMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsGallery record) {
        return goodsGalleryMapper.insertSelective(record);
    }

    @Override
    public GoodsGallery selectByPrimaryKey(Integer id) {
        return goodsGalleryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsGallery record) {
        return goodsGalleryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsGallery record) {
        return goodsGalleryMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<GoodsGallery> selectByGoodsId(Integer gid) {
        return goodsGalleryMapper.selectByGoodsId(gid);
    }
}
