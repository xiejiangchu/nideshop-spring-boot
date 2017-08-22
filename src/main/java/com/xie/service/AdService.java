package com.xie.service;

import com.xie.bean.Ad;

import java.util.List;

/**
 * Created by xie on 17/8/21.
 */
public interface AdService {

    int deleteByPrimaryKey(Short id);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKeyWithBLOBs(Ad record);

    int updateByPrimaryKey(Ad record);

    List<Ad> selectByPosition(int position);
}
