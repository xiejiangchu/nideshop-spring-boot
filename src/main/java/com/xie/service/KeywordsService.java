package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Keywords;
import com.xie.bean.KeywordsKey;

import java.util.List;

public interface KeywordsService {
    int deleteByPrimaryKey(KeywordsKey key);

    int insert(Keywords record);

    int insertSelective(Keywords record);

    Keywords selectByPrimaryKey(KeywordsKey key);

    List<Keywords> selectLikePrimaryKey(String keyword);

    int updateByPrimaryKeySelective(Keywords record);

    int updateByPrimaryKey(Keywords record);

    PageInfo<Keywords> defaultKeyword(int pageNum, int pageSize);

    PageInfo<Keywords> hotKeyword(int pageNum, int pageSize);
}