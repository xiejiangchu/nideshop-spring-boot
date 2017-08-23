package com.xie.service;

import com.xie.bean.UserLevel;

public interface UserLevelService {
    int deleteByPrimaryKey(Byte id);

    int insert(UserLevel record);

    int insertSelective(UserLevel record);

    UserLevel selectByPrimaryKey(Byte id);

    int updateByPrimaryKeySelective(UserLevel record);

    int updateByPrimaryKey(UserLevel record);
}