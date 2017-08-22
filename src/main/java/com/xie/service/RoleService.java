package com.xie.service;

import com.xie.bean.Permissions;
import com.xie.bean.Roles;

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
public interface RoleService {

    Roles getById(int id);

    List<Roles> getRolesByUid(int uid);

    int checkRole(int uid, String name);

    int assignRole(int uid, int role_id);

    int assignRole(int uid, Roles role);

    List<Permissions> getPermissionsByUid(int uid);

    int insert(Roles role);

    int update(Roles role);

    int delete(Roles role);

    int delete(int id);
}
