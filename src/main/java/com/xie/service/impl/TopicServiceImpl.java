package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.bean.Topic;
import com.xie.mapper.TopicMapper;
import com.xie.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/21.
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return topicMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Topic record) {
        return topicMapper.insert(record);
    }

    @Override
    public int insertSelective(Topic record) {
        return topicMapper.insertSelective(record);
    }

    @Override
    public Topic selectByPrimaryKey(Integer id) {
        return topicMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Topic record) {
        return topicMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Topic record) {
        return topicMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Topic record) {
        return topicMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Topic> select(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Topic> page = new PageInfo<Topic>(topicMapper.selectAll());
        return page;
    }
}
