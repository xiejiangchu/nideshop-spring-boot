package com.xie.service.impl;

import com.xie.bean.Permissions;
import com.xie.mapper.PermissionsMapper;
import com.xie.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author xie
 * @summary summary
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @Description To change this template use File | Settings | File Temp
 * lates.
 * @since 2017-03-15 下午3:33
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionsMapper permissionsMapper;

    @Override
    public Permissions getById(int id) {
        return permissionsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Permissions> getByUid(int uid) {
        return permissionsMapper.getByUid(uid);
    }

    @Override
    public int checkPermission(int uid, String permission) {
        return permissionsMapper.checkPermission(uid, permission);
    }

    @Override
    public int insert(Permissions permission) {
        return permissionsMapper.insert(permission);
    }

    @Override
    public int update(Permissions permission) {
        return permissionsMapper.updateByPrimaryKey(permission);
    }

    @Override
    public int delete(Permissions permission) {
        return permissionsMapper.deleteByPrimaryKey(permission.getId());
    }

    @Override
    public int delete(int id) {
        return permissionsMapper.deleteByPrimaryKey(id);
    }
}
