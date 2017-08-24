package com.xie.service.impl;

import com.xie.bean.Specification;
import com.xie.mapper.SpecificationMapper;
import com.xie.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecificationMapper specificationMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return specificationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Specification record) {
        return specificationMapper.insert(record);
    }

    @Override
    public int insertSelective(Specification record) {
        return specificationMapper.insertSelective(record);
    }

    @Override
    public Specification selectByPrimaryKey(Integer id) {
        return specificationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Specification record) {
        return specificationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Specification record) {
        return specificationMapper.updateByPrimaryKey(record);
    }
}
