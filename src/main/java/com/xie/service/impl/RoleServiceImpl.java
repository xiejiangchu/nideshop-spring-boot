package com.xie.service.impl;

import com.xie.bean.Permissions;
import com.xie.bean.Roles;
import com.xie.mapper.PermissionsMapper;
import com.xie.mapper.RolesMapper;
import com.xie.service.RoleService;
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
 * @since 2017-03-15 下午3:52
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private PermissionsMapper permissionsMapper;

    @Autowired
    private RolesMapper rolesMapper;

    @Override
    public Roles getById(int id) {
        return rolesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int checkRole(int uid, String name) {
        return rolesMapper.checkRole(uid, name);
    }

    @Override
    public List<Roles> getRolesByUid(int uid) {
        return rolesMapper.getRolesByUid(uid);
    }

    @Override
    public int assignRole(int uid, int role_id) {
        return rolesMapper.assignRole(uid, role_id);
    }

    @Override
    public int assignRole(int uid, Roles role) {
        int role_id = role.getId();
        return rolesMapper.assignRole(uid, role_id);
    }

    @Override
    public List<Permissions> getPermissionsByUid(int uid) {
        return permissionsMapper.getByUid(uid);
    }

    @Override
    public int insert(Roles role) {
        return rolesMapper.insert(role);
    }

    @Override
    public int update(Roles role) {
        return rolesMapper.updateByPrimaryKey(role);
    }

    @Override
    public int delete(Roles role) {
        return rolesMapper.deleteByPrimaryKey(role.getId());
    }

    @Override
    public int delete(int id) {
        return rolesMapper.deleteByPrimaryKey(id);
    }
}
