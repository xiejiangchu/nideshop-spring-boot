package com.xie.mapper;

import com.xie.bean.PermissionRoleKey;

public interface PermissionRoleMapper {
    int deleteByPrimaryKey(PermissionRoleKey key);

    int insert(PermissionRoleKey record);

    int insertSelective(PermissionRoleKey record);
}