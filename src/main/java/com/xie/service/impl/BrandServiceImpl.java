package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.bean.Brand;
import com.xie.mapper.BrandMapper;
import com.xie.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/21.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Brand record) {
        return brandMapper.insert(record);
    }

    @Override
    public int insertSelective(Brand record) {
        return brandMapper.insertSelective(record);
    }

    @Override
    public Brand selectByPrimaryKey(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Brand record) {
        return brandMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Brand record) {
        return brandMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Brand> selectNewBrands(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Brand> page = new PageInfo<Brand>(brandMapper.selectNewBrands());
        return page;
    }

    @Override
    public PageInfo<Brand> select(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Brand> page = new PageInfo<Brand>(brandMapper.select());
        return page;
    }
}
