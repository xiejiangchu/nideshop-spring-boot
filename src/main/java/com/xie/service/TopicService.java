package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Topic;

/**
 * Created by xie on 17/8/21.
 */
public interface TopicService {
    int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);

    PageInfo<Topic> select(int pageNum, int pageSize);
}
