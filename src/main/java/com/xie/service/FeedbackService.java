package com.xie.service;

import com.xie.bean.Feedback;

public interface FeedbackService {
    int deleteByPrimaryKey(Integer msgId);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer msgId);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKeyWithBLOBs(Feedback record);

    int updateByPrimaryKey(Feedback record);
}