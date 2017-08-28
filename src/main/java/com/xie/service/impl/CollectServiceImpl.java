package com.xie.service.impl;

import com.xie.bean.Collect;
import com.xie.bean.CollectWithGoods;
import com.xie.mapper.CollectMapper;
import com.xie.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return collectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Collect record) {
        return collectMapper.insert(record);
    }

    @Override
    public int insertSelective(Collect record) {
        return collectMapper.insertSelective(record);
    }

    @Override
    public Collect selectByPrimaryKey(Integer id) {
        return collectMapper.selectByPrimaryKey(id);
    }

    @Override
    public Collect selectByParams(Integer uid, Integer typeId, Integer valueId) {
        return collectMapper.selectByParams(uid, typeId, valueId);
    }

    @Override
    public int updateByPrimaryKeySelective(Collect record) {
        return collectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Collect record) {
        return collectMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CollectWithGoods> selectByUid(Integer uid, Integer typeId) {
        return collectMapper.selectByUid(uid, typeId);
    }
}
