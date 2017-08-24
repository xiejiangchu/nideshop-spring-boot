package com.xie.service;

import com.xie.bean.RoleUserKey;

public interface RoleUserService {
    int deleteByPrimaryKey(RoleUserKey key);

    int insert(RoleUserKey record);

    int insertSelective(RoleUserKey record);
}