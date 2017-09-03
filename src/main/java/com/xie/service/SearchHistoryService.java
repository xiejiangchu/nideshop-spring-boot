package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.SearchHistory;

public interface SearchHistoryService {
    int deleteByPrimaryKey(Integer id);

    int insert(SearchHistory record);

    int insertSelective(SearchHistory record);

    SearchHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SearchHistory record);

    int updateByPrimaryKey(SearchHistory record);


    int deleteByUid(Integer uid);

    PageInfo<SearchHistory> historyKeyword(int uid, int pageNum, int pageSize);
}