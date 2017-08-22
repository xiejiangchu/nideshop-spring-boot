package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Brand;

/**
 * Created by xie on 17/8/21.
 */
public interface BrandService {
    int deleteByPrimaryKey(Integer id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    PageInfo<Brand> selectNewBrands(int pageNum, int pageSize);
}
