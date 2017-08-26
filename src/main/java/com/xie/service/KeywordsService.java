package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Keywords;
import com.xie.bean.KeywordsKey;

public interface KeywordsService {
    int deleteByPrimaryKey(KeywordsKey key);

    int insert(Keywords record);

    int insertSelective(Keywords record);

    Keywords selectByPrimaryKey(KeywordsKey key);

    int updateByPrimaryKeySelective(Keywords record);

    int updateByPrimaryKey(Keywords record);

    PageInfo<Keywords> defaultKeyword(int pageNum,int pageSize);

    PageInfo<Keywords> hotKeyword(int pageNum,int pageSize);
}