package com.xie.service;

import com.xie.bean.PermissionRoleKey;

public interface PermissionRoleService {
    int deleteByPrimaryKey(PermissionRoleKey key);

    int insert(PermissionRoleKey record);

    int insertSelective(PermissionRoleKey record);
}