package com.xie.service.impl;

import com.xie.bean.GoodsAttribute;
import com.xie.mapper.GoodsAttributeMapper;
import com.xie.service.GoodsAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
@Service
public class GoodsAttributeServiceImpl implements GoodsAttributeService {

    @Autowired
    private GoodsAttributeMapper goodsAttributeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsAttributeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsAttribute record) {
        return goodsAttributeMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsAttribute record) {
        return goodsAttributeMapper.insertSelective(record);
    }

    @Override
    public GoodsAttribute selectByPrimaryKey(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsAttribute record) {
        return goodsAttributeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(GoodsAttribute record) {
        return goodsAttributeMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsAttribute record) {
        return goodsAttributeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<GoodsAttribute> selectByGoodsId(Integer gid) {
        return goodsAttributeMapper.selectByGoodsId(gid);
    }
}
