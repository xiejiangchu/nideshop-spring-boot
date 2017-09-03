package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.bean.Keywords;
import com.xie.bean.KeywordsKey;
import com.xie.mapper.KeywordsMapper;
import com.xie.service.KeywordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class KeywordsServiceImpl implements KeywordsService {

    @Autowired
    private KeywordsMapper keywordsMapper;

    @Override
    public int deleteByPrimaryKey(KeywordsKey key) {
        return keywordsMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(Keywords record) {
        return keywordsMapper.insert(record);
    }

    @Override
    public int insertSelective(Keywords record) {
        return keywordsMapper.insertSelective(record);
    }

    @Override
    public Keywords selectByPrimaryKey(KeywordsKey key) {
        return keywordsMapper.selectByPrimaryKey(key);
    }

    @Override
    public List<Keywords> selectLikePrimaryKey(String keyword) {
        return keywordsMapper.selectLikePrimaryKey(keyword);
    }

    @Override
    public int updateByPrimaryKeySelective(Keywords record) {
        return keywordsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Keywords record) {
        return keywordsMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Keywords> defaultKeyword(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Keywords> page = new PageInfo<Keywords>(keywordsMapper.defaultKeyword());
        return page;
    }

    @Override
    public PageInfo<Keywords> hotKeyword(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Keywords> page = new PageInfo<Keywords>(keywordsMapper.hotKeyword());
        return page;
    }
}
