package com.xie.service.impl;

import com.xie.bean.TopicCategory;
import com.xie.mapper.TopicCategoryMapper;
import com.xie.service.TopicCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class TopicCategoryServiceImpl implements TopicCategoryService {

    @Autowired
    private TopicCategoryMapper topicCategoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return topicCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TopicCategory record) {
        return topicCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(TopicCategory record) {
        return topicCategoryMapper.insertSelective(record);
    }

    @Override
    public TopicCategory selectByPrimaryKey(Integer id) {
        return topicCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TopicCategory record) {
        return topicCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TopicCategory record) {
        return topicCategoryMapper.updateByPrimaryKey(record);
    }
}
