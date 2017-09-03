package com.xie.mapper;

import com.xie.bean.Keywords;
import com.xie.bean.KeywordsKey;

import java.util.List;

public interface KeywordsMapper {
    int deleteByPrimaryKey(KeywordsKey key);

    int insert(Keywords record);

    int insertSelective(Keywords record);

    Keywords selectByPrimaryKey(KeywordsKey key);

    List<Keywords> selectLikePrimaryKey(String keyword);

    int updateByPrimaryKeySelective(Keywords record);

    int updateByPrimaryKey(Keywords record);

    List<Keywords> defaultKeyword();

    List<Keywords> hotKeyword();
}