package com.xie.service;

import com.xie.bean.Address;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
public interface AddressService {

    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> selectByUid(Integer uid);

    Address selectDefaultByUid(Integer uid);
}
