package com.xie.mapper;

import com.xie.bean.Address;
import com.xie.bean.AddressWithName;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> selectByUid(Integer uid);

    List<AddressWithName> selectWithNameByUid(Integer uid);

    Address selectDefaultByUid(Integer id);

    AddressWithName selectWithNameByPrimaryKey(Integer id);

    int updateDefaultByUid(Integer uid);

    List<Address> selectAllAddress();

    int count();
}