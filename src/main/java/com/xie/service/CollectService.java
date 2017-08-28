package com.xie.service;

import com.xie.bean.Collect;
import com.xie.bean.CollectWithGoods;

import java.util.List;

/**
 * Created by xie on 17/8/23.
 */
public interface CollectService {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer id);

    Collect selectByParams(Integer uid, Integer typeId, Integer valueId);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    List<CollectWithGoods> selectByUid(Integer uid, Integer typeId);
}
