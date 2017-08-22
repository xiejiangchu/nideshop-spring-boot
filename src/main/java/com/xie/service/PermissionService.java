package com.xie.service;

import com.xie.bean.Permissions;

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
public interface PermissionService {

    Permissions getById(int id);

    List<Permissions> getByUid(int uid);

    int checkPermission(int uid, String permission);

    int insert(Permissions permission);

    int update(Permissions permission);

    int delete(Permissions permission);

    int delete(int id);
}
