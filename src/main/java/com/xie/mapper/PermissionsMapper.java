package com.xie.mapper;

import com.xie.bean.Permissions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    Permissions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);

    public List<Permissions> getByUid(@Param("uid") int uid);

    public int checkPermission(@Param("uid") int uid, @Param("permission") String permission);
}