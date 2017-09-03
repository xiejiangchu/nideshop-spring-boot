package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.bean.Ad;
import com.xie.mapper.AdMapper;
import com.xie.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xie on 17/8/21.
 */
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdMapper adMapper;

    @Override
    public int deleteByPrimaryKey(Short id) {
        return adMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Ad record) {
        return adMapper.insert(record);
    }

    @Override
    public int insertSelective(Ad record) {
        return adMapper.insertSelective(record);
    }

    @Override
    public Ad selectByPrimaryKey(Short id) {
        return adMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Ad record) {
        return adMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Ad record) {
        return adMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Ad record) {
        return adMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Ad> selectByPosition(int position) {
        return adMapper.selectByPosition(position);
    }

    @Override
    public PageInfo<Ad> select(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Ad> page = new PageInfo<Ad>(adMapper.select());
        return page;
    }

    @Override
    public int count() {
        return adMapper.count();
    }
}
