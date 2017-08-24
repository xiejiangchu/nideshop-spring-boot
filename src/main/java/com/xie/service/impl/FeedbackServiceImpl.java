package com.xie.service.impl;

import com.xie.bean.Feedback;
import com.xie.mapper.FeedbackMapper;
import com.xie.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public int deleteByPrimaryKey(Integer msgId) {
        return feedbackMapper.deleteByPrimaryKey(msgId);
    }

    @Override
    public int insert(Feedback record) {
        return feedbackMapper.insert(record);
    }

    @Override
    public int insertSelective(Feedback record) {
        return feedbackMapper.insertSelective(record);
    }

    @Override
    public Feedback selectByPrimaryKey(Integer msgId) {
        return feedbackMapper.selectByPrimaryKey(msgId);
    }

    @Override
    public int updateByPrimaryKeySelective(Feedback record) {
        return feedbackMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Feedback record) {
        return feedbackMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Feedback record) {
        return feedbackMapper.updateByPrimaryKey(record);
    }
}
