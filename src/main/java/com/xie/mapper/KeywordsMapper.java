package com.xie.mapper;

import com.xie.bean.Keywords;
import com.xie.bean.KeywordsKey;

public interface KeywordsMapper {
    int deleteByPrimaryKey(KeywordsKey key);

    int insert(Keywords record);

    int insertSelective(Keywords record);

    Keywords selectByPrimaryKey(KeywordsKey key);

    int updateByPrimaryKeySelective(Keywords record);

    int updateByPrimaryKey(Keywords record);
}