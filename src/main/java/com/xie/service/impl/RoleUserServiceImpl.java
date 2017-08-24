package com.xie.service.impl;

import com.xie.bean.RoleUserKey;
import com.xie.mapper.RoleUserMapper;
import com.xie.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class RoleUserServiceImpl implements RoleUserService {

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public int deleteByPrimaryKey(RoleUserKey key) {
        return roleUserMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(RoleUserKey record) {
        return roleUserMapper.insert(record);
    }

    @Override
    public int insertSelective(RoleUserKey record) {
        return roleUserMapper.insertSelective(record);
    }
}
