package com.xie.service.impl;

import com.xie.bean.PermissionRoleKey;
import com.xie.mapper.PermissionRoleMapper;
import com.xie.service.PermissionRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class PermissionRoleServiceImpl implements PermissionRoleService {

    @Autowired
    private PermissionRoleMapper permissionRoleMapper;

    @Override
    public int deleteByPrimaryKey(PermissionRoleKey key) {
        return permissionRoleMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(PermissionRoleKey record) {
        return permissionRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(PermissionRoleKey record) {
        return permissionRoleMapper.insertSelective(record);
    }
}
