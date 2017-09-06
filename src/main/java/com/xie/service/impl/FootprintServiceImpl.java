package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.bean.Footprint;
import com.xie.bean.FootprintWithGoods;
import com.xie.mapper.FootprintMapper;
import com.xie.service.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class FootprintServiceImpl implements FootprintService {

    @Autowired
    private FootprintMapper footprintMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return footprintMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Footprint record) {
        return footprintMapper.insert(record);
    }

    @Override
    public int insertSelective(Footprint record) {
        return footprintMapper.insertSelective(record);
    }

    @Override
    public Footprint selectByPrimaryKey(Integer id) {
        return footprintMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Footprint record) {
        return footprintMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Footprint record) {
        return footprintMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<FootprintWithGoods> selectByUid(Integer uid, int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<FootprintWithGoods> page = new PageInfo<FootprintWithGoods>(footprintMapper.selectByUid(uid));
        return page;
    }
}
