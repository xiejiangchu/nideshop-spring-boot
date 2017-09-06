package com.xie.mapper;

import com.xie.bean.Collect;
import com.xie.bean.CollectWithGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer id);

    Collect selectByParams(@Param("user_id") Integer userId, @Param("type_id") Integer typeId, @Param("value_id") Integer valueId);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    List<CollectWithGoods> selectByUid(@Param("uid") Integer uid, @Param("typeId") Integer typeId);
}