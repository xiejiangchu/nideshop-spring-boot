package com.xie.service.impl;

import com.xie.bean.UserLevel;
import com.xie.mapper.UserLevelMapper;
import com.xie.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class UserLevelServiceImpl implements UserLevelService {

    @Autowired
    private UserLevelMapper userLevelMapper;

    @Override
    public int deleteByPrimaryKey(Byte id) {
        return userLevelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserLevel record) {
        return userLevelMapper.insert(record);
    }

    @Override
    public int insertSelective(UserLevel record) {
        return userLevelMapper.insertSelective(record);
    }

    @Override
    public UserLevel selectByPrimaryKey(Byte id) {
        return userLevelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserLevel record) {
        return userLevelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserLevel record) {
        return userLevelMapper.updateByPrimaryKey(record);
    }
}
