package com.xie.mapper;

import com.xie.bean.Roles;

import java.util.List;

public interface RolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);


    public int checkRole(int uid, String name);

    public int assignRole(int uid, int role_id);

    public List<Roles> getRolesByUid(int uid);
}