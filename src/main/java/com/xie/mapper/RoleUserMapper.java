package com.xie.mapper;

import com.xie.bean.RoleUserKey;

public interface RoleUserMapper {
    int deleteByPrimaryKey(RoleUserKey key);

    int insert(RoleUserKey record);

    int insertSelective(RoleUserKey record);
}