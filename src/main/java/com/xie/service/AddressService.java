package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Address;
import com.xie.bean.AddressWithName;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
public interface AddressService {

    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    AddressWithName selectWithNameByPrimaryKey(Integer id);

    PageInfo<Address> selectAddress(int pageNum, int pageSize);

    int count();

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> selectByUid(Integer uid);

    List<AddressWithName> selectWithNameByUid(Integer uid);

    Address selectDefaultByUid(Integer uid);

    int updateDefaultByUid(Integer uid);
}
